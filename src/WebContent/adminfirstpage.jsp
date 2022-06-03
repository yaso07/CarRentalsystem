<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.row{
    position:relative;
    padding: 10px;
    width:90%;
    border:3px solid rgb(224, 224, 224);
    top:100px;
    margin-left: 10px;
}
.button
{
     position: relative;
     left: 900px;
}
.header{
  display:flex;
  flex-diection:row;
  position:absolute;
  left:60%;
  padding:10px;
  
 
}
.header>a{
 margin-left:40px;
}
 



 
</style>
</head>
<body>
<%
   	HttpServletResponse httpResponse = (HttpServletResponse) response;
	httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	httpResponse.setHeader("Pragma", "no-cache"); // HTTP 1.0
	httpResponse.setDateHeader("Expires", 0);
%>
<%
 String user=(String)session.getAttribute("name");
   if(user==null)
   {
	   response.sendRedirect("userlogin.jsp");
	  
   }
   %>
   
   <div class="header">
    <a  class="btn btn-secondary" href="addcarpage.jsp">manage cars and members</a>
 <a id="canvas" class="btn btn-secondary" href="membersContent/profilepage.jsp">My Profile</a>
  <a id="logout" class="btn btn-secondary" href="LogoutServlet">Logout</a>
 </div>
  
<form action="GetBookingDuration" method="post">
<div class="row">
 
<div class="col input-group mb-3">
    <span class="input-group-text" id="basic-addon1">Location</span>
    <input class="form-control" list="datalistOptions"  name="options"  id="exampleDataList" placeholder="Type to search..." aria-describedby="basic-addon1" required>
<datalist id="datalistOptions"required>
  <option value="chennai">
  <option value="coimbatore">
  <option value="Salem">
  <option value="Banglore">
 
</datalist>
</div>
<div class="col">
    <input type="date" style="display:inline-block;width:230px"  name="start" class="form-control" required>
    <span><input type="time" required></span>
</div>
<div class="col">
    <input type="date"  style="display:inline-block;width:230px"  name="end" class="form-control" required>
    <span><input type="time" required></span>
</div>
<div class="button">
    <button type="submit"  class="btn btn-primary">search</button>
</div>
</form>
 
</div>
</body>
</html>