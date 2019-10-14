package com.example.lietenerbox.util;

import com.example.lietenerbox.model.Records;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    public static Long calDate(Records records) throws ParseException {

        //입력 string "yyyy-MM-dd" date형식으로 변경
        String inputDate = records.getStudyDay();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date)formatter.parse(inputDate);
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMdd");

        //회원가입한 날짜
        String regDate = newFormat.format(date);

        //오늘 날짜
        String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        Long calDate = 0L;

        try {
            //simple date format을 통해 date 타입으로 변경
            //date 타입으로 캐스팅 하면서 생기는 예외로 인해 여기서 예외처리 하지 않으면 컴파일 오류가 남.
            //SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

            Date regDate1 = newFormat.parse(regDate);
            Date nowDate1 = newFormat.parse(nowDate);

            //날짜사이 차수 구하기
            calDate = (nowDate1.getTime()- regDate1.getTime()) / (24 * 60 * 60 * 1000);

            return calDate;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calDate;
    }
}
