package br.com.aline.votenorestaurante.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static final SessionFactory sessionFactory = buildSessionFactory(); 
	
	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory(){
		try{
			return new Configuration().configure().buildSessionFactory();
		}
		catch(Throwable e){
			e.printStackTrace();
			return null; 
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory; 
	}
	
	public static void shutdown(){
		getSessionFactory().close();
	}
}
