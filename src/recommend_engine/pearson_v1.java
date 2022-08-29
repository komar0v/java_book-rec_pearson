/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommend_engine;

import MODEL_.connectorDb;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author frans
 */
public class pearson_v1 {

    public static double hitungPearson(String[] str1, String[] str2) {
        double CORR = 0.0;
        List<String> xList = new ArrayList<String>(Arrays.asList(str1));
        List<String> yList = new ArrayList<String>(Arrays.asList(str2));

        numerator nc = new numerator(xList, yList);
        double ba = nc.hitungBtsAtas();
        denominator dc = new denominator();
        double bb = dc.hituungBtsBwh(xList, yList);
        CORR = ba / bb;
        return CORR;
    }
    
//    public static void main(String[] args) {
//        String[] str1 = {"3.83","26"};
//        String[] str2 = {"2","34"};
//        System.out.println(hitungPearson(str1, str2));
//    }
   
}
