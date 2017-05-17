package com.kopacsi.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 
public class SessionUtil {
    
    private static final String HIBERNATE_CFG_XML = "hibernate.cfg.xml";
    
	private static SessionUtil instance = new SessionUtil();
    private SessionFactory sessionFactory;
    
    public static SessionUtil getInstance(){
            return instance;
    }
    
    private SessionUtil(){
        Configuration configuration = new Configuration();
        configuration.configure(HIBERNATE_CFG_XML);
                
        sessionFactory = configuration.buildSessionFactory();
    }
    
    public static Session getSession(){
        Session session =  getInstance().sessionFactory.openSession();
        
        return session;
    }
}
