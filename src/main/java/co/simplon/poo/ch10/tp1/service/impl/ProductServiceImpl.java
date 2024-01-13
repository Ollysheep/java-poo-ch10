package co.simplon.poo.ch10.tp1.service.impl;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.repository.UserRepository;
import co.simplon.poo.ch10.tp1.service.ProductService;

public class ProductServiceImpl implements ProductService{

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository products) {
		this.productRepository = products;
	}
	
	@Override
	public void updateProductQuantity(String productId, int newQuantity) {
		Product product = productRepository.getByName(productId);
		if (product != null) {
			product.setQuantity(newQuantity);			
		}
		
		
	}

	@Override
	public void updateProductPrice(String productId, int newPrice) {
		Product product = productRepository.getByName(productId);
		if (product != null) {
			product.setPrice(newPrice);	
		}
	}

}
