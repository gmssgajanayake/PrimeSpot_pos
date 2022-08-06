
# PrimeSpot API 

A brief description of what this project does.




## Technologies

**Client:** Angular - https://angular.io/, SCSS , Bootstrap - https://getbootstrap.com/

**Server:** Spring 2.7.2 - https://spring.io/

**Database Connection:** Hibernate - 
https://hibernate.org/


## API Reference

### **Customer**

#### Save a new customer

```http
  POST api/v1/customer
```

##### Request Body 
    "name":"Sakuja Shamal Gajanayake",
    "email":"gmsakujashamalgajanayake@gmail.com",
    "password":"12345",
    "address":"Colombo, Sri Lanka",
    "phoneNumber","+94717978125"

#### Update a customer

```http
  PUT api/v1/customer?id=ZZTJ-C-47703726
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch,  **Example** id=ZZTJ-C-47703726|


##### Request Body 
    "name":"Sakuja Shamal Gajanayake",
    "password":"12345",
    "address":"Colombo, Sri Lanka",
    "phoneNumber","+94717978125"


#### Get customer

```http
  GET api/v1/customer?email=sakuja@gmail.com&password=1234
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Required**. sakuja@gmail.com|
| `password`      | `string` | **Required**.1234|

#### Delete customer

```http
  Delete api/v1/customer?id=EDOH-C-59085235
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**.  EDOH-C-59085235|

### **Employer**

#### Save a new employer

```http
  POST api/v1/employer
```

##### Request Body 
    "name":"Sakuja Shamal Gajanayake",
    "email":"gmsakujashamalgajanayake@gmail.com",
    "password":"12345",
    "address":"Colombo, Sri Lanka",
    "salary":"100000",
    "phoneNumber","+94717978125"

#### Update an employee

```http
  PUT api/v1/employer?id=ZZTJ-C-47703726
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch,  **Example** id=ZZTJ-C-47703726|


##### Request Body 
    "name":"Sakuja Shamal Gajanayake",
    "password":"12345",
    "address":"Colombo, Sri Lanka",
    "salary":"100000",
    "phoneNumber","+94717978125"


#### Get employer

```http
  GET api/v1/employer?email=sakuja@gmail.com&password=1234
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Required**. sakuja@gmail.com|
| `password`      | `string` | **Required**.1234|

#### Delete employer

```http
  Delete api/v1/employer?id=EDOH-C-59085235
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**.  EDOH-C-59085235|

### **Item**

#### Save a new item

```http
  POST api/v1/item
```

##### Request Body 
    "name":"Sakuja Shamal Gajanayake",
    "email":"gmsakujashamalgajanayake@gmail.com",
    "password":"12345",
    "address":"Colombo, Sri Lanka",
    "salary":"100000",
    "phoneNumber","+94717978125"

#### Update an item

```http
  PUT api/v1/item?id=ZZTJ-C-47703726
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch,  **Example** id=ZZTJ-C-47703726|


##### Request Body 
    "name":"Women Wallet",
    "description":"Black/blue/pink Short Female Purse Fashion Credit Card Holder Wallet Case PU Leather Coin Purse 2022 Money Card Bag",
    "imagePath":"assets/image/img.jpg",
    "mainCategory":"Women",
    "subCategory","Bags",
    "quantity","48",
    "price","435"


#### Get all items

```http
  GET api/v1/employer
```


#### Delete employer

```http
  Delete api/v1/employer?id=EDOH-C-59085235
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**.  EDOH-C-59085235|

### **Placed Orders**

#### Save a new order

```http
  POST api/v1/order
```

##### Request Body 
    "customerId":"ZZTJ-C-47703726",
    "itemId":"ZZTJ-I-47703726",
    "date":"2022/08/24",
    "shippingAddress":"Colombo, Sri Lanka",
    "shippingStatus":"pending",
    "unitPrice":"400",
    "quantity":"1",
    "tax":"20",
    "shippingCost","50",
    "total":"470"

#### Update an order

```http
  PUT api/v1/order?id=ZZTJ-C-47703726
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch,  **Example** id=ZZTJ-C-47703726|


##### Request Body 
    "customerId":"ZZTJ-C-47703726",
    "itemId":"ZZTJ-I-47703726",
    "date":"2022/08/24",
    "shippingAddress":"Colombo, Sri Lanka",
    "shippingStatus":"pending",
    "unitPrice":"400",
    "quantity":"1",
    "tax":"20",
    "shippingCost","50",
    "total":"470"


#### Get all orders

```http
  GET api/v1/order?email=sakuja@gmail.com&password=1234
```

#### Delete order

```http
  Delete api/v1/order?id=EDOH-C-59085235
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**.  EDOH-C-59085235|


# Hi, I'm Sakuja Shamal! 👋


## 🚀 About Me
I'm a full stack developer...
https://github.com/gmssgajanayake/PrimeSpot_pos

## Other Common Github Profile Sections
👩‍💻 I'm currently working on...

🧠 I'm currently learning...

👯‍♀️ I'm looking to collaborate on...

🤔 I'm looking for help with...

💬 Ask me about...

📫 How to reach me...

😄 Pronouns...

⚡️ Fun fact...

## Feedback

If you have any feedback, please reach out to us at sakuja1shamal@gmail.com

--------------------------------------------------------------------------------------------

