package dao;

import org.hibernate.Session;

import pojo.Orders;
import static dao.util.Util.openSession;

import javax.transaction.SystemException;
import javax.transaction.Transaction;


public class OdersImpl implements Oders{

	@Override
	public void createOrder(Orders orders) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(orders);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}		
		
	}

	@Override
	public Orders findOrder(int id) {
		Session session = null;
		try {
			session = openSession();
			Orders orders = (Orders) session.get(Orders.class, id);
			return orders;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateOrder(Orders orders) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = (Transaction) session.beginTransaction();
			session.update(orders);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public boolean deleteOrder(int id) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = (Transaction) session.beginTransaction();
			Orders orders = (Orders) session.get(Orders.class, id);
			if (orders != null)
				session.delete(orders);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}
}
