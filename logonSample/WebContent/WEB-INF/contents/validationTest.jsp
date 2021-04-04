<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/tags/struts-html" prefix="html" %>
 <%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html>
<html:javascript formName="ValidateTestForm"/>
<html>
	<html:errors/>
	<br>
	<html:form action="/validation" onsubmit="validateValidateTestForm">
		<bean:message key="form.user"/>
		<html:text property="user"/>
		<br>
		<bean:message key="form.email"/>
		<html:text property="email"/>
		<br>
		<bean:message key="form.phoneNumber"/>
		<html:text property="phoneNumber"/>
		<br>
		<html:submit><bean:message key="button.confirm"/></html:submit>
	</html:form>
</html>