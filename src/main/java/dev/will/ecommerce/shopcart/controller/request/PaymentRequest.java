package dev.will.ecommerce.shopcart.controller.request;

import dev.will.ecommerce.shopcart.entity.PaymentMethod;

public record PaymentRequest(
        PaymentMethod paymentMethod
) {
}
