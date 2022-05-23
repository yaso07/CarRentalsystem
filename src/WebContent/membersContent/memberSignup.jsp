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
.box
{
 position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    width: 30%;
    padding: 30px 10px 20px 10px;
    box-sizing: border-box;
    border: 1px solid #dadce0;
    -webkit-border-radius: 8px;
    border-radius: 8px;
    
 
}
.input1{
  margin-top:20px;
  
   
}
 
button{

    position: relative;
    top:10px;
    left:180px;
}
 .box p {
    font-size: 18px;
     font-family: "Times New Roman", Times, serif;
    font-weight: 900;
    letter-spacing: .1px;
    line-height: 1.5;
    margin-bottom: 25px;
    text-align: center;
    
  }
</style>
</head>
<body>
 
<div class="box">
   <p>Create account</p>
  <form  class="px-4 py-3" action="../createAccountServlet" method="post">
    <div class="mb-3">
       
      <input type="text" class="form-control"   required placeholder="Enter Username" name="username" id="exampleDropdownFormEmail1" placeholder="email@example.com">
    </div>
    
    <div class="mb-3 input1">
       
      <input type="password" class="form-control"   required placeholder="Enter Password" name="password" id="password1" placeholder="Password">
    </div>
     <div class="mb-3 input1">
       
      <input type="password" class="form-control" onblur="check()"  required placeholder="Confirm Password" name="confirm_pass" id="password2" placeholder="Password">
    </div>
    
    
    <button type="submit" id="but" aria-disabled="true"  class="btn btn-primary">Create Account</button>
    <br>
    <br>
    <p style="display: none" id="length">password length must be 8 characters</p>
  </form>
 
   
</div>
<script>
   
  function check()
   {
       var pass=document.getElementsByName("password")[0].value;
       var conf=document.getElementsByName("confirm_pass")[0].value;
       var para= document.getElementById("length")
       if(pass.length<8)
       {
           para.style.display="block" 
           para.style.color="red"
       }
       else{
          para.style.display="none" 
       }
       
     
        if(pass!=conf)
       {
         document.getElementById("password1").type="text"
         document.getElementById("password2").type="text"
         document.getElementById("password2").style.color="red"
         document.getElementById("but").disabled=true;
            
       }
       else
       {
        document.getElementById("password1").type="password"
        document.getElementById("password2").type="password"
        document.getElementById("password2").style.color="black"
        document.getElementById("but").disabled=false;
       }  
       
   }
</script>
</body>
</html>