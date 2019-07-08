package com.example.springbootrao.listener;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class MySessionContent {

    private static HashMap map =new HashMap();

    public static synchronized  void  addSession(HttpSession session){
        if(session!=null){
            map.put(session.getId(),session);
        }

    }

    public static synchronized  void  delSession(HttpSession session){

        if(session!=null){
            map.remove(session);
        }

    }

    public static synchronized HttpSession getSession(HttpSession session){

        if(session==null)
            return null;
        return (HttpSession) map.get(session.getId());

    }
}
