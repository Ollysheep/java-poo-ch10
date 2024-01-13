package co.simplon.poo.ch10.tp1.service.impl;

import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository products) {
		this.products = products;
	}
	
	@Override
	public void updateProductQuantity(String productId, int newQuantity) {
		
		
	}

	@Override
	public void updateProductPrice(String productId, int newPrice) {
		// TODO Auto-generated method stub
		
	}
	

}
