package com.jeffyang.shopifychallenge.dao;

import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.service.OfyService;

public class OfyShopDao extends OfyService<Shop> {
  public OfyShopDao() {
    super(Shop.class);
  }

}
