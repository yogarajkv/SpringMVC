<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add reservation</title>
</head>
<body>
	<form:form method="post" modelAttribute="reservation">
		<table border="1">
			<tr>
				<td>Court Name</td>
				<td><form:input path="courtName" /></td>
			</tr>
			<tr>
				<td>Date</td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td>Hour</td>
				<td><form:input path="hour" /></td>
			</tr>
			<tr>
				<td>Player Name</td>
				<td><form:input path="player.name" /></td>
			</tr>
			<tr>
				<td>PhoneNo</td>
				<td><form:input path="player.phno" /></td>
			</tr>
			<tr>
				<td>Sports Type</td>
				<td><form:select path="sport" items="${sportTypes}" itemValue="id" itemLabel="name"></form:select></td>
			</tr>
			<tr>
				<td colspan="3"><input type="submit"></td>
			</tr>

		</table>
	</form:form>

</body>
</html>