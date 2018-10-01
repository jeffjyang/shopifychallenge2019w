package com.jeffyang.shopifychallenge.api;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;
import com.jeffyang.shopifychallenge.model.Order;
import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.model.Shop;

import java.util.List;

public class ShopApi extends ShopifyChallengeApiBase {

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}")
  public Shop getShop(@Named("shopId") String shopId) {
    Shop shop = shopService.getShop(shopId);
    return shop;
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/shop")
  public Shop createShop(@Named("shopName") String shopName) {
    return shopService.createShop(shopName);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.DELETE,
             path = "/shop/{shopId}")
  public void deleteShop(@Named("shopId") String shopId) {
    shopService.deleteShop(shopId);
  }


  @ApiMethod(httpMethod = ApiMethod.HttpMethod.POST,
             path = "/shop/{shopId}/product")
  public Product addProductToShop(@Named("shopId") String shopId,
                               @Named("productName") String productName,
                               @Named("centValue") int centValue,
                               @Named("productDescription") String productDescription) {
    return shopService.createProduct(shopId, productName, centValue, productDescription);
  }

  @ApiMethod(httpMethod = ApiMethod.HttpMethod.DELETE,
             path = "/shop/{shopId}/product/{productId}")
  public void deleteProductFromShop(@Named("shopId") String shopId,
                                    @Named("productId") String productId) {
    shopService.deleteProduct(shopId, productId);
  }


  @ApiMethod(httpMethod = ApiMethod.HttpMethod.GET,
             path = "/shop/{shopId}/orders")
  public List<Order> getShopOrders(@Named("shopId") String shopId) {
    return orderService.getAllOrdersForShop(shopId);
  }

}
