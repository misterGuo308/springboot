package com.example.springbootrao.configuration.listener;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public class MySessionContent {

    private static HashMap map = new HashMap();

    public static synchronized void addSession(HttpSession session) {
        if (session != null) {
            map.put(session.getId(), session);
        }

    }

    public static synchronized void delSession(String sessionId) {

        if (sessionId != null) {
            map.remove(sessionId);
        }

    }

    public static synchronized HttpSession getSession(String sessionId) {

        if (sessionId == null)
            return null;
        return (HttpSession) map.get(sessionId);

    }
}
