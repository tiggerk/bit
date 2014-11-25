<%@page import="java63.servlets.test05.domain.Product"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>값 꺼내기</title>
</head>
<body>
<h1>값 꺼내기</h1>
<h2>배열 값 꺼내기</h2>
<%
pageContext.setAttribute("scores", new int[]{100, 90, 80});
%>
<%=((int[])pageContext.getAttribute("scores"))[1]%><br>
${pageScope.scores[1]}<br>
${scores[2]}<br>
<hr>

<h2>리스트 값 꺼내기</h2>
<%
List<String> names = new ArrayList<String>();
names.add("홍길동");
names.add("임꺽정");
names.add("윤봉길");
names.add("안중근");
pageContext.setAttribute("names", names);
%>
<%=((List<String>)pageContext.getAttribute("names")).get(2)%><br>
${pageScope.names[1]}<br>
${names[2]}<br>
<hr>

<h2>맵에서 값 꺼내기</h2>
<%
Map<String,Integer> maps = new HashMap<String,Integer>();
maps.put("홍길동", 178);
maps.put("임꺽정", 180);
maps.put("이순신", 175);
maps.put("lee", 160);

pageContext.setAttribute("maps", maps);
%>
${pageScope.maps["홍길동"]}<br>
${maps["임꺽정"]}<br>
${maps.lee}<br>
<hr>

<h2>자바 일반 객체에서 값 꺼내기</h2>
<%
Product product = new Product();
product.setNo(10);
product.setName("아이폰");
product.setQuantity(200);
product.setMakerNo(2);

pageContext.setAttribute("product", product);
%>
${pageScope.product.no}<br>
${product.name}<br>
${product.quantity}<br>
${product.makerNo}<br>
<hr>

</body>
</html>