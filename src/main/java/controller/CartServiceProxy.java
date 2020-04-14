package controller;

import javax.websocket.server.PathParam;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import entity.Product;

@FeignClient(name="product-service")
@RibbonClient("product-service")
public interface CartServiceProxy {
	@GetMapping("/findProduct/{productid}")
	public Product getProduct(@PathParam(value="prodid")long prodid);
}