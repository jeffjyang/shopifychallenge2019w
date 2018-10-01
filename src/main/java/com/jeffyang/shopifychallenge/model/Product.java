package com.jeffyang.shopifychallenge.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor // needed because of a lombok quirk with @Builder
@Builder
@EqualsAndHashCode()
public class Product {

  protected String productId;
  protected String name;
  protected String description;
  protected int centValue;

}
