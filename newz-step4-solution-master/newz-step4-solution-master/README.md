## NewzApp - Step4 

### Objective

    -   Using JWT token , protecting API calls of Mulitple microservices


#### In this case study NewzApp Step 4  , following Microservices to be build

    1)  Authentication Service -  For generating token

    2)  Use NewzStep3 Application -  Protect the end points for Add / Delete  using JWT token 

    3)  Use NewzStep2 Application - Protect the end points for Add / Delete using JWT Token



#### Authentication Microservice

Build the below end points

1) /register    :   Register new user , store in mysql

2) /login       :   To validate user and returns token



Class Userprofile

            Attributes

                * userid (primary key)

                * password 
        
                * confirmpassword


#### NewzStep2 Microservice

    -   Create Filter and protect the add/delete API calls

#### NewzStep3 Microservice

    -    Create Filter and protect the add/delete API calls

   
*** Release 1.0 ***

- Right click on the Assignment select Run As -> spring boot app to run your Assignment.

