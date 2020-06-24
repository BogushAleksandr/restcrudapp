# REST app
"Installation"

1) git clone https://github.com/BogushAleksandr/restcrudapp.git && cd restcrudapp
2) mvn clean test && mvn spring-boot:run


                                    "Tusk"
"Implement SPA (https://i-msdn.sec.s-msft.com/dynimg/IC690875.png) with authentication
page and one more page + RestAPI on backend for CRUD operations on one table."

1) DB:
     tblEmployees:
                    empID (identity field)
                    empName
                    empActive
                    emp_dpID – foreign key to tblDepartments
     tblDepartments:
                    dpID
                    dpName
2) it should have one “Search” feature
3) And it should search ONLY with “Start with” criteria! (not include!).
   !!!NOTE!!!
   UI beauty is NOT considered at all. So, html/css doesn’t matter!
   Conditions:
   1. Table theoretically can have more fields and a lot of data.
   2. So, paging is essential part of this test task.
   3. Please use MySQL for task.
   4. Don’t use Hibernate
   
   Documentation  on link http://localhost:8080/DocRestApi/swagger-ui.html after ran application.



