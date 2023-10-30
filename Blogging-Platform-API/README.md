# Blogging-Platform-API
This is an API for a Blogging Platform that allows users to create posts, follow other users, comment on posts, and perform various other actions related to blogging. It is built using the following frameworks and languages:

## Frameworks and Language Used
- Spring Framework (including Spring Boot, Spring MVC, Spring Data JPA)
- Java
- Hibernate
- MySQL
- Swagger
- AWS

## Data Flow
The data flow in the Blogging Platform API is organized into the following components:
- Controller
- Services
- Repository
- Database Design

## Controller
The Controller layer handles the incoming HTTP requests and manages the routing of these requests to the appropriate service methods. It provides the necessary endpoints for interacting with the API. Some of the key functionalities implemented in the controllers include:
- User registration and authentication
- Post creation and retrieval
- Category creation and deletion
- Comment creation and retrieval
## Endpoints
### User Endpoints:
![User_Controller](https://github.com/mukeshlomror/BloggingPlatformAPI/assets/54076057/69b5189e-c014-4618-bd54-1e9f605c8ba8)

```
- **POST /api/users/create -** Create a new user.
- **POST /api/users/register -** User can register 
- **GET  /api/users/login -** User can login with email and password.
- **GET /api/users/getOne/{id} -** Get user details by ID.
- **GET /api/users/getAll -** Get all user details.
- **PUT /api/users/update/{id}/{name}/{about} -** Update user details by userId.
- **DELETE /api/users/delete/{id} -** Delete user by Username.
```

### Post Endpoints:
![Post_Controller](https://github.com/mukeshlomror/BloggingPlatformAPI/assets/54076057/31a2684c-80b6-4971-8c37-d576998ee12c)

```
- **POST /api/posts/create -** Create a new post.
- **GET /api/posts/getOne/{id} -** Get post details by ID.
- **GET /api/posts/getAll -**Get all posts
- **GET /api/posts/pagination -** User can get post based on pagination.
- **GET /api/posts/getByUser/{id} -** User can get posts based on user Id.
- **GET /api/posts/getByCategory/{id} -** User can get posts based on category Id.
- **GET /api/posts/search/{keyword -** User can search posts based on some keywords.
- **PUT /api/posts/update/{id} -** Update post details by ID.
- **DELETE /api/posts/delete/{id} -** Delete post by ID.
```

### Category Endpoints:
![Category_Controller](https://github.com/mukeshlomror/BloggingPlatformAPI/assets/54076057/27b64262-eddc-41e3-a87b-0af57b5f6c15)

```
- **POST /api/categories/create -** Create an Category.
- **GET /api/categories/getOne/{id} -** Get Categories based on Id.
- **GET /api/categories/getAll -** Get all Categories.
- **PUT /api/categories/update/{id} -** Update categories based on Id.
- **DELETE /api/categories/delete/{id} -** Delete a category based on Id.
```

### Comment Endpoints:
![Comment_Controller](https://github.com/mukeshlomror/BloggingPlatformAPI/assets/54076057/76186a07-7899-4036-a53c-4afd90251a6e)

```
- **POST /api/comments/create/post/{postId} -** Add a comment to a post.
- **DELETE /api/comments/delete/{commentId} -** delete comments of a post by commentId
```

## Services
The Services layer contains the business logic of the application. It acts as an intermediary between the controllers and the repositories, implementing the necessary operations and transformations on the data. The services handle operations such as:
```
- User management (creation, retrieval, update, deletion)
- Post management (creation, retrieval, update)
- Category management (creation,deletion,updation and retrieval)
- Comment management (adding comments, retrieving comments, deletion)
```

## Repository
The Repository layer is responsible for interacting with the underlying database. It provides an abstraction over the database operations, allowing the services to query and manipulate the data. Some of the key responsibilities of the repositories include:
```
- User repository: Provides methods for retrieving and storing user-related data.
- Post repository: Offers methods for retrieving and storing post-related data.
- Category repository: Handles the storage and retrieval of category relationship data.
- Comment repository: Manages the storage and retrieval of comment data.
```

## Database Design and Schemas:
![Blog_Schemas](https://github.com/mukeshlomror/BloggingPlatformAPI/assets/54076057/985f4d1c-79ac-4fde-89f3-e3250f515242)

The database design for the Blogging Platform API follows the object-relational mapping (ORM) approach provided by Spring Data JPA. The entities (such as User, Post, Follow, Comment) are mapped to database tables, and the relationships between them are defined using annotations. The data is persisted in a relational database, such as MySQL.

## Data Structures Used
```
- Lists: Used to store collections of objects, such as lists of posts, users, and categories.
- Sets: Utilized for storing unique values, such as comments for a post.
- Optional: Used in methods returning optional values, such as finding a user or post by its identifier.
```

## Project Summary
The Blogger Web Application is a full-stack web application that allows users to create, read, update, and delete blog posts and comments. It also allows users to follow other users and view their blog posts. The application uses Spring Boot, Spring MVC, and Spring Data JPA to implement the backend, and MySQL for the database. Swagger is used for API documentation.

## Deployment
# The application has been deployed on an AWS EC2 instance, and can be accessed using the following URL :+: [Deployment-Link](http://13.127.8.252:8080/swagger-ui/index.html)

