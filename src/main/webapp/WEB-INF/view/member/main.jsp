<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>main</title>


<link href="<c:url value="/resources/css/reset.css"/>" rel="stylesheet" type="text/css" />
 <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet" type="text/css" />
    <script src="<c:url value="/resources/js/jquery.1.12.4.js" />" type="text/javascript"></script>
<%--   <script src="<c:url value="/resources/jquery.bxslider/jquery.bxslider.js"/>"></script> --%>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/bxslider/4.2.12/jquery.bxslider.min.js"></script>
 <link href="<c:url value="/resources/plugins/web-fonts-with-css/css/all.css"/>"rel="stylesheet" type="text/css"/>

<script>
        $(document).ready(function() {
            $('.slider').bxSlider({
                controls: false,
                pager: false,
                auto: true
            });
        });
    </script>

</head>
<body>
    <div class="overlay"></div>
    <div class="slider">
        <div class="background__01"></div>
        <div class="background__02"></div>
        <div class="background__03"></div>
    </div>
<form class="form form--login framed">
    <input type="email" placeholder="Email" id="email" name="email" class="input input--top" />
    <input type="password" placeholder="Password" id="password" name="password"  class="input" />
    <input type="submit" value="Log in" class="input input--submit" onclick= "location.href=
    <c:url value='/board/list/${member.email}'/>">
    
    <a class="text text--small text--centered"  href =<c:url value="/member/signup"/>>New? <b>Sign up</b></a>
  </form>
  
 
</body>
</html>