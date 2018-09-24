package com.jeffyang.shopifychallenge.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class ShopifyChallengeGuiceListener extends GuiceServletContextListener {
  @Override
  protected Injector getInjector() {
    return Guice.createInjector(new ShopifyChallengeGuiceModule());
  }

}
