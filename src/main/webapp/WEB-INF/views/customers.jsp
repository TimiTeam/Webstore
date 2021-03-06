<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;
	charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customers</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Customers</h1>
				<p>This is all our customer in one page</p>
			</div>	
		</div>
	</section>
	
	<section class="container">
		<div class="row">
			<c:forEach items="${customers}" var="customer">
				<div class="col-sm-6 col-md-3">
					<div class="thumbnail">
						<div class="caption">
							<h3> ${customer.name}</h3>
							<p>Id: ${customer.customerId}</p>
							<p>Customer address<b> ${customer.address} </b></p>
							<p>Customer order quantity:<b> ${customer.noOfOrdersMade} </b> in total </p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
</body>
</html>