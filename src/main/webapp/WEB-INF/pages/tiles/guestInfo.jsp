<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.news.link" var="news_link"  />
<fmt:message bundle="${loc}" key="baselocal.latest.knews" var="latest_news"  />
<fmt:message bundle="${loc}" key="baselocal.message.for.guests" var="message_guests"  />
<fmt:message bundle="${loc}" key="baselocal.no.knews" var="no_news"  />

<h3> <font color="orange"> ${message_guests} </font> </h3>

<div class="body-title">
	<!-- <a href="">${news_link} >> </a>  -->
	<h4>${latest_news}</h4> 
</div>
<hr>
<form action="command.do?method=delete" method="post">
	<c:forEach var="news" items="${requestScope.news}">
		<div class="single-news-wrapper">
			<div class="single-news-header-wrapper">
				<div class="news-title">
					<c:out value="${news.title}" />
				</div>
				<div class="news-date">
					<c:out value="${news.newsDate}" />
				</div>

				<div class="news-content">
					<c:out value="${news.briefNews}" />
				</div>
			</div>
		</div>

	</c:forEach>

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
		
        <h4>${no_news}</h4> 
	
	</c:if>
	</div> 

</form>
