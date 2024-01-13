package co.simplon.poo.ch10.tp1.service;

public interface ProductService {

	void updateProductQuantity(String productId, int newQuantity);
	void updateProductPrice(String productId, int newPrice);
	
}
