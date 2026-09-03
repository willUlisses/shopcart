package dev.will.ecommerce.shopcart.exceptions;

public class BusinessException extends RuntimeException {
  public BusinessException(String message) {
    super(message);
  }
}
