package dev.will.ecommerce.shopcart.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 400:
                return new NotFoundException("Product Not Found");
            default:
                return new Exception("Generic Exception");
        }
    }
}
