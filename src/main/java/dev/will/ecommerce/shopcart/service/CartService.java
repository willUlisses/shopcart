package dev.will.ecommerce.shopcart.service;

import dev.will.ecommerce.shopcart.client.respose.PlatziProductResponse;
import dev.will.ecommerce.shopcart.controller.request.CartRequest;
import dev.will.ecommerce.shopcart.entity.Cart;
import dev.will.ecommerce.shopcart.entity.Product;
import dev.will.ecommerce.shopcart.entity.Status;
import dev.will.ecommerce.shopcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductService productService;


    public Cart getCartById(String id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));
    }

    public Cart createShopcart(CartRequest cartRequest) {

        cartRepository.findByClientAndStatus(cartRequest.clientId(), Status.OPEN)
                .ifPresent(shopcart -> {
                    throw new IllegalArgumentException("There is already an open cart for this client");
                });


        List<Product> products = new ArrayList<>();

        cartRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(productRequest.id());
            products.add(Product.builder()
                    .id(platziProductResponse.id())
                    .title(platziProductResponse.title())
                    .price(platziProductResponse.price())
                    .quantity(productRequest.quantity())
                    .build());
        });

        Cart cart  = Cart.builder()
                .client(cartRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }


}
