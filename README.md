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
## Stop and Clean
1. Ctrl+C
2. **docker-compose down**
3. **sudo docker volume prune**
4. **sudo docker system prune**