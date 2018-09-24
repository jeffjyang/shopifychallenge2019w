package com.jeffyang.shopifychallenge.service;

import com.googlecode.objectify.ObjectifyService;

import javax.inject.Singleton;

import static com.googlecode.objectify.ObjectifyService.ofy;

@Singleton
public class OfyService<T> {

  private final Class<T> clazz;

  public OfyService(Class<T> clazz) {
    this.clazz = clazz;
    ObjectifyService.register(clazz);
  }

  public T get(String id) {
    return ofy().load().type(clazz).id(id).now();
  }

  public void save(T entity) {
    ofy().save().entity(entity).now();
  }
}
