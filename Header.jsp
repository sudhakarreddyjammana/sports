<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Sport World</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
 <style>
img {
    max-width: 100%;
    height: auto;
}
</style>
</head>
<body>

<div>

<div class="col-md-12">
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Home">SPORTS WORLD</a>
		</div>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="Home">Home</a></li>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Products <span
					class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#"><i class="material-icons" style="font-size:24px;color:red">Category</i></a>
					<li><a href="Products" >Cricket</a></li>
					<li><a href="Products">Shuttle</a></li>
					<li><a href="Products">Other Sports</a></li>
				</ul></li>
			<li><a href="Aboutus">About Company</a></li>
			<li><a href="Contactus">contact us</a></li>
			<li><a href="Admin"><span class="glyphicon glyphicon-user"></span>Admin</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
		
		<li><a href="register"><span
					class="glyphicon glyphicon-user"></span>Register</a></li>
		
		
		 <c:if test="${empty RegModel}">
			
				<li><a href="Login"><span
					class="glyphicon glyphicon-log-in"></span> Login</a></li>
		</c:if>
		<c:if test="${not empty RegModel}">
		  <li><a href="result" class="btn btn-default btn-lg"><span class="glyphicon glyphicon-shopping-cart"></span> My Items</a></li>
           <li><a href="index" class="btn btn-danger btn-lg"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
           </c:if>
           
             <button> <i class="fa fa-cart-arrow-down" style="font-size:36px;color:red"></i></button>
        </ul>
	</div>
	</nav>
</div>
</div>
</body>
</html>