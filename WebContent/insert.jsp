<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel = "stylesheet" href= "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
</head>
<body>
<form action="insert" class="container">
<div class="form-group">
<label for="e_id">Client ID</label>
<input type="text" id="c_ClientID" name="c_ClientID" class="form-control">

</div>

<div class="form-group">
<label for="e_n">Contact</label>
<input type="text" id="c_c" name="c_Contact" class="form-control">

</div>

<div class="form-group">
<label for="e_c">Item Shipped</label>
<input type="text" id="c_i" name="c_ItemShipped" class="form-control">

</div>

<div class="form-group">
<label for="e_d">Date Received</label>
<input type="text" id="c_dr" name="c_Date_Recieved" class="form-control">

</div>

<div class="form-group">
<label for="e_e">Date Shipped</label>
<input type="text" id="c_ds" name="c_Date_Shipped" class="form-control">

</div>
<button type="submit" class="btn btn-success">Insert Record</button>
</form>
</body>
</html>