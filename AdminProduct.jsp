<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
<title>AdminProduct</title>
<jsp:include page="Admin.jsp"/>
</head>
<body>

<script>
var catgry = ${data};
var suplier = ${data2};
var prdt = ${data3};
  
  
 
  angular.module('repeatSample', []).controller('repeatController', function($scope)
   {
	         $scope.category=catgry;
              $scope.supplier=suplier;
               $scope.product=prdt;               
    });
</script>
<!--<c:out value="${check}"></c:out>-->
<div class="container" ng-app="repeatSample" >
<c:choose>
<c:when test="${check}">
	<div class="row">
		<form:form class="form-horizontal" method="post" action="addpro" commandName="AdminProductmodel"  enctype="multipart/form-data">
			<fieldset>
               <!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">ProductId</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="pid" readonly="false" value="${pid+1}"></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">ProductName</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="pname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="pdescription" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="sid" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.sid}}">{{sup.sname}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="cid" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.cid}}">{{cat.cname}}</form:option>
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pstock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pprice"></form:input>

					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Image</label>
					<div class="col-md-5">
						 <form:input type="file" path="pimage"/>
					</div>
				</div>
				
			
				
			

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>
	
</c:when>
<c:otherwise >

	<div class="row">
		<form:form class="form-horizontal" method="post" action="Updatepro"	commandName="AdminProductmodel">
			<fieldset>

				<!-- Form Name -->
				<legend>Product Details</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="requestName">Product
						Id</label>
					<div class="col-md-4">
						<form:input class="form-control input-md" 	path="pid" readonly="true" ></form:input>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="company_name">Product
						Name</label>
					<div class="col-md-5">
						<form:input placeholder="" class="form-control input-md"
							required="" path="pname"></form:input>

					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="comments">Product
						Description</label>
					<div class="col-md-4">
						<form:textarea class="form-control" path="pdescription" />
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Supplier
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="sid" >
							<form:option value="-1">Select Supplier Name </form:option>
							<form:option ng-repeat="sup in supplier" value="{{sup.sid}}">{{sup.supName}}</form:option>
						</form:select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="declineType">Category
						Name</label>
					<div class="col-md-6" ng-controller="repeatController">
						<form:select class="form-control" path="cid" >
							<form:option value="-1">Select category Name</form:option>
							<form:option ng-repeat="cat in category"
								value="{{cat.id}}">{{cat.name}}</form:option>sid
						</form:select>
					</div>
				</div>


				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Stock/Quantity</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pstock"></form:input>

					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="econLimOil">Price</label>
					<div class="col-md-5">
						<form:input id="econLimOil" placeholder=""
							class="form-control input-md" path="pprice"></form:input>

					</div>
				</div>


				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-4">

						<input type="submit" class="btn btn-lg btn-info" value="submit"></input>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>


</c:otherwise>

</c:choose>
<div  ng-controller="repeatController" >
	<div>
search:<input type="text" placeholder="search category" ng-model="searchprd"/>
<br><br>
<table class="table table-bordered table-hover table-striped">
 <tr><th>Product Id</th>
<th>Product name</th>
<th>Supplier Id</th>
<th>Category Id</th>
<th>Stock</th>
<th>Price</th>
<th>Image</th>


</tr> 
<tr class="success" ng-repeat="ad in product|filter:searchpro">
                <td>{{ad.pid}}</a></td> 
                 <td>{{ad.pname}}</td>
                <td>{{ad.sid}}</td>
                <td> {{ad.cd}}</td>
                <td> {{ad.pstock}}</td>
                <td> {{ad.pprice}}</td>
                  <td><img src="./resources/images/{{ad.pid}}.jpg" height="50px" width="50px"/></td>
                     <td><a href="updatepro?pid={{ad.pid}}">Edit</a></td>
                <td><a href="deletepro?pid={{ad.pid}}">Delete</a></td>
                 
</tr>
</table>
</div>
	</div>

</div>
      
               </body>
               </html>
              
				