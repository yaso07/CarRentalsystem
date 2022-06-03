<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
 <%@ page import = "com.carRentalAdminResources.*,java.util.*,com.userview.*,com.booking.*" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <style>
.row{
    position:relative;
    padding: 10px;
    width:80%;
    
    border:3px solid rgb(224, 224, 224);
    top:20px;
    margin-left: 200px;
}
 .cardslot{
 
     display: flex;
     flex-direction: row;
     padding: 10px;
     flex-wrap: wrap;
     margin-top:40px;
   
     
 }
  .cardslot >div{
     margin: 10px;
     width:390px;
 }
 #home{

    position: relative;
    top: 50px;
    left: 40px;
}
 
.header{
  display:flex;
  flex-diection:row;
  position:absolute;
  left:70%;
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

String  a=(String)session.getAttribute("alert");
if( a!=null && a.equals("alert"))
{
	%>
	<script>
	   alert("car booked successfully");
	</script>
<% session.setAttribute("alert", "null"); }%>



 <%
   String user=(String)session.getAttribute("name");
  if(user==null)
   {
   response.sendRedirect("userlogin.jsp");
   }
 
   
 %>
 
 <div class="header">
 
  <a id="logout" class="btn btn-secondary" href="LogoutServlet">Logout</a>
 </div>
  
  
  
  <a id="home" class="btn btn-primary" href="UserFirstpage.jsp" role="button">Home</a>
 
<form action="searchServlet" method="post">
<div class="row">
     
   <div class="col input-group">
	    <span class="input-group-text" id="basic-addon1">Price</span>
	    <select name="options" required>
	        <option value="high">High to Low</option>
	        <option value="low">Low to High</option>
	        <option value="mid">medium Range</option>
	    </select>
   </div>
   <%  
   CheckingAvailability.getdata((String)session.getAttribute("pickupdate"),(String)session.getAttribute("dropdate"));
    ArrayList<Addcar> cars=CheckingAvailability.viewcar(); %>
	<div class="col input-group" style="position:relative;right:100px;">
	    
	    <input  class="form-control"   name="datalist"  id="exampleDataList" placeholder="Type to search..." aria-describedby="basic-addon1" >
 
	
	 
	</div>
    <div class="col">

    <button type="submit" class="btn btn-primary">search</button>
   </div>
  
</div>
  </form>
<div class="cardslot">
 <%
 
   
   for(Addcar car:cars){%>
   
   <div class="card">
    <img src="..." class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title"></h5>
      <p class="card-text"><%=car.getVehicleBrand() %> <br><%= car.getPrice() %> <br><%= car.getType() %><br>
      </p>
      <a href="BookingServlet?name=<%=car.getVehicleBrand() %>" class="btn btn-primary">Book</a>
    </div>
  </div>
    <% } %>
   
 </div>   
    


  


</body>
</html>