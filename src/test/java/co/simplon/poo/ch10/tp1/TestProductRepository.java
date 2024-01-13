package co.simplon.poo.ch10.tp1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.simplon.poo.ch10.tp1.model.Product;
import co.simplon.poo.ch10.tp1.repository.impl.ProductRepositoryJson;

class TestProductRepository {
	
	private ProductRepositoryJson products = new ProductRepositoryJson("data/json/products.json");

	@BeforeEach
	void beforeEachTest() throws IOException {
		products.deleteAll();
	}


	@Test
	void testCreateAndRetrieve() throws IOException {
		products.create(new Product("Chocolat", 25, 200, true));
		products.create(new Product("Bonbon", 5, 400, true));
		List<Product> testList = products.retrieve();
		assertEquals(2, testList.size());
	}


	@Test
	void testUpdate() throws Exception {
		Product chocolat = products.create(new Product("Chocolat", 25, 200, true));
		assertEquals(25, products.getByName("Chocolat").getPrice());
		chocolat.setPrice(30);
		products.update(chocolat, chocolat.getId());
		assertEquals(30, products.getByName("Chocolat").getPrice());
	}

	@Test
	void testDelete() throws IOException {
		Product chocolat = products.create(new Product("Chocolat", 25, 200, true));
		assertEquals(1, products.count());

		try {
			products.delete(chocolat.getId());
			assertEquals(0, products.count());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	@Test
	void testGetByName() throws IOException {
		products.create(new Product("Chocolat", 25, 200, true));
		products.create(new Product("Bonbon", 5, 400, true));
		
		assertNotNull(products.getByName("Chocolat"));
		assertNotNull(products.getByName("Bonbon"));
		assertNull(products.getByName("Cocholat"));
		assertNull(products.getByName("Bnobno"));
	}
	
	@Test
	void testGetById() throws IOException {
		String id = products.create(new Product("Chocolat", 25, 200, true)).getId();
		assertEquals("Chocolat", products.getById(id).getName());
	}

}