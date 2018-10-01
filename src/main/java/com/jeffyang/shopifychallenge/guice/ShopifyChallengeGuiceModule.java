package com.jeffyang.shopifychallenge.guice;

import com.google.api.control.extensions.appengine.GoogleAppEngineControlFilter;
import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;
import com.googlecode.objectify.ObjectifyFilter;
import com.jeffyang.shopifychallenge.api.OrderApi;
import com.jeffyang.shopifychallenge.api.ShopApi;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

public class ShopifyChallengeGuiceModule extends EndpointsModule {

  @Override
  public void configureServlets() {
    super.configureServlets();

    bind(ObjectifyFilter.class).in(Singleton.class);

    filter("/*").through(ObjectifyFilter.class);

    Map<String, String> apiController = new HashMap<String, String>();
    apiController.put("endpoints.projectId", "jeffyang-shopifychallenge2019w");
    apiController.put("endpoints.serviceName", "jeffyang-shopifychallenge2019w.appspot.com");

    bind(GoogleAppEngineControlFilter.class).in(Singleton.class);
    filter("/_ah/api/*").through(GoogleAppEngineControlFilter.class, apiController);

    bind(ShopApi.class).toInstance(new ShopApi());
    bind(OrderApi.class).toInstance(new OrderApi());
    configureEndpoints("/_ah/api/*", ImmutableList.of(ShopApi.class, OrderApi.class));
  }

}
