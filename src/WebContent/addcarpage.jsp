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
<style type="text/css">
.box{
   position:relative;
   top:5px;
   
   width:35%;
   padding:40px;
}
.h3{
  margin-left:10px;
}
#editpage{
position :absolute;
left:400px;
top:40px;
}
#memberpage{

  position:absolute;
  left:510px;
  top:40px;
}
#logout
{
   position:absolute;
   left:80%;
   top:40px;
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
   
<p class="h3 $primary">Add Car</p> 
<a id="editpage" href="EditDeleteCar.jsp"> <button   class="btn btn-primary">Car Data</button></a>
<a id="memberpage" href="membersContent/memberspage.jsp"> <button   class="btn btn-primary">Member Data</button></a>
  <a id="logout" class="btn btn-danger" href="LogoutServlet">Logout</a>
<div class="box">
<form action="AddcarServlet" method="post">
 <table class="table table-striped border border-4">
       <tr>
          <td>Vehicle&Model:    <input type="text" name="vehicle" required></td></tr>
       <tr>
       <td>Price per/day:    <input type="number" name="price" required></td>
       </tr>
        <tr>
       <td>No Of Cars:    <input type="number" name="available" required></td>
       </tr>
       <tr>
        
        <td><select class="form-select" aria-label="Disabled select example" name="options" required>
       <option selected>type</option>
        <option value="compact">Compact</option>
         <option value="economy" >Economy</option>
       
       </select></td>
       </tr>
       
       <tr>
        <td><button type="submit" class="btn btn-primary">Add</button></td>
       </tr>
    </table>
</form>
  </div>
  
</body>
</html>