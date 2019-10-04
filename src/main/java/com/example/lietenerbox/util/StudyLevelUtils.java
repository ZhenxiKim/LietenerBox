package com.example.lietenerbox.util;

import java.util.HashMap;
import java.util.Map;

public class StudyLevelUtils {


    //일차에 맞는 레벨 꺼내오는 메서드
    public static Object wordLevel(int day){

            int levelArr[][] = {{2, 1}, {3, 1}, {2, 1}, {4, 1}, {2, 1}, {3, 1}, {2, 1}, {1}, {2, 1}, {3, 1}, {2, 1}, {5, 1}, {2, 1}, {3, 1}, {2, 1}, {2, 1},
                    {2, 1}, {3, 1}, {2, 1}, {4, 1}, {2, 1}, {3, 1}, {2, 1}, {6, 1}, {2, 1}, {3, 1}, {2, 1}, {5, 1}, {4, 2, 1}, {3, 1}, {2, 1}, {1}, {2, 1}, {3, 1}, {2, 1},
                    {4, 1}, {2, 1}, {3, 1}, {2, 1}, {1}, {2, 1}, {3, 1}, {2, 1}, {5, 1}, {4, 2, 1}, {3, 1}, {2, 1}, {1}, {2, 1}, {3, 1}, {2, 1}, {4, 1}, {2, 1}, {3, 1}, {2, 1}, {7, 1}, {2, 1}, {3, 1}, {6, 2, 1}, {5, 1}, {4, 2, 1}, {3, 1}, {2, 1}, {1}};

            Map<String, int[]> studyLevel = new HashMap<String, int[]>();

            for (int i = 0; i < levelArr.length; i++) {
                studyLevel.put(String.valueOf((i + 1)), levelArr[i]);
            }

            return  studyLevel.get(String.valueOf(day));
        }


}
