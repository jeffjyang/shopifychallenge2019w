package com.jeffyang.shopifychallenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LineItem {

  protected String name;
  protected String lineItemId;
  protected int centValue;

  public static LineItem of(Product product) {
    // this is really just here as a hack around a objectify quirk, see OrderService
    LineItem lineItem = new LineItem();
    lineItem.setName(product.getName());
    lineItem.setLineItemId(product.getLineItemId());
    lineItem.setCentValue(product.getCentValue());
    return lineItem;
  }

}
