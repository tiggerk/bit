<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL(Expression Language) 표기법</title>
</head>
<body>
<h1>EL(Expression Language) 표기법</h1>
<%--
${객체명.프로퍼티} 또는 ${객체명["프로퍼티"]}

예) ${member.no} 또는 ${member["no"]}
자바코드=>
Member member = (Member)pageContext.findAttribute("member");
member.getNo();

findAttribute() 메서드가 객체를 찾는 순서:
JspContext => ServletRequest => HttpSession => ServletContext => null

보관소(검색범위) 지정:
pageScope => JspContext
requestScope => ServletRequest
sessionScope => HttpSession
applicationScope => ServletContext
예) 
${pageScope.member.no} => pageContext.getAttribute("member).getNo()
${requestScope.member.no} => request.getAttribute("member").getNo()
${sessionScope.member.no} => session.getAttribute("member").getNo()
${applicationScope.member.no} => application.getAttribute("member").getNo()
 --%>
 
 <h1>JSP 기본 객체(Built-in 객체)</h1>
 <p>JSP가 서블릿 클래스를 만들 때 _jspService() 메서드에
 기본으로 준비하는 객체</p>
 <ul>
  <li>JspWriter out = ...;</li>
  <li>ServletContext application = ...;</li>
  <li>HttpSession session = ...;</li>
  <li>HttpServletRequest request 파라미터</li>
  <li>HttpServletResponse response 파라미터</li>
  <li>PageContext pageContext = ...;</li>
  <li>Object page = this;</li>
  <li>ServletConfig config = ...;</li>
  <li>Exception error = ...; (오류를 처리하는 JSP인 경우에만)</li>
 </ul>
 
 <h1>EL 객체 정리</h1>
 <%-- ${객체.프로퍼티} 
 객체명            : 설명               : 사용예
 pageContext      : 생략               : ${pageContext.객체}
 pageScope          pageContext.getAttribute() => ${pageScope.객체{
 servletContext   : ServletContext    : ${pageContext.servletContext.객체}
 applicationScope   servletContext.getAttribute() => ${applicationScope.객체}
 session          : HttpSession       : ${pageContext.session.객체}
 sessionScope       session.getAttribute() => ${sessionScope.객체}
 request          : ServletRequest    : ${pageContext.request.객체}
 requestScope                         => ${requestScope.객체}
 response         : ServletResponse   : ${pageContext.response.객체}
 param            : getParameter(이름) : ${param.이름}
 header           : getHeader(헤더명)  : ${header.헤더명}
 cookie           : getCookies() ...  : ${cookie.쿠키명}
 initParam        : getInitParameter(): ${initParam.이름}
 
 
 --%>

 
 <p>
 out:JspWriter<br>
 application
 </p>
</body>
</html>