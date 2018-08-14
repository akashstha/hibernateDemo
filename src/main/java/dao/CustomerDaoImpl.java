package dao;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import pojo.Customer;
import static dao.util.Util.openSession;


public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void createCustomer(Customer customer) {
		Session session = null;
		try {
			session = openSession();
			session.beginTransaction();
			session.save(customer);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	@Override
	public Customer findCustomer(int id) {

		Session session = null;
		try {
			session = openSession();
			Customer customer = (Customer) session.get(Customer.class, id);
			return customer;
		} finally {
			session.close();
		}
	}

	@Override
	public void updateCustomer(Customer customer) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = (Transaction) session.beginTransaction();
			session.update(customer);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		
	}

	@Override
	public boolean deleteCustomer(int id) throws IllegalStateException, SystemException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = openSession();
			transaction = (Transaction) session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, id);
			if (customer != null)
				session.delete(customer);
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
