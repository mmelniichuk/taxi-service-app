### Table of contents
~~~~
1.About The Project
2.Built With
3.Getting Started
4.Project improvement
~~~~

#### 1.About The Project
3-tier architecture WEB-project with Database connection.
~~~~
- Controller-layer: processing requests from the user and generating a response
- Service-layer: business logic of taxi service work, authentication
- DAO-layer: realization of CRUD-methods, custom methods
~~~~

***Only authorized user can can make requests. Driver behaves as User.
To Register pass name, license number, login and password.
Then to login.
Use WEB-app freely.
You can see all possible actions on the [index page]



#### 2.Built With
~~~~
- Maven
- MySQL
- TomCat
~~~~
Technologies used: 
~~~~
- JDBC
- WEB 
- Servlets
- Filter
- Logger
- HTML/CSS  
- Dependency Injection
- S.O.L.I.D
- OOP principles 
~~~~

#### 3.Getting Started
###Installation
~~~~
1. Clone the repo
2. Open scr/main/java/jdbc/util/ConnectionUtil and enter all necessary data
3. Run script from the resources/init_db.sql file in the MySQLWorkbench.
4. Build project use command: mvn compile
5. Run Tomcat configuration
~~~~

#### 4.Project improvement
1. Write tests for project








[index page]: http://localhost:8080/index
