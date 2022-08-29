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
public class denominator {
    //BATAS BAWAH
    public double hituungBtsBwh(List<String> xList,List<String> yList){
		double stDiff = 0.0;
		int size = xList.size();
		double xAverage = 0.0;
		double yAverage = 0.0;
		double xException = 0.0;
		double yException = 0.0;
		double temp = 0.0;
		for(int i=0;i<size;i++){
			temp += Double.parseDouble(xList.get(i));
		}
		xAverage = temp/size;
		
		for(int i=0;i<size;i++){
			temp += Double.parseDouble(yList.get(i));
		}
		yAverage = temp/size;
		
		for(int i=0;i<size;i++){
			xException += Math.pow(Double.parseDouble(xList.get(i))-xAverage,2);
			yException += Math.pow(Double.parseDouble(yList.get(i))-yAverage, 2);
		}
		return stDiff = Math.sqrt(xException*yException);
	}
}
