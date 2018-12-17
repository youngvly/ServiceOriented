<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var = "jspPath" scope = "session" value = "/views/client/"/>
<html lang="en">

<head>
  <style>
    .blueone {
      border-collapse: collapse;
      border-spacing: 0 20px;
      text-align: left;
    }

    .blueone th {
      padding: 10px;
      color: #000000;
      background-color: #F1F1F1;
      border-bottom: 1px solid #E0E2E2;
      text-align: left;
    }
    .blueone td {
      color: #000000;
      padding: 20px;
      border-bottom: 1px solid #ddd;
    }


  </style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>서비즈 지향 텀프로젝트 - API 명세서</title>

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
          <h1>OPEN API</h1>
          <span class="subheading">채용정보 활성화를 위한 RESTFul API 제공</span>
        </div>
      </div>
    </div>
  </div>
</header>

<!-- Post Content -->
<article>
  <div class="container">
    <div class="row">
      <div class="col-lg-12 col-md-12 mx-auto">

        <h1>Public API</h1>
        <br>
        <table class="blueone">
          <tr><th>Resource</th><th>Description</th></tr>
          <tr><td width="80%" >http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job/{employlist}</td><td width="20%">전체 공채속보</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/jobname/{jobname}</td><td>이름으로 조회</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/jobtype{jobtype}</td><td>기업유형으로 조회</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/date/{start}/{end}</td><td>날짜로 조회</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job?name&startDate&endDate&type</td><td>다중조건 조회</td></tr>
        </table>

        <br>
        <h2>Returned Value Description</h2>
        <br>

        <table class="blueone" width="600px" >
          <tr><th>Key Name</th></th><th>Description</th></tr>
          <tr><td width="40%">jobid</td><td >채용공고번호</td></tr>
          <tr><td>type</td><td>고용형태</td></tr>
          <tr><td>edate</td><td>채용종료일자</td></tr>
          <tr><td>sdate</td><td>채용시작일자</td></tr>
          <tr><td>name</td><td>채용업체명</td></tr>
          <tr><td>title</td><td>채용제목</td></tr>
          <tr><td>logo</td><td>채용기업로고</td></tr>
          <tr><td>url</td><td>채용사이트URL</td></tr>
        </table>
        <br>
        <br>
        <table class="blueone" width="600px">
          <tr><th>Key Name</th><th>Description</th></tr>
          <tr><td width="40%">title</td><td >뉴스 제목</td></tr>
          <tr><td>originallink</td><td>뉴스 URL</td></tr>
          <tr><td>pubDate</td><td>뉴스 날짜</td></tr>
          <tr><td>newsid</td><td>뉴스 번호</td></tr>
          <tr><td>jobname</td><td>기업명</td></tr>
        </table>

        <br>
        <h3>Returned Example</h3>
        <br>

      </div>
    </div>
  </div>
</article>

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
<script src="/resources/vendor/jquery/jquery.min.js"/>
<script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />

<!-- Custom scripts for this template -->
<script src="/resources/js/clean-blog.min.js" />


</body>

</html>
