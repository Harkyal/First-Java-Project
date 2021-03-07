<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.cestar.model.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body class="bg-info">

<%

  List<Client> shippingrecords = new ArrayList<>();
 
   shippingrecords = (List)session.getAttribute("clients_list");
   
   //out.print(emps);

%>

 <table class= "table table-striped  bg-light">
 
  <tr class="bg-success">  <th>ID</th> <th>CONTACT</th> <th>ITEM SHIPPED</th> <th>DATE RECEIVED</th> <th>DATE SHIPPED</th> <th>UPDATE</th> <th>DELETE</th></tr>
 
  <%  
 
   for(Client c:  shippingrecords ){
 
  out.print("<tr> <td>"+c.getClientID()+"</td> <td>"+c.getContact()+"</td> <td>"+c.getItemShipped()+"</td> <td>"+c.getDate_Recieved()+"</td> <td>"+c.getDate_Shipped()+"</td> <td><a href='edit?Client_ID="+c.getClientID()+"' class = 'btn btn-secondary'>Update</a></td> <td><a href='delete?Client_ID="+c.getClientID()+"'class='btn btn-info'>Delete </a></td></tr>");
 
   }
 
 
  %>


 </table>
<a href="insert.jsp" class="btn btn-success">Insert Record</a>
</body>
</html>
