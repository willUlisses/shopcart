package dev.will.ecommerce.shopcart.service;

import dev.will.ecommerce.shopcart.client.PlatziStoreClient;
import dev.will.ecommerce.shopcart.client.respose.PlatziProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final PlatziStoreClient platziStoreClient;

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts() {
        return platziStoreClient.getAllProducts();
    }

    @Cacheable(value = "product", key = "#id")
    public PlatziProductResponse getProductById(Long id) {
        return platziStoreClient.getProductById(id);
    }

}
