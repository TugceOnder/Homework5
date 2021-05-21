package nLayeredDemo;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.business.concretes.ProductManager;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.data.Access.concretes.AbcProductDao;
import nLayeredDemo.data.Access.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;

public class Main {

	public static void main(String[] args) {
		ProductService productService = new ProductManager(new AbcProductDao(),new LoggerService() {
			
			@Override
			public void logToSystem(String message) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Product product = new Product(2,3,"Elma",12,50);
		productService.add(product);
	}

}
