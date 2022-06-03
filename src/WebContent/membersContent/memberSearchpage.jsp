<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "com.authentication.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <head>
      <link rel="stylesheet" href="../editdelete.css">
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
     
    
    overflow-y:auto;
    padding:10px;
  }
  
  label{
    margin-left: 70px;
  }
  input{
    padding: 5px;
  }
  .view{
  width:550px;
  padding:20px;
   border:2px solid grey;
  position:relative;
  left:10%;
  margin-top:30px;
  }
  #delete{
    postion:relative;
    margin-left:40px;
    margin-top:30px;
  }
  #back{
    width:60px;
    margin-left:70%;
  }
    .act:hover
{
 
  background-color: #666;
  color: white;
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
 String USER=(String)session.getAttribute("name");
   if(USER==null)
   {
	   response.sendRedirect("../userlogin.jsp");
	  
   }
   %>
 
<main>
  
   
     <div class="d-flex flex-column align-items-stretch flex-shrink-0 bg-white" style="width: 450px;">
        <a onclick="visible()" href="" class="d-flex align-items-center flex-shrink-0 p-3 link-dark text-decoration-none border-bottom">
          <svg class="bi me-2" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
          <span class="fs-5 fw-semibold">groups</span>
        </a>
         
       <div style="display:inline-block;"  class="list-group list-group-flush border-bottom scrollarea">
				        <form action="../UserSearchServlet" method="post">
						           <div class="d-flex align-items-center flex-shrink-0 p-3">
						           <select  class="form-select" name="options" aria-label="Default select example">
						                    <option selected>Open this select menu</option>
						                    <option value="firstname">Search by name</option>
						                      <option value="email">by email</option>
						                    <option value="mobile">by mobile</option>
						                     <option value="all">All</option>
						                    <option value=""></option>
						                  </select>
						                <input style="margin-left:5px"  class="form-control" name="search"   placeholder="Type to search..." >
						            <button style="margin-left:5px"  class="btn btn-primary">search</button>
						            
						            
						            </div> 
						            
						   </form> 
						           <% ArrayList<userdetails> user=UserSearch.filter();%>
						          <% for(userdetails User:user){ %>
	      <a style="width:350px;display:inline-block;" onclick="visible()" href="memberSearchpage.jsp?id=<%=User.getId() %>" class="list-group-item   py-3 lh-tight act" aria-current="true">
		            <div class="d-flex w-100 align-items-center justify-content-between">
		              <strong class="d-flex mb-1"><%=User.getFirstname() %> <p style="margin-left:5px">  <%=User.getLastname() %></p> </strong>
		              <small></small>
		            </div>
          </a> 
          
           <%}%>
            </div>
      </div>
      <%
      
            String id=request.getParameter("id");
            if(id==null)
            {
            	id="0";
            }
            userdetails user_temp=UserDetailsDb.getuserdetails(id);
           
          
      
           %>
 
     <div class="b-example-divider"></div>

 <div class="row" >
   
   <a id="back" class="btn btn-warning" href="../addcarpage.jsp">Back</a>
   <form>
     <div class="row g-3 view" >
            <div class="col-sm-6">
              <label for="firstName" class="form-label">First name</label>
              <input type="text" class="form-control" id="firstName" name="firstname" placeholder="<%=user_temp.getFirstname() %>" value="" disabled>
             
            </div>

            <div class="col-sm-6">
              <label for="lastName" class="form-label">Last name</label>
              <input type="text" class="form-control" id="lastName" name="lastname" placeholder="<%=user_temp.getLastname() %>" value="" disabled>
               
            </div>

            <div class="col-12">
              <label for="username" class="form-label">Mobile No</label>
              <div class="input-group has-validation">
                
                <input type="text" class="form-control" id="username" name="username" placeholder="<%=user_temp.getMobile() %>" disabled>
              
              </div>
            </div>

            <div class="col-12">
              <label for="email" class="form-label">Email </label>
              <input type="email" class="form-control" name="email" id="email" placeholder="<%=user_temp.getEmail() %>" disabled>
              
            </div>

            <div class="col-12">
              <label for="address" class="form-label">Address</label>
              <input type="text" class="form-control" id="address" name="address1" placeholder="<%=user_temp.getAddress1() %>"  disabled>
             
            </div>

            <div class="col-12">
              <label for="address2" class="form-label">Address 2  </label>
              <input type="text" class="form-control" id="address2" name="address2" placeholder="<%=user_temp.getAddress2() %>" disabled>
            </div>

            <div class="col-md-5">
              <label for="country" class="form-label">Country</label>
              
                 <input type="text" class="form-control" id="address2" name="address2" placeholder="<%=user_temp.getAddress2() %>" disabled>

            </div>

            <div class="col-md-4">
              <label for="state" class="form-label">State</label>
            
               <input type="text" class="form-control" id="address2" name="address2" placeholder="<%=user_temp.getState() %>" disabled>
            
            </div>

            <div class="col-md-3">
              <label for="zip" class="form-label">Pincode</label>
              <input type="number"  class="form-control" id="zip" name="pincode" placeholder="<%=user_temp.getPincode() %>" disabled>
            
            </div>
        </div>
  </form> 
 

      
         
        <form action="../userDeleteServlet?name=<%=user_temp.getEmail() %>" method="post">
        <button id="delete" type="submit" class="btn btn-danger">Delete</button>
       </form>
      

  </div>  
 
</main>

 
    
 
    <script>
     
    function visible()
    {
        if(document.getElementById("hide").style.display=="none")
        {
           document.getElementById("hide").style.display="block";
        }
    }
    </script>

       
  </body>
</html>
