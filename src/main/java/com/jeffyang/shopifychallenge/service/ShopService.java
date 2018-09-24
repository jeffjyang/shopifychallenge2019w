package com.jeffyang.shopifychallenge.service;

import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.ofy.OfyShop;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@NoArgsConstructor
@Singleton
public class ShopService {

  @Inject
  private OfyShop ofyShop;

  public Shop getShop(String shopId) {
    return ofyShop.get(shopId);
  }

  public Shop createShop(String shopName) {
    Shop shop = Shop.builder()
        .name(shopName)
        .shopId(UUID.randomUUID().toString()).build();
    ofyShop.save(shop);
    return shop;
  }

  public Product createProduct(String shopId, String productName, int centValue, String productDescription) {
    Product product = Product.builder()
        .lineItemName(productName)
        .centValue(centValue)
        .description(productDescription)
        .lineItemId(UUID.randomUUID().toString()).build();

    Shop shop = ofyShop.get(shopId);
    shop.getProducts().put(product.getLineItemId(), product);
    ofyShop.save(shop);
    return product;
  }

}
