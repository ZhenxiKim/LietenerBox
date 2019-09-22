package com.example.lietenerbox.util;

import com.example.lietenerbox.model.Member;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {

    public static final String MEMBER_SESSION_KEY = "sessionMember";

    public static boolean isLoginMember(HttpSession session) {

        Object sessionMember = session.getAttribute(MEMBER_SESSION_KEY);

        if (sessionMember == null) {
            return false;
        }
        return true;
    }


    //로그인한 회원의 정보 가져오는 메서드
    public static Member getMemberFromSession(HttpSession session) {

        if(!isLoginMember(session)){
            return null;
        }
        return (Member) session.getAttribute(MEMBER_SESSION_KEY);
    }
}
