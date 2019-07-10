package com.example.springbootrao.configuration.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*@WebListener  将该注解打开就可以使用session监听器了
@Component*/
public class SessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建的session:" + se.getSession().getId());
        MySessionContent.addSession(se.getSession());

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁的session:" + se.getSession().getId());
        MySessionContent.delSession(se.getSession().getId());

    }

}
