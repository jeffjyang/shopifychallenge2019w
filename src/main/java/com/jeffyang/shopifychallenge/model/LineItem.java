package com.jeffyang.shopifychallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem extends Product {

  private int quantity = 1;

  public static LineItem of(Product product) {
    LineItem lineItem = new LineItem();

    lineItem.setProductId(product.getProductId());
    lineItem.setCentValue(product.getCentValue());
    lineItem.setName(product.getName());
    lineItem.setDescription(product.getDescription());

    return lineItem;
  }

}
