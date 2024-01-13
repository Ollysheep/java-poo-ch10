package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.ProductRepository;
import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;
import co.simplon.poo.ch10.tp1.service.impl.ProductServiceImpl;
import co.simplon.poo.ch10.tp1.service.ProductService;

class TestProductService {
	
	private ProductRepositoryJson product = new ProductRepositoryJson("data/json/products.json");
	private ProductService productService = new ProductServiceImpl(product);
	
	@BeforeEach
	void beforeEachTest() throws IOException {
		product.deleteAll();
	}

	@Test
	void testUpdateProductQuantity() throws Exception {
		
		// 10 fake products creation
		for (int i = 1; i < 10; i++) {
			product.create(new Product("product" + i, 25 + i, 200 + i, true));
		}
		
		// Retrieve first fake user named user1
		Product product1 = product.getByName("product1");

		//calling service method
		productService.updateProductQuantity(product1.getName(), 100);
		
		//Controlling
		assertEquals(100, product1.getQuantity());
	}
	
	@Test
	void testUpdateProductPrice() throws Exception {
		
		// 10 fake products creation
		for (int i = 1; i < 10; i++) {
			product.create(new Product("product" + i, 25 + i, 200 + i, true));
		}
		
		// Retrieve first fake user named user1
		Product product1 = product.getByName("product1");

		//calling service method
		productService.updateProductPrice(product1.getName(), 50);
		
		//Controlling
		assertEquals(50, product1.getPrice());
	}
}
