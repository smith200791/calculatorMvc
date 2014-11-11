<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
</head>
<body>
	<h2>
		<spring:message code="validation.calc.arg.fail" />
	</h2>
	
	
	
	<c:if test="${!empty errors}">
		<table class="data">
			
			<c:forEach items="${errors}" var="error">
				<tr>
				
					<td>ЕГГОГ = ${error}</td>
					
								
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	
	<a href="<c:url value="/index" />"> <spring:message
			code="label.return" />
	</a>
</body>
</html>