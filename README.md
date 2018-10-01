# NOTE!

Outdated! See https://github.com/jeffjyang/shopifychallenge2019w for newest implementation

# Shopify Developer Challenge 2019 Winter

https://docs.google.com/document/d/1YYDRf_CgQRryf5lZdkZ2o3Hm3erFSaISL1L1s8kLqsI/edit

# Overview

This product was built using GCP Cloud Endpoints running on a AppEngine Standard instance. GCP Datastore
was used as the database (mostly because I didn't have the time to setup a schema for a relational
database :/ ).

Java 8 and Maven was used for this project. Dependencies include Guice, Lombok, and Objectify
(to interface with Datastore).

# API

Host: https://jeffyang-shopifychallenge.appspot.com/_ah/api/

API Explorer: https://jeffyang-shopifychallenge.appspot.com/_ah/api/explorer

-------------------------------------------------------------------------------
### Create shop:

endpoint: POST ./shop/

request:
```
{
	"shopName": <String>
}
```

response:
```
{
    "name": <String>,
    "shopId": <UUID String>
}
```

-------------------------------------------------------------------------------
### Get shop:

endpoint: GET ./shop/{shopId}
(sample shopId: ./shop/7ca204f2-7875-4b0d-8976-5a36c14b06e4)

response:
```
{
    "name": "myShopName",
    "shopId": "7ca204f2-7875-4b0d-8976-5a36c14b06e4",
    "products": {
        "cc262398-a0a3-47a5-b08d-273b5ea59544": {
            "name": "also a product",
            "lineItemId": "cc262398-a0a3-47a5-b08d-273b5ea59544",
            "centValue": 1001,
            "description": "testProduct description"
        },
        "2fe9dd1a-ce50-406f-93a2-ac9bb00b5023": {
            "name": "testProduct",
            "lineItemId": "2fe9dd1a-ce50-406f-93a2-ac9bb00b5023",
            "centValue": 1000,
            "description": "testProduct description"
        },
        "25636387-838e-43a6-913e-efcbc4e6e28a": {
            "name": "testProduct",
            "lineItemId": "25636387-838e-43a6-913e-efcbc4e6e28a",
            "centValue": 1000,
            "description": "testProduct description"
        }
    }
}
```

-------------------------------------------------------------------------------
### Get order:

endpoint: GET ./shop/{shopId}/order/{orderId}
(sample orderId: ./shop/7ca204f2-7875-4b0d-8976-5a36c14b06e4/order/62e51df9-fb95-410e-8609-05678e51a403)

response:
```
{
    "orderId": "62e51df9-fb95-410e-8609-05678e51a403",
    "cart": {
        "2fe9dd1a-ce50-406f-93a2-ac9bb00b5023": {
            "name": "testProduct",
            "lineItemId": "2fe9dd1a-ce50-406f-93a2-ac9bb00b5023",
            "centValue": 1000
        }
    }
}
```

-------------------------------------------------------------------------------
### Get order cost:

endpoint: GET ./shop/{shopId}/order/{orderId}/cost
(sample orderId: ./shop/7ca204f2-7875-4b0d-8976-5a36c14b06e4/order/62e51df9-fb95-410e-8609-05678e51a403/cost)

response:
```
{
    "centValue": 1000
}
```

-------------------------------------------------------------------------------
### Create order:

endpoint: POST ./shop/{shopId}/orderId

request:
```
{
	"shopId": "7ca204f2-7875-4b0d-8976-5a36c14b06e4"
}
```

response:
```
{
    "orderId": <String>
}
```

-------------------------------------------------------------------------------
### Create product:

endpoint: POST ./shop/{shopId}/product

request:
```
{
	"shopId": "7ca204f2-7875-4b0d-8976-5a36c14b06e4",
	"productName": "also a product",
	"centValue": 1001,
	"productDescription": "testProduct description"
}
```

response:
```
{
    "name": "also a product",
    "lineItemId": "cc262398-a0a3-47a5-b08d-273b5ea59544",
    "centValue": 1001,
    "description": "testProduct description"
}
```

-------------------------------------------------------------------------------
### Add product to order:

endpoint: POST ./order/product

request:
```
{
  "shopId": "7ca204f2-7875-4b0d-8976-5a36c14b06e4",
	"orderId": "62e51df9-fb95-410e-8609-05678e51a403",
	"productId": "2fe9dd1a-ce50-406f-93a2-ac9bb00b5023"
}
```

response:
(empty response)


# Limitations

Due to time restrictions, not all of the requested functionality of the challenge was implemented.
This would include anything to do with security, and some common functionality such as the ability
to delete entities or to have two of the same LineItem in one single order. However, because of the
way this project is setup, many of the missing functionality can be easily added without too much
effort
