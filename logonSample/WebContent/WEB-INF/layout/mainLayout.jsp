<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title"/></title>
</head>
<body>
<div style="text-align: center;">
<table>
	<tr> <td colspan="2">
	<tiles:insert attribute="header"/>
	</td>  </tr>
	<tr>
		<td>
			<tiles:insert attribute="menu"/>
		</td>
		<td>
			<tiles:insert attribute="body"/>
		</td>
	</tr>
	<tr><td colspan="2">
		<tiles:insert attribute="footer"/>
	</td> </tr>
</table>
</div>
</body>
</html>