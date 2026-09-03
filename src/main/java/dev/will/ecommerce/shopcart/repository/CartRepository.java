package dev.will.ecommerce.shopcart.repository;

import dev.will.ecommerce.shopcart.entity.Cart;
import dev.will.ecommerce.shopcart.entity.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart, String> {


    Optional<Cart> findByClientAndStatus(Long client, Status status);
}
