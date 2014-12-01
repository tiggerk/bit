<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 꺼내기2</title>
</head>
<body>
<H1>쿠키 꺼내기</H1>
<%
// 쿠키 꺼내기
// => 특정 쿠키만 꺼내는 방법은 없음. 어쩔 수 없이 반복문 돌려 쿠키 꺼내야함.
// 클라이언트에서 서버에 쿠키를 보낼 때 응답 헤더에 포함해서 보낸다.
/*
Cookie: name=aaa; tel=111-1111; email="hong@test.com"; address=%EA%B0%95%EB%82%A8%EA%B5%AC; JSESSIONID=0257F35971FA86371B11260BDFD341FE
*/
Cookie[] cookies = request.getCookies();
if (cookies != null) {
  for (Cookie cookie : cookies) { %>
    <p><%=cookie.getName()%> : <%=URLDecoder.decode(cookie.getValue())%></p>
  <%}
}
%>
</body>
</html>