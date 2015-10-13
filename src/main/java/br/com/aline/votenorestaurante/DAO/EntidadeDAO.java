package br.com.aline.votenorestaurante.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.aline.votenorestaurante.model.Entidade;

public class EntidadeDAO<T extends Entidade> {
	
	@SuppressWarnings("deprecation")
	public SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError();
		}
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends Entidade> T buscaPorId(Class<T> tipoClasse, Long id) {
		Session session = null;
		T entidade = null;
		try {
			SessionFactory sessionFactory = buildSessionFactory(); 
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(tipoClasse);
			criteria.add(Restrictions.eq("id", id));
			entidade = (T) criteria.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return entidade;
	}

	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends Entidade> List<T> lista(Class<T> type) {
		Session session = null;
		List<T> entidades = new ArrayList<T>();
		try {
			SessionFactory sessionFactory = buildSessionFactory(); 
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(type);
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			criteria.addOrder(Order.asc("id"));
			entidades = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return entidades;
	}

	@SuppressWarnings("hiding")
	public <T extends Entidade> T criar(T entidade) {
		Session session = null;
		try {
			SessionFactory sessionFactory = buildSessionFactory(); 
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(entidade);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}

		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return entidade;
	}
}
