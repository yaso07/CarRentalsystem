<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "com.carRentalAdminResources.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <head>
      <link rel="stylesheet" href="editdelete.css">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title></title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
   .row
   {
   
    width: 65%;
    margin-left: 30px;
    
  }
  .box
  {
    margin-top: 30px;
    margin-left: 30px;
    border: 2px solid rgb(228, 220, 220);
    width: 70%;
    height: 80%;
    padding: 20px;
  }
  .box select{

    width: 300px;
  }
  label{
   margin-left: 70px;
  }
  input{
    padding: 5px;
  }
  #save{

     positin:relative;
   
     margin-left:200px; 
     margin-top:58px;
  }
  #another{
   position:relative;
   margin-top:19.5%;
   left:150px;
   
  }
  #danger
  {
    height: 40px;
    width: 70px;
    position: absolute;
    top: 86%;
    margin-left: 30px;

  }
  #edit
  {
     position:absolute;
     top:10%;
     left:72%;
  }
  #acti{
  background-color: #666;
 
   
}
.act:hover
{
 
  background-color: #666;
  color: white;
}
    </style>

    
   
  </head>
  <body>
  
 
<main>
  
   
     <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 380px;">
        <a onclick="visible()" href="" class="d-flex align-items-center flex-shrink-0 p-3 link-dark text-decoration-none border-bottom">
          <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-5 fw-semibold">groups</span>
        </a>
         
        <div class="list-group list-group-flush border-bottom scrollarea"  id="acti">
        <%
    
          ArrayList<Addcar> cars=ViewCarDb.getAdminView();
        for(Addcar car:cars){ %>
    
          <a  href="EditDeleteCar.jsp?name=<%=car.getVehicleBrand() %>" class="list-group-item list-group-item-action py-3 lh-tight act"  aria-current="true">
            <div class="d-flex w-100 align-items-center justify-content-between">
              <strong class="mb-1"><%=car.getVehicleBrand()%></strong>
              <small>Wed</small>
            </div>
          </a> 
          
           <%}%>
            </div>
      </div>
      <%
              String vehicle=request.getParameter("name");
              Addcar temp_car=EditDeleteView.toview(vehicle);
      %>
 
     <div class="b-example-divider"></div>

 <div class="row" >
   
  <div class="box" >
   <form action="EditCarServlet?name=<%=temp_car.getVehicleBrand() %>" method="post">
     
   <label for="">Vehicle</label>
   <input id="vehicle" style="margin-top:50px;margin-left:5px" onclick="enable()"  name="vehicle" required placeholder="<%=temp_car.getVehicleBrand() %>" type="text"  >
   <br>
   <label for="">Price</label>
   <input id="prize" style="margin-top:20px;margin-left:20px" name="price" required placeholder="<%=temp_car.getPrice() %>" type="number" ><br>
   <label for="">No Of Cars</label>
   <input type="number"  style="margin-top:20px;margin-right:10px;"  name="available" placeholder="<%=temp_car.getNoOfCars()%>" required>
    <br>
    <label for="">Type</label>

   <select id="type" style="margin-top:20px;display:inline-block;margin-left:20px" required name="options" class="form-select" aria-label="Disabled select example"  name="options" required>
    <option selected><%=temp_car.getType()%></option>
     <option value="compact">Compact</option>
      <option value="economy" >Economy</option>
    </select>
    <a id="another" href="addcarpage.jsp" class="btn btn-primary">Add another</a>
    <button id="save" type="submit" class="btn btn-primary">Save</button>
    </form>
    </div>
    
         <form action="DeleteServlet?id=<%=temp_car.getVehicleBrand() %>" method="post" name="DeleteServlet"  >
     <button  id="danger" type="submit" class="btn btn-danger">Delete</button>
    </form>  
</div>

 
</main>

 
    
</div>
    <script>
 
   
    </script>


  </body>
</html>
