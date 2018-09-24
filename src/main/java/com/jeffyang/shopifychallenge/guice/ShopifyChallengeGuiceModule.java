package com.jeffyang.shopifychallenge.guice;

import com.google.api.control.ServiceManagementConfigFilter;
import com.google.api.control.extensions.appengine.GoogleAppEngineControlFilter;
import com.google.api.server.spi.guice.EndpointsModule;
import com.google.common.collect.ImmutableList;
import com.googlecode.objectify.ObjectifyFilter;
import com.jeffyang.shopifychallenge.api.ShopifyChallengeApi;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

public class ShopifyChallengeGuiceModule extends EndpointsModule {

  @Override
  public void configureServlets() {
    super.configureServlets();

    bind(ServiceManagementConfigFilter.class).in(Singleton.class);
    bind(ObjectifyFilter.class).in(Singleton.class);

    filter("/*").through(ObjectifyFilter.class);
    filter("/_ah/api/*").through(ServiceManagementConfigFilter.class);

    Map<String, String> apiController = new HashMap<String, String>();
    apiController.put("endpoints.projectId", "jeffyang-shopifychallenge");
    apiController.put("endpoints.serviceName", "jeffyang-shopifychallenge.appspot.com");
    bind(GoogleAppEngineControlFilter.class).in(Singleton.class);
    filter("/_ah/api/*").through(GoogleAppEngineControlFilter.class, apiController);
    bind(ShopifyChallengeApi.class).toInstance(new ShopifyChallengeApi());
    configureEndpoints("/_ah/api/*", ImmutableList.of(ShopifyChallengeApi.class));
  }

}
