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
<body>
    <div class="overlay"></div>
    <div class="slider">
        <div class="background__01"></div>
        <div class="background__02"></div>
        <div class="background__03"></div>
    </div>
    <div class="contents">
        <p class="contents__name">Kim, Chul Su</p>
        <p class="contents__job">I'm Web programmar & Web Designer</p>
        <div class="contents__sns">
            <ul class="contents__list">
                <li>
                    <a href="http://facebook.com" target="_blank">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                </li>
                <li><a href="http://www.instagram.com" target="_blank">
                        <i class="fab fa-instagram"></i>
                    </a>
                </li>
                <li>
                    <a href="http://twitter.com" target="_blank">
                       <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fab fa-blogger"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</body>
</html>