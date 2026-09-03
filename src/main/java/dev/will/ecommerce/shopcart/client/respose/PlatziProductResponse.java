package dev.will.ecommerce.shopcart.client.respose;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziProductResponse(
        Long id,
        String title,
        BigDecimal price
) implements Serializable {
}
