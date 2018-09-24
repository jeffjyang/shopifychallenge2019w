package com.jeffyang.shopifychallenge.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Product extends LineItem {

  private String description;

  @Builder
  private Product(String lineItemName, String lineItemId, int centValue, String description) {
    super(lineItemName, lineItemId, centValue);
    this.description = description;
  }

  public static Product of(Product product) {
    return new Product(product.getName(), product.getLineItemId(), product.getCentValue(), product.getDescription());
  }

}
