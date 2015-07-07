<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.16/angular.min.js"></script>
<script src="/angular102/resources/js/script.js"></script>
</head>
<body ng-app="application">

<div class="row">
<div class="col-md-6" ng-controller="firstController">
<ul>
<li ng-repeat="movie in movies">{{movie}} <button class="btn btn-default" type="button" ng-click="getMovie(movie)">Get Info</button></li>

</ul>
</div>
<div class="col-md-6" ng-controller="secondController">
  <img ng-src="{{poster}}" alt="">
</div>
</div>
<div class="row">
<div class="col-md-6" ng-controller="thirdController">
{{movieName}}
</div>
<div class="col-md-6" ng-controller="fourthController">
{{plot}}
</div>

</div>




</body>
</html>