package com.example.lietenerbox.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyLevelUtils {


    //일차에 맞는 레벨 꺼내오는 메서드
    public static String[] wordLevel(Long day) {

        //hashMap 만들기
        String levelArr[] = {"2, 1", "3, 1", "2, 1", "4, 1", "2, 1", "3, 1", "2, 1", "1", "2, 1", "3, 1", "2, 1", "5, 1", "2, 1", "3, 1", "2, 1", "2, 1",
                "2, 1", "3, 1", "2, 1", "4, 1", "2, 1", "3, 1", "2, 1", "6, 1", "2, 1", "3, 1", "2, 1", "5, 1", "4, 2, 1", "3, 1", "2, 1", "1", "2, 1",
                "3, 1", "2, 1","4, 1", "2, 1", "3, 1", "2, 1", "1", "2, 1", "3, 1", "2, 1", "5, 1", "4, 2, 1", "3, 1", "2, 1", "1", "2, 1", "3, 1", "2, 1",
                "4, 1", "2, 1", "3, 1", "2, 1", "7, 1", "2, 1", "3, 1", "6, 2, 1", "5, 1", "4, 2, 1", "3, 1", "2, 1", "1"};


        Map<String, String> studyLevel = new HashMap<String, String>();

        for (int i = 0; i < levelArr.length; i++) {
            studyLevel.put(String.valueOf((i + 1)), levelArr[i]);
        }


        return studyLevel.get(String.valueOf(day)).split(",");
    }


}
