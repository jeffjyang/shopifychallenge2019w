package com.jeffyang.shopifychallenge.dao;

import com.jeffyang.shopifychallenge.model.Order;
import com.jeffyang.shopifychallenge.service.OfyService;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class OfyOrderDao extends OfyService<Order> {
  public OfyOrderDao() {
    super(Order.class);
  }

  public List<Order> queryByShop(String shopId) {
    return ofy().load().type(Order.class).filter("shopId =", shopId).list();
  }

}
