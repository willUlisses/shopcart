package dev.will.ecommerce.shopcart.service;

import dev.will.ecommerce.shopcart.client.PlatziStoreClient;
import dev.will.ecommerce.shopcart.client.respose.PlatziProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final PlatziStoreClient platziStoreClient

    public List<PlatziProductResponse> getAllProducts() {
        return platziStoreClient.getAllProducts();
    }

    public PlatziProductResponse getProductById(Long id) {
        return platziStoreClient.getProductById(id);
    }

}
