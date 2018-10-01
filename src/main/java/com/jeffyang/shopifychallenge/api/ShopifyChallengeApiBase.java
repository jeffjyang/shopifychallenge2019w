package com.jeffyang.shopifychallenge.api;

import com.google.api.server.spi.config.Api;
import com.jeffyang.shopifychallenge.service.OrderService;
import com.jeffyang.shopifychallenge.service.ShopService;

import javax.inject.Inject;

@Api(
    name = "shopifychallengeapi",
    version = "v1")
public class ShopifyChallengeApiBase {
  @Inject
  protected ShopService shopService;

  @Inject
  protected OrderService orderService;
}
