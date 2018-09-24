package com.jeffyang.shopifychallenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Order {

  private String orderId;
  private Map<String, LineItem> cart = new HashMap<>();

}
