<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.text.*,java.util.*, java.time.LocalDate,java.lang.*" %>
<!DOCTYPE html>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
   
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>

        .box
        {
            width: 500px;
        
           border-right:1px solid grey;
           border-left:1px solid grey;
           border-bottom:1px solid grey;
            position: relative;
            top:60px;
            left: 30%;
            padding: 15px;
            border-radius:10px;
            
        }
        span{
          float:right;
       color: rgb(192, 189, 189);
       }
        .header
        {
            background-color:rgb(163, 215, 240);
            padding:10px;
            width:500px;
            position:relative;
            right:16px;
            bottom:15px;
             border-radius:10px;
        }
        .thick{
          
          color:red;
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
   
    SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");     
    Date pickupdate=formatter1.parse((String)session.getAttribute("pickupdate"));
    Date dropdate=formatter1.parse((String)session.getAttribute("dropdate"));
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy");  
    
   
     String Date1 = formatter.format(pickupdate);
     String Date2 = formatter.format(dropdate);
     long price=(long)session.getAttribute("price");
     long days=(long)session.getAttribute("totaldays");
     long Rentprice=price*days;
     
     long totalprice=Rentprice+40;
     session.setAttribute("totalcost",totalprice);
      session.setAttribute("pickup",Date1);
      session.setAttribute("drop",Date2);
    
     

    %>
    <div class="box">
       <div class="header">
       <h2><%=session.getAttribute("carname") %></h2>
       <p><%=session.getAttribute("type") %></p>
       </div>
       <br>
       <h6>Pickup date <span><%=Date1 %></span></h6>
       <h6>Drop date <span><%=Date2 %></span></h6>
       <h6>Pickup and Drop location <span><%=session.getAttribute("location") %></span></h6>
       <h6>Total days <span><%=session.getAttribute("totaldays") %>  days</span></h6>
       <h6 >Per/Day Price <span class="thick">&#8377;<%=session.getAttribute("price") %></span></h6>
       <hr>
       <h5 >Rent Price <span class="thick">&#8377;<%=Rentprice %></span></h5>
       <h5>Convenience fees<span class="thick">&#8377;<%=40%></span></h5>
       <hr>
       <h4 >total<span class="thick">&#8377;<%=totalprice%></span></h4>
           
       <hr>
       <form action="BookingServlet" method="post">
       <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to Book</button>
       </form>
    </div>
</body>
</html>