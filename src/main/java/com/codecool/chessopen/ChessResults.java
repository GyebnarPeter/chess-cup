package com.codecool.chessopen;

import java.io.*;
import java.util.*;

public class ChessResults {

    public List<String> getCompetitorsNamesFromFile(String fileName){
        List<String> resultList = new ArrayList<>();
        List<String> pointList = new ArrayList<>();
        Map<Integer, String> pointMap = new TreeMap<>();

        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while(scanner.hasNextLine()) {
                pointList.add(scanner.nextLine());
            }
            scanner.close();
            for(String point : pointList) {
                String[] pointToArr = point.split(",");
                int sumPoint = Integer.parseInt(pointToArr[1]) +
                        Integer.parseInt(pointToArr[2]) +
                        Integer.parseInt(pointToArr[3]) +
                        Integer.parseInt(pointToArr[4]) +
                        Integer.parseInt(pointToArr[5]);
                pointMap.put(sumPoint, pointToArr[0]);
            }
            for(int point : pointMap.keySet()) {
                resultList.add(pointMap.get(point));
            }
            Collections.reverse(resultList);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        
        return resultList;
    }

}
