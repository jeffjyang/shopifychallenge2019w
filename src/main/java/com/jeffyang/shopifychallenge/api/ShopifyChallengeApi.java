package com.jeffyang.shopifychallenge.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.jeffyang.shopifychallenge.model.Order;
import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.service.OrderService;
import com.jeffyang.shopifychallenge.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.inject.Inject;

@Api(
  name = "shopifychallengeapi",
  version = "v1")
public class ShopifyChallengeApi {

  @Inject
  private ShopService shopService;

  @Inject
  private OrderService orderService;

  @ApiMethod(
      httpMethod = ApiMethod.HttpMethod.GET,
      path = "/hello")
  public HelloWorld helloWorld() {
    return new HelloWorld();
  }
  private class HelloWorld {
    private final String helloWorld = "hi world!";
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/shop")
  public Shop createShop(@Named("shopName") String shopName) {
    return shopService.createShop(shopName);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}")
  public Shop getShop(@Named("shopId") String shopId) {
    Shop shop = shopService.getShop(shopId);
    shop.setOrders(null); // do not expose the shop's orders
    return shop;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}/order/{orderId}")
  public Order getOrder(@Named("shopId") String shopId,
                        @Named("orderId") String orderId) {
    return orderService.getOrder(shopId, orderId);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
      path = "/shop/{shopId}/order/{orderId}/cost")
  public CostWrapper getOrderCost(@Named("shopId") String shopId,
                                  @Named("orderId") String orderId) {
    return CostWrapper.of(orderService.getCost(shopId, orderId));
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/product")
  public Product createProduct(@Named("shopId") String shopId,
                               @Named("productName") String productName,
                               @Named("centValue") int centValue,
                               @Named("productDescription") String productDescription) {
    return shopService.createProduct(shopId, productName, centValue, productDescription);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order")
  public Order createOrder(@Named("shopId") String shopId) {
    Order order = orderService.createOrder(shopId);
    return order;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order/product")
  public void addItemToOrder(@Named("shopId") String shopId,
                             @Named("orderId") String orderId,
                             @Named("productId") String productId) {
    orderService.addItemToOrder(shopId, orderId, productId);
  }

  @RequiredArgsConstructor(staticName = "of")
  @Value
  private static class CostWrapper {
    private int centValue;
  }

}
