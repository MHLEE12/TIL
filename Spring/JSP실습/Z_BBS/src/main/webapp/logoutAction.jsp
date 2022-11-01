<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>JSP 게시판 웹 사이트 연습</title>
</head>
<body>
	<%
		session.invalidate(); // 부여받은 세션을 빼앗음
	%>
	<script>
		location.href = 'main.jsp';
	</script>
</body>
</html>