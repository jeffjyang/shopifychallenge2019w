package com.jeffyang.shopifychallenge.api;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.jeffyang.shopifychallenge.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.Value;

public class OrderApi extends ShopifyChallengeApiBase {

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/order/{orderId}")
  public Order getOrder(@Named("orderId") String orderId) {
    return orderService.getOrder(orderId);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order/")
  public Order createOrder(@Named("shopId") String shopId) {
    return orderService.createOrder(shopId);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.DELETE,
             path = "/order/{orderId}")
  public void deleteOrder(@Named("orderId") String orderId) {
    orderService.deleteOrder(orderId);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order/{orderId}/product")
  public void addItemToOrder(@Named("orderId") String orderId,
                             @Named("productId") String productId) {
    orderService.addItemToOrder(orderId, productId);
  }


  @ApiMethod(httpMethod = ApiMethod.HttpMethod.DELETE,
             path = "/order/{orderId}/product/{productId}")
  public void removeItemFromOrder(@Named("orderId") String orderId,
                                 @Named("productId") String productId) {
    orderService.removeItemFromOrder(orderId, productId);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/order/{orderId}/total")
  public TotalCost getCostofOrder(@Named("orderId") String orderId) {
    return TotalCost.of(orderService.getCost(orderId));
  }

  // wrapper class since GCP Endpoints cannot return primitives.
  @RequiredArgsConstructor(staticName = "of")
  @Value
  private static class TotalCost{
    private int centValue;
  }


}
