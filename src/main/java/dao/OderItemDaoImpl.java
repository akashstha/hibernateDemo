package dao;

import org.hibernate.Session;

import dao.util.Util;
import pojo.OrderItems;
import dao.util.Util;

import javax.transaction.SystemException;
import javax.transaction.Transaction;


public class OderItemDaoImpl implements OderItemDao{

	@Override
	public void createOrderItems(OrderItems items) {

		Session session = null;
		try {
			session = Util.openSession();
			session.beginTransaction();
			session.save(items);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}	
		
	}

	@Override
	public OrderItems findOrderItem(int id) {
		Session session = null;
		try {
			session = Util.openSession();
			OrderItems orderItems = (OrderItems) session.get(OrderItems.class, id);
			return orderItems;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateOrderItems(OrderItems items) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = Util.openSession();
			transaction = (Transaction) session.beginTransaction();
			session.update(items);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public boolean deleteOrderItems(int id) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = Util.openSession();
			transaction = (Transaction) session.beginTransaction();
			OrderItems items = (OrderItems) session.get(OrderItems.class, id);
			if (items != null)
				session.delete(items);
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


