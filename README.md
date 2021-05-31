# ESnack
Demo SpringBoot and MySql RESTFul Application
## Requirements
- git
- docker
- docker-compose
## Deployment
### Example 1
**docker-compose up**
### Example 2
**MYSQL_EXTERNAL_PORT="*3306*" BACKEND_EXTERNAL_PORT="*8080*" docker-compose up**

## Usage
### Base address Example
[http://*localhost*:8080/eSnack]
### Add new category Example
**Post method**

[http://*localhost*:8080/eSnack/category]

With raw JSON body

{

    "name": "Chocolate bar",
    "price": 32.75,
    "number": 12
}
### Add edit current category Example
Add Items For Sale

**Patch method**

[http://*localhost*:8080/eSnack/category/Chocolate bar/add/3]

### Get all current categories (list them) Example

**Get method**

[http://*localhost*:8080/eSnack/category]

### Make all categories with zero amount unavailable for sale Example

**Delete method**

[http://*localhost*:8080/eSnack/category/clear]

### Purchase one item of some category Example

**Post method**

[http://*localhost*:8080/eSnack/purchase/Chocolate bar/2021-05-25]

### Get day report Example

**Get method**

[http://*localhost*:8080/eSnack/purchase/reportbyday/2021-05-25]

### Get month report Example

**Get method**

[http://*localhost*:8080/eSnack/purchase/reportbymonth/2021-05]

### To check all through you can use Postman and do next sequence
**1 Post method** [http://*localhost*:8080/eSnack/category]

With raw JSON body

{

    "name": "Chocolate bar",
    "price": 32.75,
    "number": 12
}

With response

{

    "status": "success",
    "message": "Chocolate bar 32.75 12"
}

**2 Post method** [http://*localhost*:8080/eSnack/category]

With raw JSON body

{

    "name": "Donut",
    "price": 29.50
}

With response

{

    "status": "success",
    "message": "Donut 29.50 0"
}

**3 Post method** [http://*localhost*:8080/eSnack/category]

With raw JSON body

{

    "name": "Cracker",
    "price": 18.00,
    "number": 2
}

With response

{

    "status": "success",
    "message": "Cracker 18.00 2"
}

**4 Post method** [http://*localhost*:8080/eSnack/purchase/Cracker/2021-04-21]

With response

{

    "status": "success",
    "message": "2021-04-21 \n Cracker 18.00"
}

**5 Patch method** [http://*localhost*:8080/eSnack/category/Donut/add/3]

With response

{

    "status": "success",
    "message": "Donut 29.50 3"
}

**6 Post method** [http://*localhost*:8080/eSnack/purchase/Chocolate bar/2021-04-22]

With response

{

    "status": "success",
    "message": "2021-04-22 \n Chocolate bar 32.75"
}

**7 Post method** [http://*localhost*:8080/eSnack/purchase/Cracker/2021-04-24]

With response

{

    "status": "success",
    "message": "2021-04-24 \n Cracker 18.00"
}

**8 Post method** [http://*localhost*:8080/eSnack/purchase/Donut/2021-04-25]

With response

{

    "status": "success",
    "message": "2021-04-25 \n Donut 29.50"
}

**9 Get method** [http://*localhost*:8080/eSnack/category]

With response

{

    [

        {
        "name": "Chocolate bar",
        "price": 32.75,
        "number": 11
        },
        {
        "name": "Donut",
        "price": 29.50,
        "number": 2
        },
        {
        "name": "Cracker",
        "price": 18.00,
        "number": 0
        }
    
    ] 
}

**10 Delete method** [http://*localhost*:8080/eSnack/category/clear]

With response

{

    "status": "success",
    "data": [
        {
            "name": "Cracker",
            "price": 18.00
        }
    ]
}

**11 Post method** [http://*localhost*:8080/eSnack/purchase/Chocolate bar/2021-04-28]

With response

{

    "status": "success",
    "message": "2021-04-28 \n Chocolate bar 32.75"
}

**12 Patch method** [http://*localhost*:8080/eSnack/category/Donut/add/10]

With response

{

    "status": "success",
    "message": "Donut 29.50 12"
}

**13 Get method** [http://*localhost*:8080/eSnack/category]

With response

{

    [

         {
         "name": "Donut",
         "price": 29.50,
         "number": 12
         },
        {
        "name": "Chocolate bar",
        "price": 32.75,
        "number": 10
        }
    
    ] 
}

**14 Get method** [http://*localhost*:8080/eSnack/purchase/reportbymonth/2021-04]

With response

{

    "status": "success",
    "message": "Chocolate bar 65.50 2\nDonut 29.50 1\nCracker 36.00 2\nTotal 131.00",
    "data": {
        "Chocolate bar": {
            "categoryName": "Chocolate bar",
            "totalPrice": 65.50,
            "quantity": 2
        },
        "Donut": {
            "categoryName": "Donut",
            "totalPrice": 29.50,
            "quantity": 1
        },
        "Cracker": {
            "categoryName": "Cracker",
            "totalPrice": 36.00,
            "quantity": 2
        }
    }
    
}

**15 Get method** [http://*localhost*:8080/eSnack/purchase/reportbyday/2021-04-25]

With response

{

    "status": "success",
    "message": "Chocolate bar 32.75 1\nDonut 29.50 1\nTotal 62.25",
    "data": {
        "Chocolate bar": {
            "categoryName": "Chocolate bar",
            "totalPrice": 32.75,
            "quantity": 1
        },
        "Donut": {
            "categoryName": "Donut",
            "totalPrice": 29.50,
            "quantity": 1
        }
    }
    
}


## Stop and Clean
1. Ctrl+C
2. **docker-compose down**
3. **sudo docker volume prune**
4. **sudo docker system prune**