# Shopify Developer Challenge 2019 Winter

https://docs.google.com/document/d/1YYDRf_CgQRryf5lZdkZ2o3Hm3erFSaISL1L1s8kLqsI/edit

# Overview

This product was built using GCP Cloud Endpoints running on a AppEngine Standard instance. GCP Datastore
was used as the database (mostly because I didn't have the time to setup a schema for a relational
database :/ ).

Java 8 and Maven was used for this project. Dependencies include Guice, Lombok, and Objectify
(to interface with Datastore).

Slate was used to generate the API documentation.

# API

Host: https://jeffyang-shopifychallenge2019w.appspot.com/_ah/api/

Documentation: https://jeffjyang.github.io/shopifychallenge2019w/

API Explorer (could be useful): https://jeffyang-shopifychallenge2019w.appspot.com/_ah/api/explorer

# Limitations

Due to time restrictions, not all of the requested functionality of the challenge was implemented.
This would include anything to do with security, error and exception handling, and any sort of input
validation. However, because of the way this project is setup, many of the missing functionality can
be easily added without too much
effort
