package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import entity.Cart;
import entity.Product;
import entity.ProductList;
import repository.CartRepository;

@Service
public class CartServiceImp implements CartService{
	CartRepository cartRepository;
	

	@Override
	public void addToCart(Product product,long id) {
		Optional<Cart> c = cartRepository.findById(id);
		c.get().add(product);
		cartRepository.save(c.get());
	}

	@Override
	public void delete(long id,long cid) {
		// TODO Auto-generated method stub
		Optional<Cart> c = cartRepository.findById(cid);
		c.get().del(id);
		cartRepository.save(c.get());
	}

	@Override
	public void emptyCart(long id) {
		Optional<Cart> c = cartRepository.findById(id);
		c.get().setpList(null);
		cartRepository.save(c.get());
	}

	@Override
	public List<Product> dispCart(long id) {
		// TODO Auto-generated method stub
		Optional<Cart> c = cartRepository.findById(id);
		return c.get().getpList();
	}

}
