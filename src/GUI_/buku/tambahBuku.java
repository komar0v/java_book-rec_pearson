/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_.buku;

import CONTROLLER_.C_Buku;
import GUI_.loading_box.loading_now;
import MODEL_.M_Buku;
import java.sql.SQLException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author frans
 */
public class tambahBuku extends javax.swing.JFrame {

    /**
     * Creates new form tambahBuku
     */
    public tambahBuku() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_importFromFile = new javax.swing.JButton();
        label_judul = new javax.swing.JLabel();
        textF_judul = new javax.swing.JTextField();
        label_judul1 = new javax.swing.JLabel();
        textF_author = new javax.swing.JTextField();
        label_judul2 = new javax.swing.JLabel();
        textF_publisher = new javax.swing.JTextField();
        label_judul3 = new javax.swing.JLabel();
        textF_year = new javax.swing.JTextField();
        textF_url = new javax.swing.JTextField();
        label_judul4 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        label_judul5 = new javax.swing.JLabel();
        textF_isbn = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 255, 51));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("Tambah Buku");

        btn_importFromFile.setText("Import dari File");
        btn_importFromFile.setActionCommand("Lihat User");
        btn_importFromFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_importFromFileMouseClicked(evt);
            }
        });

        label_judul.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul.setText("Judul");

        textF_judul.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        label_judul1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul1.setText("Author");

        textF_author.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        label_judul2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul2.setText("Publiser");

        textF_publisher.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        label_judul3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul3.setText("Year");

        textF_year.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        textF_url.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        label_judul4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul4.setText("Img URL");

        btn_simpan.setText("Simpan");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });

        label_judul5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_judul5.setText("ISBN");

        textF_isbn.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_importFromFile, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textF_judul))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textF_author, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textF_publisher))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textF_year))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textF_url))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label_judul5)
                        .addGap(40, 40, 40)
                        .addComponent(textF_isbn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_simpan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_importFromFile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul5)
                    .addComponent(textF_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_publisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_judul4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textF_url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(377, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        
        String book_isbn, book_title, book_author, book_pub, book_img_url;
        int year_of_pub;

        book_isbn = removeSpcialChar(textF_isbn.getText());
        book_title = removeSpcialChar(textF_judul.getText());
        book_author = removeSpcialChar(textF_author.getText());
        book_pub = removeSpcialChar(textF_publisher.getText());
        book_img_url = textF_url.getText();
        year_of_pub = Integer.parseInt(textF_year.getText());

        String regex_ = "[0-9]+";

        if (textF_year.getText().matches(regex_)) {
            if (book_isbn == "" || book_title == "" || book_pub == "" || book_img_url == "" || textF_year.getText() == "") {
                JOptionPane.showMessageDialog(null, "Input Tidak Valid", "ERROR", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    M_Buku dataBuku = new M_Buku();
                    dataBuku.setBook_isbn(book_isbn);
                    dataBuku.setBook_title(book_title);
                    dataBuku.setBook_pub(book_pub);
                    dataBuku.setYear_of_pub(year_of_pub);
                    dataBuku.setBook_author(book_author);
                    dataBuku.setBook_img_url(book_img_url);
                    new C_Buku().tambah_Buku(dataBuku);
                    
                    JOptionPane.showMessageDialog(null, "Buku Ditambahkan");
                    this.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Input Tidak Valid", "ERROR", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_importFromFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_importFromFileMouseClicked
        this.dispose();
        new importBuku().setVisible(true);
    }//GEN-LAST:event_btn_importFromFileMouseClicked

    String removeSpcialChar(String str) {
        String normalized = Normalizer.normalize(str, Form.NFD);
        String result = normalized.replaceAll("[^A-Za-z0-9]", " ");
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_importFromFile;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_judul;
    private javax.swing.JLabel label_judul1;
    private javax.swing.JLabel label_judul2;
    private javax.swing.JLabel label_judul3;
    private javax.swing.JLabel label_judul4;
    private javax.swing.JLabel label_judul5;
    private javax.swing.JTextField textF_author;
    private javax.swing.JTextField textF_isbn;
    private javax.swing.JTextField textF_judul;
    private javax.swing.JTextField textF_publisher;
    private javax.swing.JTextField textF_url;
    private javax.swing.JTextField textF_year;
    // End of variables declaration//GEN-END:variables
}
