---
title: API Reference

toc_footers:
  - <a href='https://github.com/lord/slate'>Documentation Powered by Slate</a>

includes:
  - errors

search: true
---

# Introduction

Welcome to my quick implementation of Shopify's 2019W developer challenge!


# Authentication

(... guess what I still need to implement ...) 


# Shop endpoints

## Get shop

This endpoint retrieves a shop

### HTTP Request

`GET https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/<shopId>`

### URL Parameters

Parameter | Description
--------- | -----------
shop | The UUID of the shop you are looking for

> Returns JSON structured like this:

```json
{
    "name": "myShopName",
    "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33",
    "products": {
        "2e8f4d63-1609-4352-bde4-8e9e6b091656": {
            "productId": "2e8f4d63-1609-4352-bde4-8e9e6b091656",
            "name": "banana",
            "description": "its yellow!",
            "centValue": 70
        },
        "90170e0e-9454-4869-a18c-e15dc555e063": {
            "productId": "90170e0e-9454-4869-a18c-e15dc555e063",
            "name": "apple",
            "description": "an apple",
            "centValue": 200
        }
    }
}

```


## Create shop

This endpoint allows you to create a shop

### HTTP requests

`POST https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/`

### BODY parameters

Parameter | Default | Description
--------- | ------- | -----------
shopName | required | Name of your new shop

> Sample JSON request body

```json
{
	"shopName": "myShopName"
}
```

> Returns JSON structured like this:  

```json
{
    "name": "myShopName",
    "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33"
}
```


## Delete shop

This endpoint allows you to delete a shop

### HTTP requests

`DELETE https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/<shopId>`

### URL Parameters

Parameter | Description
--------- | -----------
shop | The UUID of the shop you want to delete

> Returns an empty body


## Add product

This endpoint allows you to add a product to a shop

### HTTP request

`POST https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/<shopId>/product`

### URL Parameters

Parameter | Description
--------- | -----------
shopId | The UUID of the shop you want to add a product

### BODY parameters

Parameter | Default | Description
--------- | ------- | -----------
productName | required | Name of your new product
centValue | required | Cost of your product in cents
productDescription | required | Description of your product

> Sample JSON request body

```json
{
	"productName": "banana",
	"centValue": 70,
	"productDescription": "its yellow!"
}
```

> Returns JSON structured like this:

```json
{
    "productId": "2e8f4d63-1609-4352-bde4-8e9e6b091656",
    "name": "banana",
    "description": "its yellow!",
    "centValue": 70
}
```


## Delete product

This endpoint allows you to delete a product from a shop

### HTTP request

`DELETE https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/<shopId>/product/<productId>`

### URL Parameters

Parameter | Description
--------- | -----------
shopId | The UUID of the shop you want to delete a product
productId | The UUID of the product you want to delete

> Returns an empty body


## Get orders

This endpoint allows you to get all the orders of a shop

### HTTP request

`GET https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/shop/<shopId>/orders`

### URL Parameters

Parameter | Description
--------- | -----------
shop | The UUID of the shop you want the orders of

> Returns JSON structured like this:

```json
{
    "items": [
        {
            "orderId": "35098375-6e4e-4236-8141-b94fa7193690",
            "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33"
        },
        {
            "orderId": "4fc543fc-44ed-421b-b168-410503e6abf4",
            "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33",
            "cart": {
                "2e8f4d63-1609-4352-bde4-8e9e6b091656": {
                    "productId": "2e8f4d63-1609-4352-bde4-8e9e6b091656",
                    "name": "banana",
                    "description": "its yellow!",
                    "centValue": 70,
                    "quantity": 2
                },
                "90170e0e-9454-4869-a18c-e15dc555e063": {
                    "productId": "90170e0e-9454-4869-a18c-e15dc555e063",
                    "name": "apple",
                    "description": "an apple",
                    "centValue": 200,
                    "quantity": 1
                }
            }
        }
    ]
}
```


# Order endpoints



## Get order

This endpoint allows you to get a specific order

### HTTP request

`GET https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/<orderId>`

### URL Parameters

Parameter | Description
--------- | -----------
orderId | The UUID of the order you want

> Returns JSON structured like this:

```json
{
    "orderId": "4fc543fc-44ed-421b-b168-410503e6abf4",
    "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33",
    "cart": {
        "2e8f4d63-1609-4352-bde4-8e9e6b091656": {
            "productId": "2e8f4d63-1609-4352-bde4-8e9e6b091656",
            "name": "banana",
            "description": "its yellow!",
            "centValue": 70,
            "quantity": 2
        },
        "90170e0e-9454-4869-a18c-e15dc555e063": {
            "productId": "90170e0e-9454-4869-a18c-e15dc555e063",
            "name": "apple",
            "description": "an apple",
            "centValue": 200,
            "quantity": 1
        }
    }
}
```


## Create order

This endpoints allow you to create a new order

### HTTP Request

`POST https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/`

### BODY Parameters

Parameter | Default | Description
--------- | ------- | -----------
shopId | required | The UUID of the shop where you want to create a new order

> Sample JSON request body

```json
{
	"shopId": "9073c13a-38dd-475b-9d37-568a6e514c33"
}
```

> Returns JSON structured like this:

```json
{
    "orderId": "4fc543fc-44ed-421b-b168-410503e6abf4",
    "shopId": "9073c13a-38dd-475b-9d37-568a6e514c33"
}
```


## Delete order

This endpoint allows you to delete an order

### HTTP Request

`DELETE https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/<orderId>`

### URL Parameters

Parameter | Description
--------- | -----------
orderId | The UUID of the order you want to delete


> Returns an empty body



## Add product to an order

This endpoint allows you to add a product to an order

### HTTP Request

`DELETE https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/<orderId>/product`

### URL Parameters

Parameter | Description
--------- | -----------
orderId | The UUID of the order you want to add a product

### BODY parameters

Parameter | Default | Description
--------- | ------- | -----------
productId | required | The UUID of the product you want to add to the order

> Sample JSON request body

```json
{
	"productId": "90170e0e-9454-4869-a18c-e15dc555e063"
}
```

> Returns an empty body


## Delete a product from an order

This endpoint allows you to remove an product from an order

### HTTP Request

`DELETE https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/<orderId>/product/<productId>`

### URL Parameters

Parameter | Description
--------- | -----------
orderId | The UUID of the order you want to remove the product
productId | The UUID of the product you want to remove from the order

> Returns an empty body


## Get total

This endpoint allows you to get the total cost of an order

### HTTP Request
`GET https://jeffyang-shopifychallenge2018.appspot.com/_ah/api/order/<orderId>/total`


### URL Parameters

Parameter | Description
--------- | -----------
orderId | The UUID of the order you want the total

> Returns JSON structured like this:

```json
{
    "centValue": 270
}
```
