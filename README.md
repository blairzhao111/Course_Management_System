#Course Management System Project

This repository contains source code and resources for my Course Management System Project.

* Project was built upon MVC pattern using partial Java EE stack.
* Use Servlets working as controller
* Use JSP associating modern JSP EL and JSTL core as View
* Use EclipseLink as ORM
* Use MySQL as Database 
* Deploy on Apache Tomcart Server

## Features  

### For general user:

* Register into System by different role: student, instructor, admin.
* Log in by providing registered email and associating password.
* Create personal profile and modify profile anytime when user is loged in.
* Account recovery and password resetting.
  
### For student user:

* Additional to all functionalities provided to general user, student user can:
* Use filter to search certain courses from all available courses.
* Select and enroll into desired courses.
* Drop already enrolled courses.
* Download currently enrollment as spreadsheet file to local.

### For instructor user:

* Additional to all functionalities provided to general user, student user can:
* Add new courses to the course set and post them.
* Download student information as spreadsheet file to local.

## Todo
  
1. Refactor source code and try to migrate project working with Spring MVC and Maven.
2. Add new features.  
3. Add extensive unit tests.

## To Run Application
To run the application, you can deploy courseApp.war file in dist directory into any Servlets/JSP container, you may need to do some configurations based on the server you are using, also change Persistence.xml file to configure Database connection, if you are using a different database management system rather than MySQL, you may need to include its JDBC driver jar into Library.

## License  

    The MIT License (MIT)
      
    Copyright (c) 2016 Junwei Zhao.
      
    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:
      
    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.
      
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
