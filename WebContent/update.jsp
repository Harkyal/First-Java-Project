<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

Client c=(Client)session.getAttribute("c");
out.print(c);
%>
<form action="update" class="bg-info">

<div class="form-group">
<label for="c_ClientID">Update Client id:</label>
<input type="text" class="form-control" id="c_ClientID"name="c_ClientID" value="<%=c.getClientID()%>">
</div>

<div class="form-group">
<label for="c_Contact">Update Client Contact:</label>
<input type="text" class="form-control" id="c_Contact"name="c_Contact" value="<%=c.getContact()%>">
</div>

<div class="form-group">
<label for="c_ItemShipped">Update Client Item Shipped:</label>
<input type="text" class="form-control" id="c_ItemShipped" name="c_ItemShipped" value="<%=c.getItemShipped()%>">
</div>

<div class="form-group">
<label for="c_Date_Recieved">Update Client Date Received:</label>
<input type="text" class="form-control" id="c_Date_Recieved" name="c_Date_Recieved" value="<%=c.getDate_Recieved()%>">
</div>

<div class="form-group">
<label for="c_Date_Shipped">Update Client Date Shipped:</label>
<input type="text" class="form-control" id="c_Date_Shipped"name="c_Date_Shipped" value="<%=c.getDate_Shipped()%>">
</div>

<button class="btn btn-success" type="submit" role="button">Update Records</button>

</form>
</body>
</html>