# anz-wholesale-coding-challenge
This project is created for the anz coding challenge.  

### Technologies
- Java 8
- Spring Boot 2.1.7
- h2 database
- Maven 3.5

### Design
- This project is a REST service based on Spring Boot.
- H2 memory database is used in this demo project to simplify the test
- Two db tables are created, one is for Account, another one is for Transaction, the two tables can be joint by account_number field
- Two APIs are designed, one is for AccountList, another one is for TransactionList
- User authentication is not considered in this demo project, the account list should be grouped by user_id
 
### Assumption
- The format of Account Number field is different in the two screenshots,
to be simple, the data type of Account Number is Integer
- In this demo project, Balance or Amount is represented by Double, this may lead to a precision issue in a real transaction system
- CurrencyEnum only includes SGD and AUD, there should be more type in a real transaction system
- All datetime should be saved in UTC format in the database, and it will be converted to local time by frontend according to the client system timezone

### API Reference
/account  
/transaction/{accountNumber}

### How to run
The entry of this SpringBoot project is AnzwholesalecodingchallengeApplication.java main() method.  
You can run it in IDE.  
Or run maven command to package the project to jar and then use java command to run .jar package.
```
mvn clean
mvn package
java -jar /xxx/anzwholesalecodingchallenge-0.0.1-SNAPSHOT.jar.jar
``` 


### How to test
Copy the urls below and paste it into the address bar of your browser.  
Or test in Postman.  
Get more accountNumber from /account API  
http://localhost:8080/account  
http://localhost:8080/transaction/585309209

