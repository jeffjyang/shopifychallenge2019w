package com.jeffyang.shopifychallenge.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor // needed since we have builder annotation
@Entity
public class Shop {

  private String name;

  @Id
  private String shopId;

  private Map<String, Product> products = new HashMap<>();
  private Map<String, Order> orders = new HashMap<>();

}
