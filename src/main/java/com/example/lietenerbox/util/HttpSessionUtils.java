package com.example.lietenerbox.util;

import com.example.lietenerbox.model.Members;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    public static final String members_SESSION_KEY = "sessionmembers";

    public static boolean isLoginmembers(HttpSession session) {

        Object sessionmembers = session.getAttribute(members_SESSION_KEY);

        if (sessionmembers == null) {
            return false;
        }
        return true;
    }


    //로그인한 회원의 정보 가져오는 메서드
    public static Members getmembersFromSession(HttpSession session) {

        if(!isLoginmembers(session)){
            return null;
        }
        return (Members) session.getAttribute(members_SESSION_KEY);
    }
}
