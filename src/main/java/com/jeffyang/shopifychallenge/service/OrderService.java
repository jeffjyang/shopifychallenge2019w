package com.jeffyang.shopifychallenge.service;

import com.jeffyang.shopifychallenge.dao.OfyOrderDao;
import com.jeffyang.shopifychallenge.model.LineItem;
import com.jeffyang.shopifychallenge.model.Order;
import com.jeffyang.shopifychallenge.model.Product;
import com.jeffyang.shopifychallenge.dao.OfyShopDao;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.UUID;

@Singleton
public class OrderService {
  @Inject
  private OfyOrderDao orderDao;

  @Inject
  private OfyShopDao shopDao;

  public Order getOrder(String orderId) {
    return orderDao.get(orderId);
  }

  public Order createOrder(String shopId) {
    Order order = Order.builder()
        .shopId(shopId)
        .orderId(UUID.randomUUID().toString()).build();

    orderDao.save(order);
    return order;
  }

  public void deleteOrder(String orderId) {
    orderDao.delete(orderId);
  }

  public void addItemToOrder(String orderId, String productId) {
    Order order = orderDao.get(orderId);

    if (order.getCart().containsKey(productId)) {
      LineItem lineItem = order.getCart().get(productId);
      lineItem.setQuantity(lineItem.getQuantity() + 1);
      orderDao.save(order);
      return;
    }

    Product product = shopDao.get(order.getShopId()).getProducts().get(productId);
    LineItem lineItem = LineItem.of(product);

    order.getCart().put(lineItem.getProductId(), lineItem);
    orderDao.save(order);

  }

  public void removeItemFromOrder(String orderId, String productId) {
    Order order = orderDao.get(orderId);

    if (order.getCart().containsKey(productId)) {
      LineItem lineItem = order.getCart().get(productId);
      if (lineItem.getQuantity() == 1) {
        order.getCart().remove(productId);
      } else {
        lineItem.setQuantity(lineItem.getQuantity() - 1);
      }
      orderDao.save(order);
    }

  }


  public int getCost(String orderId) {
    Order order = orderDao.get(orderId);
    return order.getCart().values().stream()
        .map(LineItem::getCentValue)
        .reduce(0, Integer::sum);
  }

  public List<Order> getAllOrdersForShop(String shopId) {
    return orderDao.queryByShop(shopId);
  }

}
