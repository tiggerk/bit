<%@page import="com.google.gson.Gson"%>
<%@ page language="java"
    contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty loginUser}">
	  <%=new Gson().toJson(session.getAttribute("loginUser"))%>
	</c:when>  
	<c:otherwise>
	  { "userId":"" }
	</c:otherwise>
</c:choose>
