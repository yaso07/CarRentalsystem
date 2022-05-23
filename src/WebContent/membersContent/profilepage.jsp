<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import = "com.authentication.*,java.util.*,com.booking.*" %>
<!DOCTYPE html>
<html>
<head>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>

        body{
  
            margin: 0%;
        }
        .col{

          width: 100%;
            display: flex;
            flex-direction: row;
           
             
        }
        .row1
        {
           width: 600px; 
           
            padding: 10px;
          
         border-right: 10px solid rgb(179, 175, 175);
        }
      
        h2{
            color: rgb(192, 104, 104);
        }
        .edit
        {
            display: flex;
            flex-direction: row;
           
        }
        #edit{
            width: 150px; 
            margin-top: 10px;
            margin-left: 180px;
        }
        #save{

            width: 100px;
            margin-left: 30px;
        }
        #cancel{
            width: 50px;
        }
          .row2
        {
            width: 80%;
            margin-left: 30px;
            padding:20px;
            
          
        }
        .col2
        {
           display:flex;
           flex-direction:row;
           border:1px solid grey;
           width:300px;
           padding:10px;
           margin-top:15px;  
                
                
        
        }
        
        .price
        {
           position:relative;
           top:10px;
        }
        .box
        {
             display:flex;
           flex-direction:row;
           
        }
        .box>div{
            margin-left:20px;
        }
        .dis{
          display:flex;
          flex-wrap:wrap;   
        
          width:650px;
 
          
        }
        #termi{
        
         height:30px;
          position:relative;
         
         
        }
        #home{
        
          position:absolute;
          top:25px;
          left:80%;
        }
        
          
    </style>
</head>
<body>
   <%
   String user=(String)session.getAttribute("name");
   if(user==null)
   {
	   response.sendRedirect("../userlogin.jsp");
	  
   }
 
   userdetails User=UserDetailsDb.getdetails(user);
   
   
   %>
   
    <div class="col">
        <div class=row1>
            <h2>My profile</h2>
            <br>
          <form action="../UpdateUserDetails"  method="post">
                <div class="row g-3" style="width:500px">
                  <div class="col-sm-6">
                    <label for="firstName" class="form-label">First name</label>
                    <input type="text" class="form-control" id="firstName" name="firstname" placeholder="<%=User.getFirstname() %>" disabled required>
                    <div class="invalid-feedback">
                        Valid first name is disabled.
                    </div>
                  </div>
      
                  <div class="col-sm-6">
                    <label for="lastName" class="form-label">Last name</label>
                    <input type="text" class="form-control" id="lastName" name="lastname" placeholder="<%=User.getLastname() %>" value="" disabled required>
                    <div class="invalid-feedback">
                      Valid last name is disabled.
                    </div>
                  </div>
                  <div class="col-12">
                    <label for="username" class="form-label">Mobile No</label>
                    <div class="input-group has-validation">
                      
                      <input type="number" class="form-control" id="username" name="mobile" placeholder="<%=User.getMobile() %>" disabled required>
                    
                    </div>
                  </div>
              
      
                  <div class="col-12">
                    <label for="email" class="form-label">Email <span class="text-muted">(Optional)</span></label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="<%=User.getEmail() %>" disabled required>
                    <div class="invalid-feedback">
                      Please enter a valid email address for shipping updates.
                    </div>
                  </div>
      
                  <div class="col-12">
                    <label for="address" class="form-label">Address</label>
                    <input type="text" class="form-control" id="address" name="address1" placeholder="<%=User.getAddress1() %>" disabled required>
                    <div class="invalid-feedback">
                      Please enter your shipping address.
                    </div>
                  </div>
      
                  <div class="col-12">
                    <label for="address2" class="form-label">Address 2  </label>
                    <input type="text" class="form-control" id="address2" name="address2" placeholder="<%=User.getAddress2() %>" disabled required>
                  </div>
      
                  <div class="col-md-5">
                    <label for="country" class="form-label">Country</label>
                    <select class="form-select" id="country" name="country" disabled required>
                       <option selected><%=User.getCountry() %></option>
                      
                      <option value="India">India</option>
                      <option value="Srilanka"></option>
                    </select>
                    <div class="invalid-feedback">
                      Please select a valid country.
                    </div>
                  </div>
      
                  <div class="col-md-4">
                    <label for="state" class="form-label">State</label>
                    <select class="form-select" id="state" name="state" disabled required>
                       <option selected><%=User.getState() %></option>
                      <option value="TamilNadu">TamilNadu</option>
                      <option value="Kerala">Kerala</option>
                      <option value="Andhra Pradesh">Andhra Pradesh</option>
                    </select>
                    <div class="invalid-feedback">
                      Please provide a valid state.
                    </div>
                  </div>
      
                  <div class="col-md-3">
                    <label for="zip" class="form-label">Pincode</label>
                    <input type="text" class="form-control" id="pin" name="pincode" placeholder="<%=User.getPincode() %>" disabled required>
                    <div class="invalid-feedback">
                      Pin code disabled.
                    </div>
                  </div>
                </div>
      
                <hr class="my-6">
                <div class="edit">
                    <a  style="display:none" href="profilepage.jsp" id="cancel"    class="w-100 btn btn-primary btn-lg"  type="submit">Cancel</a>
                    <button  style="display:none" onclick="save()"disabled id="save" class="w-100 btn btn-primary btn-lg"  type="submit">Save</button>
                </div>  
            </form>
                
       
            <button onclick="edit()"  id="edit" class="btn btn-primary btn-lg"  type="submit">Edit</button>

               
    </div>
     
  
    <div class="row2">
 <%
       ArrayList<bookingdetails> bookinglist=bookingdetails.bookinghistory((String)session.getAttribute("name")); 
   %>  
      <h1>Recent bookings</h1>
         <a href="../CarRentalViewpage.jsp" id="home" class="btn btn-primary btn-lg"  type="submit">Home</a>
      <div class="dis">
       <% for(bookingdetails book:bookinglist){ %>
          <div class="box">
        
			      <div class="col2">
			     
					         <div> 
					             <h2><%=book.getCarname()%></h2>
					             <p><%=book.getType() %><p>
					              <span>dropdate <%=book.getDropdate()%></span>
					                <h4>&#8377;<%=book.getTotalcost() %></h4>
					          </div>
					         
					    <a href="../Deletebooking?name=<%=book.getId() %>"  class="btn btn-primary" id="termi">
                         cancel
                        </a>
                        
			      </div>

			       
			  </div>
			    <%} %>
			    </div>
    </div>
    </div>
     
   <script>
     function edit()
     {
        var save=document.getElementById("save");
        let collect=document.getElementsByClassName("form-control");
        let collect2=document.getElementsByClassName("form-select");
        if(save.disabled==true)
        {
               
                for(let i=0;i<collect.length;i++)
                {
                    collect[i].disabled=false;
                    console.log("ccdscsd");
                }  
                for(let i=0;i<collect2.length;i++)
                {
                    collect2[i].disabled=false;
                    console.log("ccdscsd");
                }
        }
        save.disabled=false;
        document.getElementById("cancel").style.display="block"
        document.getElementById("save").style.display="block"
        document.getElementById("edit").style.display="none";
       
     }
     function save()
     {
        var save=document.getElementById("save");
        let collect=document.getElementsByClassName("form-control");
        let collect2=document.getElementsByClassName("form-select");
        if(save.disabled==false)
        {
               
                for(let i=0;i<collect.length;i++)
                {
                    collect[i].disabled=true;
                    console.log("ccdscsd");
                }  
                for(let i=0;i<collect2.length;i++)
                {
                    collect2[i].disabled=true;
                    console.log("ccdscsd");
                }
        }
        document.getElementById("save").disabled=true;
       
        document.getElementById("edit").style.display="block";
     }
      
   </script>
</body>
</html>