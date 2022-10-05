## Newz Assignment

### Description


Representational State Transfer (REST) is an architectural style that specifies constraints. 
In the REST architectural style, data and functionality are considered resources and are accessed using Uniform Resource Identifiers (URIs), typically links on the Web.

Resources are manipulated using a fixed set of four create, read, update, delete operations: PUT, GET, POST, and DELETE. 
 - POST creates a new resource, which can be then deleted by using DELETE. 
 - GET retrieves the current state of a resource in some representation. 
 - PUT transfers a new state onto a resource. 
 - DELETE - delete a resource

### Problem Statement

In this Case study: Newz Step 2, we will create a RESTful application using  Spring Boot application with JPA Repository, which uses MYSQL for persistence


We will perform CRUD operations in news model. Also, we will check the performance of the operations with the help of Postman API.

### Solution Step

        Step 1: Configure Postman in your Google Chrome
        Step 2: Use URI's mentioned in the controller to check all the expected operations using Postman.

### Following are the broad tasks:

#### NEWS model

Task

 -   Create a news 

 -   Update the existing news

 -   Retrieve a news based on newsid
 
 -   Delete the news using newsid
 
 -   Get the list of all news
 

/*
 * The class "News" will be acting as the data model for the News Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 
 */

Sample: 


public class News {

	/*
	 * This class should have below fields
	 * (newsId,title,author,description, publishedYear, content, url). 
	 *  
	 * field newsId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. 
	 
	 */
	
	
}


### Project structure

The folders and files you see in this repositories is how it is expected to be in projects
    Project
  
    ├─src/main/java
  
            |
  
            ├── com.stackroute.newz 
            
            |        └── NewzApplication.java

            ├── com.stackroute.newz.controller
            
            |        └── NewsController.java           
            
            ├── com.stackroute.newz.repository
         
            |        └── NewsRepository.java                  
         
            ├── com.stackroute.newz.util.exception
         
                   └──NewsAlreadyExistsException.java        
         
            ├── com.stackroute.newz.model
         
            |        └── News.java                     
         
            ├── com.stackroute.newz.service
         
            |        └──NewsService            
         
            |        └──NewsServiceImpl         
    
    ├─src/main/resources
            
            |        └── application.properties    
    

            ├── pom.xml                                     
            └── readme.md                                 



### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment  select Run As -> Java Application to run your Assignment.

-  Provide maintainer rights to your mentor for further evaluation. Assignment will be manually reviewed


