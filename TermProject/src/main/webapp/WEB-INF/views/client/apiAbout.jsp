<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<c:set var = "jspPath" scope = "session" value = "/views/client/"/>
<html lang="en">

<head>
  <style>
    body { background: #fff; }
    table.type11 {
      border-collapse: separate;
      border-spacing: 1px;
      text-align: center;
      line-height: 1.5;
      margin: 20px 10px;
    }
    table.type11 th {
      width: 100%;
      padding: 10px;
      font-weight: bold;
      vertical-align: top;
      color: #fff;
      background: #ce4869 ;
    }
    table.type11 td {
      width: 100%;
      padding: 10px;
      vertical-align: top;
      border-bottom: 1px solid #ccc;
      background: #eee;
    }
    .blueone {
      border-collapse: collapse;
    }
    .blueone th {
      padding: 10px;
      color: #168;
      border-bottom: 3px solid #168;
      text-align: left;
    }
    .blueone td {
      color: #669;
      padding: 10px;
      border-bottom: 1px solid #ddd;
    }
    .blueone tr:hover td {
      color: #004;
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
        <li class="nav-item">
          <a class="nav-link" href="/search/jobname">회사명 검색</a>
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
        <div class="post-heading">
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

        <p>Public API</p>
        <table class="blueone">

          <tr><th>Resource</th><th>Description</th></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job/{employlist}</td><td>최신 공채속보</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/jobname/{jobname}</td><td>기업 이름으로 기업정보 검색</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/jobtype{jobtype}</td><td>기업 유형으로 기업정보 가져오기</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/date/{start}/{end}</td><td>날짜를 검색하여 기업정보 가져오기</td></tr>
          <tr><td>http://testappelasticbeanstalk-env.hhm2ctb7ye.ap-northeast-2.elasticbeanstalk.com/api/json/job?name&startDate&endDate&type</td><td>조건별 정보를 이용한 기업정보 가져오기</td></tr>
        </table>

        <p>[Returned Value Description]</p>
        <table class="blueone">
          <tr><th>Key Name</th></th><th>Description</th></tr>
          <tr><td>jobid</td><td>채용공고번호</td></tr>
          <tr><td>type</td><td>고용형태</td></tr>
          <tr><td>edate</td><td>채용종료일자</td></tr>
          <tr><td>sdate</td><td>채용시작일자</td></tr>
          <tr><td>name</td><td>채용업체명</td></tr>
          <tr><td>title</td><td>채용제목</td></tr>
          <tr><td>logo</td><td>채용기업로고</td></tr>
          <tr><td>url</td><td>채용사이트URL</td></tr>
        </table>

        <p>[Returned Value Description]</p>
        <table class="blueone">
          <tr><th>Key Name</th><th>Description</th></tr>
          <tr><td>title</td><td>뉴스제목</td></tr>
          <tr><td>originallink</td><td>뉴스URL</td></tr>
          <tr><td>pubDate</td><td>뉴스날짜</td></tr>
          <tr><td>newsid</td><td>뉴스번호</td></tr>
          <tr><td>jobname</td><td>기업명</td></tr>
        </table>
        <p>[Returned Example]</p>

        <p>Never in all their history have men been able truly to conceive of the world as one: a single sphere, a globe, having the qualities of a globe, a round earth in which all the directions eventually meet, in which there is no center because every point, or none, is center — an equal earth which all men occupy as equals. The airman's earth, if free men make it, will be truly round: a globe in practice, not in theory.</p>

        <p>Science cuts two ways, of course; its products can be used for both good and evil. But there's no turning back from science. The early warnings about technological dangers also come from science.</p>

        <p>What was most significant about the lunar voyage was not that man set foot on the Moon but that they set eye on the earth.</p>

        <p>A Chinese tale tells of some men sent to harm a young girl who, upon seeing her beauty, become her protectors rather than her violators. That's how I felt seeing the Earth for the first time. I could not help but love and cherish her.</p>

        <p>For those who have seen the Earth from space, and for the hundreds and perhaps thousands more who will, the experience most certainly changes your perspective. The things that we share in our world are far more valuable than those which divide us.</p>

        <h2 class="section-heading">The Final Frontier</h2>

        <p>There can be no thought of finishing for ‘aiming for the stars.’ Both figuratively and literally, it is a task to occupy the generations. And no matter how much progress one makes, there is always the thrill of just beginning.</p>

        <p>There can be no thought of finishing for ‘aiming for the stars.’ Both figuratively and literally, it is a task to occupy the generations. And no matter how much progress one makes, there is always the thrill of just beginning.</p>

        <blockquote class="blockquote">The dreams of yesterday are the hopes of today and the reality of tomorrow. Science has not yet mastered prophecy. We predict too much for the next year and yet far too little for the next ten.</blockquote>

        <p>Spaceflights cannot be stopped. This is not the work of any one man or even a group of men. It is a historical process which mankind is carrying out in accordance with the natural laws of human development.</p>

        <h2 class="section-heading">Reaching for the Stars</h2>

        <p>As we got further and further away, it [the Earth] diminished in size. Finally it shrank to the size of a marble, the most beautiful you can imagine. That beautiful, warm, living object looked so fragile, so delicate, that if you touched it with a finger it would crumble and fall apart. Seeing this has to change a man.</p>

        <a href="#">
          <img class="img-fluid" src="img/post-sample-image.jpg" alt="">
        </a>
        <span class="caption text-muted">To go places and do things that have never been done before – that’s what living is all about.</span>

        <p>Space, the final frontier. These are the voyages of the Starship Enterprise. Its five-year mission: to explore strange new worlds, to seek out new life and new civilizations, to boldly go where no man has gone before.</p>

        <p>As I stand out here in the wonders of the unknown at Hadley, I sort of realize there’s a fundamental truth to our nature, Man must explore, and this is exploration at its greatest.</p>

        <p>Placeholder text by
          <a href="http://spaceipsum.com/">Space Ipsum</a>. Photographs by
          <a href="https://www.flickr.com/photos/nasacommons/">NASA on The Commons</a>.</p>
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
