package com.jeffyang.shopifychallenge.ofy;

import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.service.OfyService;
import lombok.Data;

@Data
public class OfyShop extends OfyService<Shop> {

  public OfyShop() {
    super(Shop.class);
  }

}
