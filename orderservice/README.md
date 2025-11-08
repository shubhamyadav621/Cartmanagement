
Project Title:

Cart Management System (Microservices Project)

Team Members:

Shubham Yadav - 22CSU444

Deepanshu Yadav - 22CSU376

Tanishq - 22CSU451

What all services/functionality are working without errors:

Product Service – working properly

Cart Service – working (basic add endpoint)

Order Service – working fully

Config Server – working

API Gateway – working

Who coded which service:

Shubham Yadav (22CSU444) → Order Service

Tanishq (22CSU451) → Cart Service (basic add endpoint)

Deepanshu Yadav (22CSU376) → Product Service

Common Code:

Config Server → coded by Deepanshu Yadav (22CSU376)

API Gateway → coded by Shubham Yadav (22CSU444)

Working Endpoints and Example Calls
1. Order Service (Shubham Yadav)

Base URL: http://localhost:8084/orders

Endpoint	Method	Description	Example
/orders/all	GET	Get all orders	GET http://localhost:8084/orders/all
/orders/{id}	GET	Get order by ID	GET http://localhost:8084/orders/1
/orders/add	POST	Add new order	POST http://localhost:8084/orders/add
Body: { "orderId": 1, "user": "Shubham", "amount": 1200 }
/orders/delete/{id}	DELETE	Delete order by ID	DELETE http://localhost:8084/orders/delete/1
/orders/products	GET	Get all products (via Product Service)	GET http://localhost:8084/orders/products
/orders/nextpage?page=0&size=5	GET	Get paginated orders	GET http://localhost:8084/orders/nextpage?page=0&size=5 
2. Cart Service (Tanishq)

Base URL: http://localhost:8083/cart

Endpoint	Method	Description	Example
/cart/add	POST	Add item to cart	POST http://localhost:8083/cart/add
Body: { "productId": 1, "quantity": 2 }

3.Product Service (Deepanshu Yadav)

Base URL: http://localhost:8082/products

Endpoint	Method	Description	Example
/products	GET	Get all products	GET http://localhost:8082/products
/products/{id}	GET	Get product by ID	GET http://localhost:8082/products/1
/products	POST	Add a new product	POST http://localhost:8082/products
Body: { "name": "Laptop", "price": 70000 }
/products/{id}	PUT	Update product	PUT http://localhost:8082/products/1
Body: { "name": "Updated Laptop", "price": 65000 }
/products/{id}	DELETE	Delete product	DELETE http://localhost:8082/products/1

4. API Gateway (Shubham Yadav)

Base URL: http://localhost:8080/

Routes:

/products/** → Product Service

/cart/** → Cart Service

/orders/** → Order Service

5. Config Server (Deepanshu Yadav)

Base URL: http://localhost:8888/
Used for centralized configuration of all services.