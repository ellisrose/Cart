package controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import entity.Cart;
import entity.Product;
import entity.ProductList;
import service.CartService;

@RestController
public class CartResource {
	CartService cartService;
	RestTemplate restTemplate;
	CartServiceProxy cartServiceProxy;
	
	@GetMapping(value="/add/{prodid}")
	public void addToCart(@PathParam(value = "cart") long prodid, @RequestParam Cart cart) {
		Product product=null;
		try {
        	product = cartServiceProxy.getProduct(prodid);
        }catch(Exception ex){ex.printStackTrace();}
		cartService.addToCart(product, cart.getId());
	}
	
	@GetMapping(value="/clear")
	public void clear(@RequestParam(value = "cart") Cart cart) {
		long i = cart.getId();
		cartService.emptyCart(i);
	}
	
	@GetMapping(value="/delete/${prodid}")
	public void clear(@PathParam(value = "cart") long prodId, @RequestParam(value = "cart") Cart c) {
		cartService.delete(prodId,c.getId());
	}

	@GetMapping(path="/sendCart/${cartid}")
	public List<Product> sendCart(@PathParam(value = "cartid") long cartid) {
		List<Product> plist = cartService.dispCart(cartid);
		return plist;
	}
}
