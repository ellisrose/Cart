package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Cart;
import entity.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
