package com.jeffyang.shopifychallenge.service;

import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.dao.OfyShopDao;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@NoArgsConstructor
@Singleton
public class ShopService {

  @Inject
  private OfyShopDao shopDao;

  public Shop getShop(String shopId) {
    return shopDao.get(shopId);
  }

  public Shop createShop(String shopName) {
    Shop shop = Shop.builder()
        .name(shopName)
        .shopId(UUID.randomUUID().toString()).build();
    shopDao.save(shop);
    return shop;
  }

  public Product createProduct(String shopId, String productName, int centValue, String productDescription) {
    Product product = Product.builder()
        .name(productName)
        .centValue(centValue)
        .description(productDescription)
        .productId(UUID.randomUUID().toString()).build();

    Shop shop = shopDao.get(shopId);
    shop.getProducts().put(product.getProductId(), product);
    shopDao.save(shop);
    return product;
  }

  public void deleteShop(String shopId) {
    shopDao.delete(shopId);
  }

  public void deleteProduct(String shopId, String productId) {
    Shop shop = shopDao.get(shopId);
    shop.getProducts().remove(productId);
    shopDao.save(shop);
  }

}
