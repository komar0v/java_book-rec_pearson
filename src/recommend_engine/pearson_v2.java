/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommend_engine;

import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author frans
 */
public class pearson_v2 {

    static float pearson(double X[], double Y[], int n) {

        double sum_X = 0, sum_Y = 0, sum_XY = 0;
        double squareSum_X = 0, squareSum_Y = 0;

        for (int i = 0; i < n; i++) {
            sum_X = sum_X + X[i];

            sum_Y = sum_Y + Y[i];

            sum_XY = sum_XY + X[i] * Y[i];

            squareSum_X = squareSum_X + X[i] * X[i];
            squareSum_Y = squareSum_Y + Y[i] * Y[i];
        }

        // pearson correlation.
        float corr = (float) (n * sum_XY - sum_X * sum_Y) / (float) (Math.sqrt((n * squareSum_X - sum_X * sum_X) * (n * squareSum_Y - sum_Y * sum_Y)));

        return corr;
    }

    public double hitungSimilarity(double X_[], double Y_[]) {

        double X[] = X_;
        double Y[] = Y_;

        int n = X.length;

        return pearson(X, Y, n);

    }

//    public static void main(String[] args) {
//        pearson_v2 rec_eng = new pearson_v2();
//        double X_[] = {-1.67, 1.33, 0.33};
//        double Y_[] = {-1.75, 1.25, 1.25};
//        double sim = rec_eng.hitungSimilarity(X_, Y_);
//
//        System.out.println(sim);
//
//        try {
//            connectorDb koneksi = new connectorDb();
//            Connection konek = koneksi.getConnection();
//
//            Statement stmt = konek.createStatement();
//            String query = "SELECT * FROM tabel_rating\n"
//                    + "JOIN tabel_user ON tabel_rating.user_id=tabel_user.user_id\n"
//                    + "JOIN tabel_buku ON tabel_rating.book_id=tabel_buku._id\n"
//                    + "WHERE tabel_rating.user_id!=\"10\"";
//            ResultSet rs = stmt.executeQuery(query);
//
//            pearson_v2 rec_eng = new pearson_v2();
//            double X_[] = {3.83, 26};
//            while (rs.next()) {
//                double rtg = rs.getDouble("book_rating");
//                double x = rs.getDouble("user_age");
//
//                double Y_[] = {rtg, x};
//                double sim = rec_eng.hitungSimilarity(X_, Y_);
//
//                
//                System.out.println(rtg+","+x);
//                System.out.println(sim);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

//    public static void main(String[] args) {
//        pearson_v2 rec_eng = new pearson_v2();
//        double X_[] = {-1.67, 1.33, 0.33,3.1};
//        double Y_[] = {-1.75, 1.25, 1.25,0};
//        double sim = rec_eng.hitungSimilarity(X_, Y_);
//
//        System.out.println(sim);
//    }
}
