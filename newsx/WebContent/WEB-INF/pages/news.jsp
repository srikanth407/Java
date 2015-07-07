<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View News</title>
<link href="/newsx/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/newsx/resources/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet"/>
<script type="text/javascript" src="/newsx/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="/newsx/resources/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/newsx">NewsX</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="/newsx/addnews">Add News <span class="sr-only">(current)</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="container">
<div class="row">

<div class="col-md-8">

<div class="row">
<div class="panel panel-default">
  <div class="panel-body">
  <h1>  ${news.headlines}</h1>
  </div>
</div>
</div>
<div class="row">
<div class="panel panel-default">
  <div class="panel-body">
<c:if test="${not empty news.videourl}"> 
  
<div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="${news.videourl}"></iframe>
</div>
</c:if> 
<c:if test="${not empty news.imageurl and empty news.videourl}">
<img src="${news.imageurl}" alt="...">
</c:if>
  </div>
</div>
</div>
<div class="row">
<div class="panel panel-default">
  <div class="panel-body">
   ${news.mainstory}
  </div>
</div>

</div>

</div>
<div class="col-md-4">
<c:forEach items="${recommendednews}" var="n">

    <div class="thumbnail">
      <img src="${n.imageurl}" alt="...">
      <div class="caption">
        <h3><a href="/newsx/news?id=${n.news_id}">${n.headlines}</a></h3>
      </div>
    </div>
  
</c:forEach>

</div>

</div>
</div>






</body>
</html>