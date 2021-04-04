<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/tags/struts-bean" prefix="bean" %>
 <%@ taglib uri="/tags/struts-html" prefix="html" %>
<!DOCTYPE html>
<html:html>
<head>
<meta charset="UTF-8">
<title><bean:message key="logon.title"/></title>
</head>
<body>
<h1><bean:message key="logon.title"/></h1>
<html:errors/>
	<html:form action="/logon">
		<bean:message key="form.user"/><html:text property="user"/>
		<br>
		<bean:message key="form.password"/><html:password property="password"/>
		<br>
		<html:submit property="submit">
		<bean:message key="button.confirm"/>
		</html:submit>
		<html:reset>リセット</html:reset>
	</html:form>
</body>
</html:html>