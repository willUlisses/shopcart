package dev.will.ecommerce.shopcart.service;

import dev.will.ecommerce.shopcart.client.respose.PlatziProductResponse;
import dev.will.ecommerce.shopcart.controller.request.CartRequest;
import dev.will.ecommerce.shopcart.controller.request.PaymentRequest;
import dev.will.ecommerce.shopcart.entity.Cart;
import dev.will.ecommerce.shopcart.entity.Product;
import dev.will.ecommerce.shopcart.entity.Status;
import dev.will.ecommerce.shopcart.exceptions.BusinessException;
import dev.will.ecommerce.shopcart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
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
                    throw new BusinessException("There is already an open cart for this client");
                });


        List<Product> products = getProducts(cartRequest);

        Cart cart  = Cart.builder()
                .client(cartRequest.clientId())
                .status(Status.OPEN)
                .products(products)
                .build();

        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }

    public Cart updateShopcart(CartRequest cartRequest, String id) {
        Cart cart = getCartById(id);

        List<Product> products = getProducts(cartRequest);

        cart.setProducts(products);
        cart.calculateTotalPrice();
        return cartRepository.save(cart);
    }



    public Cart payCart(PaymentRequest request, String id) {
        Cart cart = getCartById(id);

        cart.setPaymentMethod(request.paymentMethod());
        cart.setStatus(Status.SOLD);
        return cartRepository.save(cart);
    }

    public void deleteCart(String id) {
        cartRepository.deleteById(id);
    }

    private List<Product> getProducts(CartRequest cartRequest) {
        List<Product> products = new ArrayList<>();
        cartRequest.products().forEach(productRequest -> {
            PlatziProductResponse platziProductResponse = productService.getProductById(productRequest.id());
            products.add(
                    Product.builder()
                            .id(platziProductResponse.id())
                            .title(platziProductResponse.title())
                            .price(platziProductResponse.price())
                            .quantity(productRequest.quantity())
                            .build()
            );
        });
        return products;
    }

}
