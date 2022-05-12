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
    width:80%;
    border:3px solid rgb(224, 224, 224);
    top:100px;
    margin-left: 10px;
}
.button
{
     position: relative;
     left: 900px;
}


 
</style>
</head>
<body>
<form action="CarRentalViewpage.jsp" method="post">
<div class="row">
 
<div class="col input-group mb-3">
    <span class="input-group-text" id="basic-addon1">Location</span>
    <input class="form-control" list="datalistOptions" id="exampleDataList" placeholder="Type to search..." aria-describedby="basic-addon1" required>
<datalist id="datalistOptions" required>
  <option value="chennai">
  <option value="coimbatore">
  <option value="Salem">
  <option value="Banglore">
 
</datalist>
</div>
<div class="col">
    <input type="datetime-local" class="form-control" required>
</div>
<div class="col">
    <input type="datetime-local" class="form-control" required>
</div>
<div class="button">
    <button type="submit" class="btn btn-primary">search</button>
</div>
</form>
 
</div>
</body>
</html>