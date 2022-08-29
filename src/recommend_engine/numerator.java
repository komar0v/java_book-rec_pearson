/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommend_engine;

import java.util.List;

/**
 *
 * @author frans
 */
public class numerator {
    //BATAS ATAS

    protected List<String> xList, yList;

    public numerator(List<String> xList, List<String> yList) {
        this.xList = xList;
        this.yList = yList;
    }

    public double hitungBtsAtas() {
        double result = 0.0;
        double xAverage = 0.0;
        double temp = 0.0;

        int xSize = xList.size();
        for (int x = 0; x < xSize; x++) {
            temp += Double.parseDouble(xList.get(x));
        }
        xAverage = temp / xSize;

        double yAverage = 0.0;
        temp = 0.0;
        int ySize = yList.size();
        for (int x = 0; x < ySize; x++) {
            temp += Double.parseDouble(yList.get(x));
        }
        yAverage = temp / ySize;

        //double sum = 0.0;
        for (int x = 0; x < xSize; x++) {
            result += (Double.parseDouble(xList.get(x)) - xAverage) * (Double.parseDouble(yList.get(x)) - yAverage);
        }
        return result;
    }
}
