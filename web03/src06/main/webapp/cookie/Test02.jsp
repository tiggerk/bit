<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쿠키 꺼내기</title>
</head>
<body>
<H1>쿠키 꺼내기</H1>
<%
// 쿠키 꺼내기
// => 특정 쿠키만 꺼내는 방법은 없음. 어쩔 수 없이 반복문 돌려 쿠키 꺼내야함.
Cookie[] cookies = request.getCookies();
if (cookies != null) {
  for (Cookie cookie : cookies) { %>
    <p><%=cookie.getName()%> : <%=URLDecoder.decode(cookie.getValue())%></p>
  <%}
}
%>
</body>
</html>