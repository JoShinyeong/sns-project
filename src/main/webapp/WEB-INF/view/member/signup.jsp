<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/css/reset.css"/>" rel="stylesheet"
	type="text/css" />
<link href="<c:url value="/resources/css/signup.css"/>" rel="stylesheet"
	type="text/css" />
<script src="<c:url value="/resources/js/jquery.1.12.4.js" />"
	type="text/javascript"></script>
<title>회원가입</title>
</head>
<body>
	<form action='<c:url value="/member/signup"/>' method="POST">

		<div class="form form--signup framed">
			<input type="email" id="email" name="email"  placeholder="Email" class="input input--top" />
			<input type="password" id="password" name="password" placeholder="Password" class="input" /> 
			<input
				type="password" placeholder="Password"  id="password2" name="password2"class="input" />
				 <input type="text" placeholder="Username"  id="name" name="name" class="input" />
				 <input
				type="submit" value="Sign up" class="input input--submit" /> <label
				for="toggle--login" class="text text--small text--centered">Not
				new? <b>Log in</b>
			</label>
		</div>
	</form>
</body>
<script>
function myFunction() {
	  var x = document.getElementById("Demo");
	  if (x.className.indexOf("w3-show") == -1) {
	    x.className += " w3-show";
	  } else { 
	    x.className = x.className.replace(" w3-show", "");
	  }
	}	
//아이디 유효성 검사(1 = 중복 / 0 != 중복)
	$("#email").blur(function() {
		// id = "id_reg" / name = "userId"
		var user_id = $('#email').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/member/idCheck?userId='+ email,
			type : 'get',
			success : function(data) {
				console.log("1 = 중복o / 0 = 중복x : "+ data);							
				
				if (data == 1) {
						// 1 : 아이디가 중복되는 문구
						$("#id_check").text("사용중인 아이디입니다 :p");
						$("#id_check").css("color", "red");
						$("#reg_submit").attr("disabled", true);
					} else {
						
						if(idJ.test(user_id)){
							// 0 : 아이디 길이 / 문자열 검사
							$("#id_check").text("");
							$("#reg_submit").attr("disabled", false);
				
						} else if(user_id == ""){
							
							$('#id_check').text('아이디를 입력해주세요 :)');
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);				
							
						} else {
							
							$('#id_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
							$('#id_check').css('color', 'red');
							$("#reg_submit").attr("disabled", true);
						}
						
					}
				}, error : function() {
						console.log("실패");
				}
			});
		});



</script>
</html>