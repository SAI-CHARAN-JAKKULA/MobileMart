<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">


<link rel="stylesheet" type="text/css" href="cart.css">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
 
 <nav class="navbar navbar-default">
    <div class="container-fluid">

		      <div class="navbar-header">
		      <a class="navbar-brand" href="home.html">MobileMart</a>
		      </div>

    
	        <ul class="nav navbar-nav">
	         <li ><a href="home.html">HOME<span class="sr-only">(current)</span></a></li>
	         	         <li><a href="profile.html">PROFILE</a></li>
	         
	        </ul>
     
	        <ul class="nav navbar-nav navbar-right">
	         <li ><a href="login.html">Login</a></li>
	         <li><a href="signup.html">Signup</a></li>
	         <li class="active"><a href="#">CART<i class="fas fa-shopping-cart"></i> </a></li>
	        </ul>
	       
	    
    
  </div><!-- /.container-fluid -->
</nav>


  <sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
     url="jdbc:postgresql://localhost:5432/Charan"
     user="postgres"  password="charan"/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from cart;
</sql:query>
 <%! int i=0; %>
 <%!   
int cube(int n){  
return n*58999;  
}  
%>  
<br>
<%i=0; %>
<c:forEach var="row" items="${result.rows}">
<% i++; %>
</c:forEach>
<h1 style="text-align: center;"><%=i %> Items in your cart</h1>
<br>
<div class="container"><table class="table table-striped ">
  <tr >
    <th style="text-align: center;">ITEM DETAILS</th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>

    <th style="text-align: center;`">PRICE</th>
    <th></th>
  </tr>

<c:forEach var="row" items="${result.rows}">

<tr style="text-align: center;">
    <td><img src="r_img4.jpg"> <span class="h4">OnePlus 7T<span class="small"><br>(Frosted Silver, 8GB RAM, Fluid AMOLED Display, 128GB Storage, 3800mAH Battery)</span></span>
</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>

    <td><i class="fas fa-rupee-sign"></i><span style="color:blue;"> 58,999</span></td>
    <td><form action="remove"><button type="submit"  class="btn btn-success btn-sm "> REMOVE <span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 
</button></form></td>
  
  </tr>
</c:forEach>
  
   <tr >
    <th style="text-align: center;padding-top: 20px;font-size: 130%;">TOTAL AMOUNT</th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>
    <th></th>

   <th style="text-align: center;padding-top: 20px;font-size: 130%;"><i class="fas fa-rupee-sign"></i><span style="color:blue;"> <%=cube(i) %></span></th>
    <th></th>
  </tr>
</table>
<div class="text-center" style="padding-top: 40px;padding-bottom: 50px;">
<a href="viewPage.html"><button class="btn  btn-lg">BACK</button></a>

<a href="details.html"><button class="btn btn-success btn-lg">Proceed to CheckOut</button></a>
</div>
</div>
<!-- Footer -->
<footer class="page-footer font-small blue pt-4">

  <!-- Footer Links -->
  <div class="container-fluid text-center text-md-left">

    <!-- Grid row -->
    <div class="row">

      <!-- Grid column -->
      <div class="col-md-6 mt-md-0 mt-3">

        <!-- Content -->
        <h5 class="text-uppercase">Mobile Mart</h5>
        <p>Here you can find and order mobiles</p>

      </div>
      <!-- Grid column -->

      <hr class="clearfix w-100 d-md-none pb-3">

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 class="text-uppercase">GOTO</h5>

        <ul class="list-unstyled">
          <li>
            <a href="home.html">home</a>
          </li>
          <li>
            <a href="cart.html">cart</a>
          </li>
         
        </ul>

      </div>
      <!-- Grid column -->

      <!-- Grid column -->
      <div class="col-md-3 mb-md-0 mb-3">

        <!-- Links -->
        <h5 class="text-uppercase">GOTO</h5>

        <ul class="list-unstyled">
          <li>
            <a href="signup.html">signup</a>
          </li>
          <li>
            <a href="login.html">login</a>
          </li>
          
        </ul>

      </div>
      <!-- Grid column -->

    </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->

  <!-- Copyright -->
  <div class="footer-copyright text-center py-3">© 2020 Copyright:
    mobilemart.com
  </div>
  <!-- Copyright -->

</footer>
<!-- Footer -->

 
</body>
</html>