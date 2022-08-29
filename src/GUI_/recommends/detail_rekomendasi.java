/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_.recommends;

import MODEL_.M_MAE;
import MODEL_.M_Recommender;
import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import recommend_engine.denominator;
import recommend_engine.numerator;

/**
 *
 * @author frans
 */
public class detail_rekomendasi extends javax.swing.JFrame {

    /**
     * Creates new form detail_rekomendasi
     */
    public detail_rekomendasi(int user_id) {
        System.out.println("PROCESSING...");
        initComponents();
        this.setLocationRelativeTo(null);
        System.out.println("user_id = "+user_id);
        txtlabel_namauser1.setText(Integer.toString(user_id));
        load_datas(user_id);
    }

    private void load_datas(int userID) {
        DefaultTableModel tblModel = new DefaultTableModel(new String[]{"BOOK ID", "PERCENTAGE"}, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        try {
            connectorDb koneksi = new connectorDb();
            Connection konek = koneksi.getConnection();

            Statement stmt = konek.createStatement();
//            String query = "SELECT * FROM tabel_rating\n"
//                    + "JOIN tabel_user ON tabel_rating.user_id=tabel_user.user_id\n"
//                    + "JOIN tabel_buku ON tabel_rating.book_id=tabel_buku._id\n"
//                    + "WHERE tabel_rating.user_id!='"+userID+"'";
//            String query = "SELECT * FROM tabel_rating\n"
//                    + "JOIN tabel_user ON tabel_rating.user_id=tabel_user.user_id\n"
//                    + "JOIN tabel_buku ON tabel_rating.book_id=tabel_buku._id\n"
//                    + "WHERE tabel_rating.user_id!='"+userID+"' GROUP BY tabel_buku._id";
            String query = "SELECT * FROM tabel_rating\n"
                    + "JOIN tabel_user ON tabel_rating.user_id=tabel_user.user_id\n"
                    + "JOIN tabel_buku ON tabel_rating.book_id=tabel_buku._id\n"
                    + "GROUP BY tabel_buku._id";

            ResultSet rs = stmt.executeQuery(query);

            Statement stmt2 = konek.createStatement();
            String query2 = "SELECT *, AVG(book_rating) AS avg_ratings FROM tabel_rating \n"
                    + "JOIN tabel_user ON tabel_rating.user_id=tabel_user.user_id\n"
                    + "WHERE tabel_rating.user_id='" + userID + "'";

            ResultSet rs2 = stmt2.executeQuery(query2);

            String avgrtg = "0", ax = "0";

            if (rs2.next()) {
                avgrtg = rs2.getString("avg_ratings");
                ax = rs2.getString("user_age");
            }

            String[] str1 = {avgrtg, ax};

            ArrayList<M_MAE> pred_ratings = new ArrayList<M_MAE>();
            ArrayList<M_Recommender> arrL_Rec = new ArrayList<M_Recommender>();
            while (rs.next()) {
                M_Recommender recomm = new M_Recommender();
                M_MAE model_mae_pred = new M_MAE();
                String rtg = rs.getString("book_rating");
                String x = rs.getString("user_age");

                recomm.setUser_id(rs.getInt("user_id"));
                recomm.setBook_id(rs.getInt("book_id"));

                String[] str2 = {rtg, x};

                double CORR = 0.0;
                List<String> xList = new ArrayList<String>(Arrays.asList(str1));
                List<String> yList = new ArrayList<String>(Arrays.asList(str2));

                numerator nc = new numerator(xList, yList);
                double ba = nc.hitungBtsAtas();
                denominator dc = new denominator();
                double bb = dc.hituungBtsBwh(xList, yList);
                CORR = ba / bb;

                recomm.setPearson_value(CORR);
                model_mae_pred.setBook_id(rs.getInt("book_id"));
                model_mae_pred.setBook_rating_prediction(CORR);
                pred_ratings.add(model_mae_pred);
                arrL_Rec.add(recomm);

                tblModel.addRow(new Object[]{Integer.toString(recomm.getBook_id()), Double.toString(CORR)});

            }

            for (int i = 0; i < arrL_Rec.size(); i++) {
                System.out.println(arrL_Rec.get(i));
            }

            //MAE CALCULATION
            Statement stmt3 = konek.createStatement();
            String get_RealRating = "SELECT tabel_rating.book_id, tabel_rating.book_rating\n"
                    + "FROM tabel_rating WHERE tabel_rating.user_id='" + userID + "'";

            ResultSet rs3 = stmt3.executeQuery(get_RealRating);

            ArrayList<M_MAE> real_ratings = new ArrayList<M_MAE>();
            while (rs3.next()) {
                M_MAE model_mae_real = new M_MAE();
                model_mae_real.setBook_id(rs3.getInt("book_id"));
                model_mae_real.setBook_rating_real(rs3.getDouble("book_rating"));
                real_ratings.add(model_mae_real);
            }

            for (int i = 0; i < real_ratings.size(); i++) {
                System.out.println("FROM real_ratings  " + real_ratings.get(i));
            }
            System.out.println("========");
            for (int i = 0; i < pred_ratings.size(); i++) {
                System.out.println("FROM pred_ratings  " + pred_ratings.get(i));
            }

            ArrayList<M_MAE> eMAE_ = new ArrayList<M_MAE>();

            for (int i = 0; i < real_ratings.size(); i++) {
                M_MAE model_MAE_FULL = new M_MAE();
                for (int j = 0; j < pred_ratings.size(); j++) {
                    
                    if(real_ratings.get(i).getBook_id()==pred_ratings.get(j).getBook_id()){
                        model_MAE_FULL.setBook_id(pred_ratings.get(j).getBook_id());
                        model_MAE_FULL.setBook_rating_real(real_ratings.get(i).getBook_rating_real());
                        model_MAE_FULL.setBook_rating_prediction(pred_ratings.get(j).getBook_rating_prediction());
                    }
                }
                eMAE_.add(model_MAE_FULL);

            }

            for (int i = 0; i < eMAE_.size(); i++) {
                System.out.println(eMAE_.get(i));
            }

            double sum = 0.0;
            for (int i = 0; i < eMAE_.size(); i++) {
                sum = sum + Math.abs(eMAE_.get(i).getBook_rating_prediction() - eMAE_.get(i).getBook_rating_real());

            }
            double mae = sum / eMAE_.size();
            System.out.println(eMAE_.size());

            System.out.println("MAE =" + mae);
            txtlabel_MAE.setText(Double.toString(mae));
            System.out.println("IDLE");

        } catch (Exception e) {
//            System.out.println(e.getMessage());
        }
        tbl_rekomendasi.setModel(tblModel);
    }
//
//    List<M_MAE> merge(List<M_MAE> first, List<M_MAE> second) {
//        if (first.isEmpty()) {
//            return second;
//        }
//        if (second.isEmpty()) {
//            return first;
//        }
//        List<M_MAE> result = new ArrayList<>();
//        for (M_MAE prefix : first) {
//            M_MAE model_MAE_FULL = new M_MAE();
//            for (M_MAE suffix : second) {
//                model_MAE_FULL.setBook_id(prefix.getBook_id());
//                model_MAE_FULL.setBook_rating_real(prefix.getBook_rating_real());
//                model_MAE_FULL.setBook_rating_prediction(suffix.getBook_rating_prediction());
//                result.add(model_MAE_FULL);
//            }
//        }
//        return result;
//    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtlabel_MAE = new javax.swing.JLabel();
        textlabel_mae = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_rekomendasi = new javax.swing.JTable();
        txtlabel_namauser1 = new javax.swing.JLabel();
        textlabel_judul2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Details");

        txtlabel_MAE.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtlabel_MAE.setText("#MAE");

        textlabel_mae.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textlabel_mae.setText("MAE =");

        tbl_rekomendasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tbl_rekomendasi);

        txtlabel_namauser1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtlabel_namauser1.setText("#nama_user");

        textlabel_judul2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textlabel_judul2.setText("Rekomendasi untuk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                .addGap(46, 46, 46))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(textlabel_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtlabel_MAE, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(231, Short.MAX_VALUE)
                    .addComponent(txtlabel_namauser1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(211, 211, 211)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(textlabel_judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(410, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlabel_MAE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textlabel_mae, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(txtlabel_namauser1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(248, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(32, 32, 32)
                    .addComponent(textlabel_judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbl_rekomendasi;
    private javax.swing.JLabel textlabel_judul2;
    private javax.swing.JLabel textlabel_mae;
    private javax.swing.JLabel txtlabel_MAE;
    private javax.swing.JLabel txtlabel_namauser1;
    // End of variables declaration//GEN-END:variables
}
