package com.jeffyang.shopifychallenge.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor // needed because of a lombok quirk with @Builder
@Builder
@Entity
public class Order {

  @Id
  private String orderId;

  @Index
  private String shopId;

  // productId, quantity
  private Map<String, LineItem> cart = new HashMap<>();

}
