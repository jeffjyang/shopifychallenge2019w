package com.jeffyang.shopifychallenge.service;

import com.jeffyang.shopifychallenge.model.LineItem;
import com.jeffyang.shopifychallenge.model.Order;
import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.model.Shop;
import com.jeffyang.shopifychallenge.ofy.OfyShop;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.UUID;

@Singleton
public class OrderService {
  @Inject
  private OfyShop ofyShop;

  public Order getOrder(String shopId, String orderId) {
    Shop shop = ofyShop.get(shopId);
    return shop.getOrders().get(orderId);
  }

  public Order createOrder(String shopId) {
    Shop shop = ofyShop.get(shopId);
    Order order = new Order();
    order.setOrderId(UUID.randomUUID().toString());
    shop.getOrders().put(order.getOrderId(), order);
    ofyShop.save(shop);
    return order;
  }

  public void addItemToOrder(String shopId, String orderId, String lineItemId) {
    Shop shop = ofyShop.get(shopId);
    Product product = shop.getProducts().get(lineItemId);
    // objectify doesn't like it if we try to add Product into our cart :/
    LineItem lineItem = LineItem.of(product);
    shop.getOrders().get(orderId).getCart().put(product.getLineItemId(), lineItem);
    ofyShop.save(shop);
  }

  public int getCost(String shopId, String orderId) {
    Shop shop = ofyShop.get(shopId);
    Order order = shop.getOrders().get(orderId);
    System.out.println("Cart items: " + order.getCart().toString());
    return order.getCart().values().stream()
        .map(LineItem::getCentValue)
        .reduce(0, Integer::sum);
  }


}
