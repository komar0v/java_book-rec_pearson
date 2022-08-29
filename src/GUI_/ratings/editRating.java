/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_.ratings;

import CONTROLLER_.C_Buku;
import CONTROLLER_.C_Ratings;
import MODEL_.M_Buku;
import MODEL_.M_Ratings;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author frans
 */
public class editRating extends javax.swing.JFrame {

    /**
     * Creates new form editRating
     */
    String ISBN;
    int user_id;
    public editRating(int userID, String bookISBN) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            System.out.println("PROCESSING...");
            M_Ratings dataRating = new C_Ratings().getDetailRating(userID, bookISBN);
            M_Buku dataBuku = new C_Buku().getDetailBuku(bookISBN);
            
            textF_userId.setText(Integer.toString(dataRating.getUser_id()));
            textF_judulBuku.setText(dataBuku.getBook_title());
            textF_rating.setText(Double.toString(dataRating.getBook_rating()));
            
            ISBN = dataBuku.getBook_isbn();
            user_id = dataRating.getUser_id();
            
            System.out.println("IDLE");
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "ERR..  CONNECTION FAILED!\n" + e.getMessage());
            System.exit(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        labelJudulFrame = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        label_judul5 = new javax.swing.JLabel();
        textF_judulBuku = new javax.swing.JTextField();
        textF_rating = new javax.swing.JTextField();
        label_judul6 = new javax.swing.JLabel();
        btn_simpan1 = new javax.swing.JButton();
        label_judul7 = new javax.swing.JLabel();
        textF_userId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        labelJudulFrame.setBackground(new java.awt.Color(0, 0, 0));
        labelJudulFrame.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        labelJudulFrame.setText("Edit Rating User");

        label_judul5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul5.setText("Judul Buku");

        textF_judulBuku.setEditable(false);
        textF_judulBuku.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        textF_rating.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        label_judul6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul6.setText("Rating");

        btn_simpan1.setText("Simpan");
        btn_simpan1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpan1MouseClicked(evt);
            }
        });

        label_judul7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul7.setText("User ID");

        textF_userId.setEditable(false);
        textF_userId.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_judul5)
                    .addComponent(label_judul7)
                    .addComponent(label_judul6, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textF_rating, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(textF_userId, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(textF_judulBuku))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(btn_simpan1)
                .addContainerGap(272, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul7)
                    .addComponent(textF_userId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_judulBuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_rating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_simpan1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelJudulFrame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelJudulFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpan1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpan1MouseClicked

        int user_id;
        double user_rating;

        user_id = Integer.parseInt(textF_userId.getText());
        user_rating = Integer.parseInt(textF_rating.getText());

        if (textF_rating.getText() == "" || textF_userId.getText() == "") {
            JOptionPane.showMessageDialog(null, "Input Tidak Valid", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                System.out.println("PROCESSING...");
                M_Ratings dataRating = new M_Ratings();

                dataRating.setBook_rating(user_rating);
                dataRating.setUser_id(user_id);

                new C_Ratings().save_EditRating(dataRating);

                System.out.println("IDLE");
                JOptionPane.showMessageDialog(null, "Data disimpan");
                this.dispose();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpan1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_simpan1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel labelJudulFrame;
    private javax.swing.JLabel label_judul5;
    private javax.swing.JLabel label_judul6;
    private javax.swing.JLabel label_judul7;
    private javax.swing.JTextField textF_judulBuku;
    private javax.swing.JTextField textF_rating;
    private javax.swing.JTextField textF_userId;
    // End of variables declaration//GEN-END:variables
}
