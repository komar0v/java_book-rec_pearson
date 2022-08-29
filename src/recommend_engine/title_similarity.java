/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommend_engine;

import MODEL_.M_Buku;
import MODEL_.connectorDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frans
 */
public class title_similarity {

    //KESAMAAN JUDUL 
    public static double similarityJudulBuku(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) {
            longer = s2;
            shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return 1.0;
        }
        return (longerLength - strDistance(longer, shorter)) / (double) longerLength;

    }

    //LEVENSTEIN DISTANCE
    public static int strDistance(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] costs = new int[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            int lastValue = i;
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0) {
                    costs[j] = j;
                } else {
                    if (j > 0) {
                        int newValue = costs[j - 1];
                        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                            newValue = Math.min(Math.min(newValue, lastValue),
                                    costs[j]) + 1;
                        }
                        costs[j - 1] = lastValue;
                        lastValue = newValue;
                    }
                }
            }
            if (i > 0) {
                costs[s2.length()] = lastValue;
            }
        }
        return costs[s2.length()];
    }

//    public static void main(String[] args) {
////        String s = "ABCD";
////        String t = "EECD";
////        System.out.println(similarityJudulBuku(s, t));
//
//        try {
//            connectorDb koneksi = new connectorDb();
//            Connection konek = koneksi.getConnection();
//
//            Statement stmt = konek.createStatement();
//            String query = "SELECT * FROM tabel_buku";
//            ResultSet rs = stmt.executeQuery(query);
//
////            List<M_Buku> buku = new ArrayList<M_Buku>();
//            M_Buku buku = new M_Buku();
//            String title_booktocompare = "Petals on the River";
//            String author_booktocompare = "Kathleen E  Woodiwiss";
//            while (rs.next()) {
//                buku.setBook_title(rs.getString("book_title"));
//                buku.setBook_author(rs.getString("book_author"));
//                
//                System.out.println("SIMILARITY JUDUL BUKU "+title_booktocompare+" dgn "+ buku.getBook_title()+" = "+similarityJudulBuku(title_booktocompare, buku.getBook_title()));
//                System.out.println("SIMILARITY AUTHOR BUKU "+author_booktocompare+" dgn "+ buku.getBook_author()+" = "+similarityJudulBuku(author_booktocompare, buku.getBook_author()));
//                System.out.println("==============");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//    }

}
