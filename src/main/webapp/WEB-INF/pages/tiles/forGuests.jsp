<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${requestScope.presentation eq 'registration'}">

	<c:import url="/WEB-INF/pages/tiles/registration.jsp" />
	
</c:if>

<c:if test="${requestScope.presentation eq 'errorPage'}">

	<c:import url="/WEB-INF/pages/tiles/error.jsp" />
	
</c:if>

<c:if test="${requestScope.presentation eq 'forGuests'}">


	<c:import url="/WEB-INF/pages/tiles/guestInfo.jsp" />
	
</c:if>