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

  private final RedirectMessageWrapper redirectMessageWrapper = new RedirectMessageWrapper();

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
  public RedirectMessageWrapper createShop(@Named("shopName") String shopName) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}")
  public RedirectMessageWrapper getShop(@Named("shopId") String shopId) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}/order/{orderId}")
  public RedirectMessageWrapper getOrder(@Named("shopId") String shopId,
                        @Named("orderId") String orderId) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
      path = "/shop/{shopId}/order/{orderId}/cost")
  public RedirectMessageWrapper getOrderCost(@Named("shopId") String shopId,
                                  @Named("orderId") String orderId) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/product")
  public RedirectMessageWrapper createProduct(@Named("shopId") String shopId,
                               @Named("productName") String productName,
                               @Named("centValue") int centValue,
                               @Named("productDescription") String productDescription) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order")
  public RedirectMessageWrapper createOrder(@Named("shopId") String shopId) {
    return redirectMessageWrapper;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/order/product")
  public RedirectMessageWrapper addItemToOrder(@Named("shopId") String shopId,
                             @Named("orderId") String orderId,
                             @Named("productId") String productId) {
    return redirectMessageWrapper;
  }

  @RequiredArgsConstructor(staticName = "of")
  @Value
  private static class CostWrapper {
    private int centValue;
  }

  private static class RedirectMessageWrapper {

    private final String NOTE = "THIS PROJECT IS OUTDATED! I have worked on this project a bit more" +
        "and have a newer implementation of it. All the endpoints of this project now returns this " +
        "redirect message. The updated implementation can be found at: \n https://github.com/jeffjyang/shopifychallenge2019w \n " +
        "For reference, documentation can be found at: https://jeffjyang.github.io/shopifychallenge2019w/#introduction \n" +
        "You can use the shopId of 2113d324-479f-42ab-8d85-f1c531b22a3b for some sample data that has " +
        "been used to populate the database";

  }


}
