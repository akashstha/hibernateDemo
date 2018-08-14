package com.Hibernet.akashHibernet;

import javax.transaction.SystemException;

import dao.CustomerDao;
import dao.CustomerDaoImpl;
import dao.OderItemDao;
import dao.OderItemDaoImpl;
import dao.Oders;
import dao.OdersImpl;
import dao.util.Util;
import pojo.Address;
import pojo.Customer;
import pojo.OrderItems;
import pojo.Orders;

public class App 
{
    public static void main( String[] args ) throws IllegalStateException, SystemException
    {
    	CustomerDao customerdao=new CustomerDaoImpl();
    	Oders oderdao=new OdersImpl();
    	OderItemDao oderitemdao=new OderItemDaoImpl();
    	
    	OrderItems oderItem1=new OrderItems(null, "Banana", 0.17, null);
    	oderitemdao.createOrderItems(oderItem1);
    	OrderItems oderItem2=new OrderItems(null, "Apple", 2.29, null);
    	oderitemdao.createOrderItems(oderItem2);
    	OrderItems oderItem3=new OrderItems(null, "Cherry", 6.45, null);
    	oderitemdao.createOrderItems(oderItem3);
    	
    	Orders order1=new Orders(null, "Delivered", null, oderItem1.getItemId());
    	oderdao.createOrder(order1);
    	Orders order2=new Orders(null, "Pending", null, oderItem2.getItemId());
    	oderdao.createOrder(order2);
    	Orders order3=new Orders(null, "Delivered", null, oderItem3.getItemId());
    	oderdao.createOrder(order3);
    	
    	Address address1=new Address("101 Herculas road", "Irving", "TX", 76908);
    	Address address2=new Address("1998 Jesus road", "California", "CA", 88685);
    	Address address3=new Address("897 Mecy road", "Newyork", "NY", 78955);


    	Customer customer1=new Customer(1001, "Tom Jerry", 911, address1, order1.getItemId());
    	Customer customer2=new Customer(2002, "Charles Brown", 811, address2, order2.getItemId());
    	Customer customer3=new Customer(3003, "Tim Thomas", 711, address3, order3.getItemId());
    	customerdao.createCustomer(customer1);
    	customerdao.createCustomer(customer2);
    	customerdao.createCustomer(customer3);
    																																																																																																																																															


    	
    	
    	
  
    	
    	
      
    }
}
