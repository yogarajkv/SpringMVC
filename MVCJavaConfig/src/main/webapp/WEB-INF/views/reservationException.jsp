<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exception handler</title>
</head>
<body>
	Exception occurred ${exception.errorMessage} : ${exception.timeStamp}
	<a href="/practiceOnlyJava/reservationQuery">back to home</a>
</body>
</html>