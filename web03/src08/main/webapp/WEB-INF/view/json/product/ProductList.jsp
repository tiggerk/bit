<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java"
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%
HashMap<String,Object> resultMap = new HashMap<>();
resultMap.put("currPageNo", request.getAttribute("currPageNo"));
resultMap.put("maxPageNo", request.getAttribute("maxPageNo"));
resultMap.put("products", request.getAttribute("products"));
%>

<%=new Gson().toJson(resultMap)%>