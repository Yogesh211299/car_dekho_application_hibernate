package com.jspiders.cardekho_case_study3.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho_case_study3.dto.Car;
import com.jspiders.cardekho_case_study3.dto.CarDekhoMenu;
public class CarOperation {

	private  EntityManagerFactory entityManagerFactory;
	private  EntityManager entityManager;
	private  EntityTransaction entityTransaction;
	private  Scanner inp;
	private String query;
	private CarDekhoMenu carDekhoMenu;
	private int rows;
	private  Query query1;
	private  void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager=entityManagerFactory.createEntityManager();
		entityTransaction=entityManager.getTransaction();
	}
	
	private  void closeConnection1() {
		if(entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if(entityManager != null) {
			entityManager.close();
		}
		if(entityTransaction != null) {
			if(entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
			
	}
	
	
	public  void addCar() {
    	try {
			openConnection();
		    inp=new Scanner(System.in);
	    	System.out.println("HOW MANY CARS DO YOU WANT TO ADD");
	        int carNo=inp.nextInt();
	        
	        for (int i = 1;i<=carNo; i++) {
			entityTransaction.begin();  	
			Car car=new Car();
	
		 	System.out.println("enter your Car Id :- ");
		      car.setCarId(inp.nextInt());
		System.out.println("enter your Car Name :- ");
	          car.setName(inp.next());
		System.out.println("enter your Car Brand :- ");
			  car.setBrand(inp.next());
		System.out.println("enter your Car Model :- ");
		      car.setModel(inp.next());
		System.out.println("enter your Car fuelType :- ");
			  car.setFuelType(inp.next());
		System.out.println("enter your Car Price :- ");
		     car.setPrice(inp.nextDouble());
		      entityManager.persist(car);
		      System.out.println(car.getName()+" car added successfull !!!!");
		      entityTransaction.commit();
	        }
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
    	finally {
    		closeConnection1();
    	}
}
	@SuppressWarnings("unchecked")
	public void allCarDetails() {
		openConnection();
		entityTransaction.begin();
	
		Query query1=entityManager.createQuery("select car from Car car");
		List<Car> cars=query1.getResultList();
		for(Car car : cars) {
			System.out.println(car);
			}
		entityTransaction.commit();
//		closeConnection1();
	}

@SuppressWarnings("unchecked")    
public void searchCarDetails() {
      inp=new Scanner(System.in);
      
	System.out.println("======= Search Car by ======\n");
	System.out.println("1.Car Name\n2.Car Brand\n3.Car FuelType\n4.All cars\n5.Go Back\n");
	int choice=inp.nextInt();
	
	switch (choice) {
	case 1:
	       try {
			openConnection();
			entityTransaction.begin();
			System.out.println("enter car name");
			String name =inp.next();
			
			query="select detail from Car detail  where name='"+name+"'";
			Query query1= entityManager.createQuery(query);
			List<Car> cars=query1.getResultList();
			for(Car car : cars) {
				System.out.println(car);
				}
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection1();
		}
	       
		break;
	case 2:
		try {
			openConnection();
			entityTransaction.begin();
			System.out.println("enter car brand");
			String brand =inp.next();
			
			query="select car from Car car  where name='"+brand+"'";
			Query query1= entityManager.createQuery(query);
			List<Car> cars=query1.getResultList();
			for(Car car : cars) {
				System.out.println(car);
				}
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection1();
		}
	       
		break;
	case 3:
		try {
			openConnection();
			entityTransaction.begin();
			System.out.println("enter car fuelType");
			String fuelType =inp.next();
			
			query="select car from Car car  where fuelType='"+fuelType+"'";
			Query query1= entityManager.createQuery(query);
			List<Car> cars=query1.getResultList();
			for(Car car : cars) {
				System.out.println(car);
				}
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection1();
		}
	       
		break;
	case 4:
		try {
			openConnection();			
			allCarDetails();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeConnection1();
		}
	       break;	
	case 5:
		carDekhoMenu=new CarDekhoMenu();
	    carDekhoMenu.menu();
		break;

	default:
		System.out.println("invalid choice \n please choose correct choice\n Try Again");
		
	}
     
	}

public void updateCarDetails() {
	 try {
		openConnection();
		allCarDetails();
		inp=new Scanner(System.in);
		
		System.out.println("which car do you want to update ");
		System.out.println("enter car id");
        int id=inp.nextInt();
		System.out.println("\n what do you update\n"
				+ " 1.Car name\n 2.car Brand\n 3.fueltype\n 4.price\n 5.Menu");
	   int choice=inp.nextInt();
	   entityTransaction.begin();
	   switch (choice) {
	case 1:
	        System.out.println("enter your car name");
	        
	     query1=entityManager.createQuery("update Car set name = '"+inp.next()+"' where id="+id);
	        rows=query1.executeUpdate();
	       
	        if(rows != 0){
				System.out.println("Car details update successfully");
			}
	        entityTransaction.commit();
	        break;
	        
	case 2:System.out.println("enter your car brand");
    
         query1=entityManager.createQuery("update Car set brand = '"+inp.next()+"' where id="+id);
         rows=query1.executeUpdate();
   
           if(rows != 0){
	    	System.out.println("Car details update successfully");
          	}
          entityTransaction.commit();
    break;
	case 3:System.out.println("enter your car fueltype");
    
    query1=entityManager.createQuery("update Car set fuelType = '"+inp.next()+"' where id="+id);
    rows=query1.executeUpdate();

      if(rows != 0){
   	System.out.println("Car details update successfully");
     	}
     entityTransaction.commit();
		break;
	case 4:System.out.println("enter your car price");
    
    query1=entityManager.createQuery("update Car set price = "+inp.nextDouble()+" where id="+id);
    rows=query1.executeUpdate();

      if(rows != 0){
   	System.out.println("Car details update successfully");
     	}
     entityTransaction.commit();
     
     break;
	case 5: CarDekhoMenu carDekhoMenu=new CarDekhoMenu();
	        carDekhoMenu.menu();
	        closeConnection1();
		break;
		default:
			System.out.println("invalid choice");
	}
	 }catch (Exception e) {
		 e.printStackTrace();
	}finally {
	 closeConnection1();   
	}
}


     public void deleteCarDetails()  {
        try {
        	openConnection();
    		allCarDetails();
    		entityTransaction.begin();
    		inp=new Scanner(System.in);
    		
    		System.out.println("which car do you want to update ");
    		System.out.println("enter car id");
            int id=inp.nextInt();
    	    query1 = entityManager.createQuery("delete from Car where id="+id);
    	    rows=query1.executeUpdate();
    	    if(rows != 0) {
    	    	System.out.println("Car detatis deleted successful!!!!");
    	    }
    	    entityTransaction.commit();
		   } catch (Exception e) {
              e.printStackTrace();
           } finally {
			closeConnection1();
		}
}

}
