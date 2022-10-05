### SpringBoot Microservices Hackathon
### Estimated Time : 3 hrs

### Tools and Technologies:

    - Spring  Boot
    - Spring data JPA
    - MySQL
    - Swagger


In this Assessment, you will implement a microservice to manage the insurance details of Cab drivers based on the data received.

Need to build below microservice, using  Spring Boot and JPA, persistence using MySQL  . Document and test this API using Swagger.

###  Microservice1 - REST API

     Group id       : com.cgi 
     Artifact       : insurance

     Database name  : DRIVERDB


### A Driver model will have the following attributes:
    
        • driverid        : int - Primarkey
        • firstname       : string
        • telephonenumber : int 
        • address         : string
        • city            : string
        • enginesize      : string 
        • quoteamount     : long

    

#### Create a REST controller with the following core features (endpoints)

        • Post new driver details 
        • Get all driver details 
        • Modify the given driver detail
        • Delete details of a driver for the given driverid 
        • Find a driver using his telephonenumber

##### Ensure the following

        1.  DriverIdAlreadyExistException should be raised for duplicate driver ids while Posting the driver data
        2.	While performing Delete/Modify transactions, DriverIdNotFoundException to be raised, if the given driverid  
            is not present

#### Note:

    • Ensure that you have used clean code and standard project structure. 
    • Build all Classes using the best practices
    • Use Swagger UI  to test all the  endpoints. 
    • Push your code to gitlab and add mentor to your repo for review

