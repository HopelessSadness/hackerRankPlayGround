package com.hackerRank;

import java.util.ArrayList;
import java.util.List;

public class MultiLinePatternFinder {
    private static String findPatternInArray(List<String> heap, List<String> pattern) {
        String result = "opaPizdec";
        int position;
        int checkedLines = 0;

        for (String s : heap) {
            position = s.indexOf(pattern.get(checkedLines));
            if (position > 0) {
                checkedLines++;
            } else {
                checkedLines = 0;
            }
            if (checkedLines == pattern.size()) {
                result = "sooqaBlyat";
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> stringsOfNumbersHeap = new ArrayList<>();
       //stringsOfNumbersHeap.add("123356789");
       //stringsOfNumbersHeap.add("987654321");
       //stringsOfNumbersHeap.add("123456789");
       //stringsOfNumbersHeap.add("987654321");

        stringsOfNumbersHeap.add("7283455864");
        stringsOfNumbersHeap.add("6731158619");
        stringsOfNumbersHeap.add("8988242643");
        stringsOfNumbersHeap.add("3830589324");
        stringsOfNumbersHeap.add("2229505813");
        stringsOfNumbersHeap.add("5633845374");
        stringsOfNumbersHeap.add("6473530293");
        stringsOfNumbersHeap.add("7053106601");
        stringsOfNumbersHeap.add("0834282956");
        stringsOfNumbersHeap.add("4607924137");


        List<String> stringsOfNumbersPattern = new ArrayList<>();
        //stringsOfNumbersPattern.add("34");
        //stringsOfNumbersPattern.add("76");

        stringsOfNumbersPattern.add("9505");
        stringsOfNumbersPattern.add("3845");
        stringsOfNumbersPattern.add("3530");


        System.out.println(findPatternInArray(stringsOfNumbersHeap, stringsOfNumbersPattern));
    }
}

