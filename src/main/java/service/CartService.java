package service;

import java.util.List;

import entity.Product;
import entity.ProductList;

public interface CartService {
	void addToCart(Product product, long id);
	void delete(long prodid, long cid);
	void emptyCart(long id);
	List<Product> dispCart(long id);
}
