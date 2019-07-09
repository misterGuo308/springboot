package com.example.springbootrao.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener {
     @Override
    public void sessionCreated(HttpSessionEvent se) {
         System.out.println("创建的session:"+se.getSession().getId());
     MySessionContent.addSession(se.getSession());

    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁的session:"+se.getSession().getId());
        MySessionContent.delSession(se.getSession().getId());

    }

}
