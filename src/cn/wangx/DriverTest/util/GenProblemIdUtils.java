package cn.wangx.DriverTest.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GenProblemIdUtils {
    public static List<Integer> genProblemId(int start,int end, int num){
        List<Integer> integers=new ArrayList<>();
        Random rm = new Random();
        int tempvalue = rm.nextInt(end);
        while (integers.size() != num) {
            if (integers.contains(tempvalue)) {
                tempvalue = rm.nextInt(end);
            } else if(tempvalue > start){
                integers.add(tempvalue);
            }else {
                tempvalue = rm.nextInt(end);
            }
        }
        return integers;
    }

}
