<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>서비즈 지향 텀프로젝트 - 조건별 검색</title>

  <!-- Bootstrap core CSS -->
  <link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.css">

  <!-- Custom fonts for this template -->
  <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
  <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

  <!-- Custom styles for this template -->
  <link href="/resources/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
  <div class="container">
    <a class="navbar-brand" href= "/">채용정보 API</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      Menu
      <i class="fas fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="/">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/api/about">API</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/search/condition">조건별 검색</a>
        </li>

      </ul>
    </div>
  </div>
</nav>

<!-- Page Header -->
<header class="masthead" style="background-image: url('/resources/img/about-bg.jpg')">
  <div class="overlay"></div>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <div class="page-heading">
          <h1>조건별 검색</h1>
          <span class="subheading">회사명,유형,모집시작일, 모집마감일 별 검색이 가능합니다.</span>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- Main Content -->
<div class="container">
  <div class="row">
    <div class="col-lg-12 col-md-12 mx-auto">


      <form:form  method="post">
        <div class="row">
          <div class="form-group col-md-6">
            <label for="name">Name</label>
            <input class="form-control" name="name" id="name" placeholder="회사명"/>
          </div>
          <div class="form-group col-md-6">
            <label for="type">Type</label>
            <input  name="type" id="type" class="form-control" placeholder="타입"/>
          </div>
        </div>
        <div class="row">
          <div class="form-group col-md-4">
            <label for="startdate">StartDate</label>
            <input type="date" name="startDate" id="startdate" class="form-control"/>
          </div>
          <div class="form-group col-md-4">
            <label for="enddate">EndDate</label>
            <input type="date" name="endDate" id="enddate" class="form-control"/>
          </div>
          <div class="form-group  col-md-4">
            <label for="submitButton"></label>
            <input type="submit" value="검색" id = "submitButton" class="btn btn-dark btn-block">
          </div>
        </div>
      </form:form>

      <c:choose>

        <c:when test="${Result ne null}">
          <c:forEach var="result" items="${Result}">
            <hr/>
            <c:forEach var="job" items="${result.employList}">
              <p>${job.name}<br/>
                  ${job.title}</p>
            </c:forEach>
            <hr/>
            <c:forEach var="news" items="${result.newsList}">
              <p>${news.title}<br/>
                  ${news.description}</p>
            </c:forEach>
            <hr/>
          </c:forEach>

        </c:when>
        <c:when test="${Result eq null}">
          not found
        </c:when>
      </c:choose>





      <c:if test="${status  eq null}">
        <p>${status}</p>
      </c:if>
      <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Saepe nostrum ullam eveniet pariatur voluptates odit, fuga atque ea nobis sit soluta odio, adipisci quas excepturi maxime quae totam ducimus consectetur?</p>--%>
      <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eius praesentium recusandae illo eaque architecto error, repellendus iusto reprehenderit, doloribus, minus sunt. Numquam at quae voluptatum in officia voluptas voluptatibus, minus!</p>--%>
      <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aut consequuntur magnam, excepturi aliquid ex itaque esse est vero natus quae optio aperiam soluta voluptatibus corporis atque iste neque sit tempora!</p>--%>
    </div>
  </div>
</div>

<hr>

<!-- Footer -->
<footer>
  <div class="container">
    <div class="row">
      <div class="col-lg-8 col-md-10 mx-auto">
        <ul class="list-inline text-center">
          <li class="list-inline-item">
            <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
            </a>
          </li>
        </ul>
        <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
      </div>
    </div>
  </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>


<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="/resources/js/clean-blog.min.js"></script
</body>
</html>