package dev.will.ecommerce.shopcart.controller;

import dev.will.ecommerce.shopcart.controller.request.CartRequest;
import dev.will.ecommerce.shopcart.controller.request.PaymentRequest;
import dev.will.ecommerce.shopcart.entity.Cart;
import dev.will.ecommerce.shopcart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCart(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getCartById(id));
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartService.createShopcart(body));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cart> createCart(@RequestBody CartRequest body, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.updateShopcart(body, id));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Cart> payCart(@RequestBody PaymentRequest body, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.payCart(body, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable String id) {
        cartService.deleteCart(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
