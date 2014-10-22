<%@ page language="java" contentType="text/html; charset=utf8"
	pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title><spring:message code="label.title" /></title>
</head>
<body>

	<a href="<c:url value="/logout" />"> <spring:message
			code="label.logout" />
	</a>

	<h2>
		<spring:message code="label.title" />
	</h2>

	<form:form method="post" action="summ" modelAttribute="calcOperations" >

		<table>
			<tr>
				<td><form:label path="firstarg">
						<spring:message code="label.firstarg" />
					</form:label></td>
				<td><form:input path="firstarg" /></td>
			</tr>
			<tr>
				<td><form:label path="secondarg">
						<spring:message code="label.secondarg" />
					</form:label></td>
				<td><form:input path="secondarg" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.getresult"/>" /></td>
			</tr>
		</table>
	</form:form>

	<h3>
		<spring:message code="label.calculator" />
	</h3>
	<c:if test="${!empty calcOperationsList}">
		<table class="data">
			<tr>
				<th><spring:message code="label.result" /></th>
				<th><spring:message code="label.createdate" /></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${calcOperationsList}" var="calcOperations">
				<tr>
					<td>${calcOperations.result},${calcOperations.create_date}</td>
					<td><a href="delete/${calcOperations.objid}"><spring:message
								code="label.delete" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>