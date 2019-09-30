package com.example.lietenerbox.util;

import com.example.lietenerbox.model.Person;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    public static final String Person_SESSION_KEY = "sessionPerson";

    public static boolean isLoginPerson(HttpSession session) {

        Object sessionPerson = session.getAttribute(Person_SESSION_KEY);

        if (sessionPerson == null) {
            return false;
        }
        return true;
    }


    //로그인한 회원의 정보 가져오는 메서드
    public static Person getPersonFromSession(HttpSession session) {

        if(!isLoginPerson(session)){
            return null;
        }
        return (Person) session.getAttribute(Person_SESSION_KEY);
    }
}
