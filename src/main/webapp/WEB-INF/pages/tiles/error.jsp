<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.error.page.warning" var="error_warning"  />
<fmt:message bundle="${loc}" key="baselocal.error.page.following" var="error_following" />
<fmt:message bundle="${loc}" key="baselocal.error.page.following" var="error_following" />
<fmt:message bundle="${loc}" key="baselocal.error.after.message" var="after_message" />
<fmt:message bundle="${loc}" key="baselocal.repeat.registration.link" var="repeat_registration_link" />
<fmt:message bundle="${loc}" key="baselocal.back.to.main.page" var="back_to_m_page" />




<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h2 ><c:out value="${error_warning}" /></h2>
	<br>
	<hr>
	<br>
	<h4><c:out value="${error_following}" /></h4>
	<br>
	<h4>
		<font color="red"><c:out value="${sessionScope.error}" /></font>
	</h4>
	<br>
	<h4><c:out value="${after_message}" /></h4>
	<br>
	<br>
	<hr>
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_base_page" /> 
			
				<a href="controller?command=go_to_registration_page_command"> ${repeat_registration_link}</a>
			
	
		<br>
		<br>
	
		<a href="controller?command=go_to_base_page"> <font color="green"> 
		<c:out value="${back_to_m_page}"/> </font>	</a>
			
		</form>
	
	<c:if test="${sessionScope.user eq 'active'}">
		<form action="controller" method="post">
			<input type="hidden" name="command" value="go_to_news_list" /> 
			<input type="submit" value="${out_button }" />
		</form>
	</c:if>
</body>
</html>