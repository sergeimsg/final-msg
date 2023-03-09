<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.latest.knews" var="latest_news"  />
<fmt:message bundle="${loc}" key="baselocal.news.admin.link" var="admin_link"  />
<fmt:message bundle="${loc}" key="baselocal.news.user.link" var="user_link"  />
<fmt:message bundle="${loc}" key="baselocal.all.knews" var="all_news"  />
<fmt:message bundle="${loc}" key="baselocal.no.knews" var="no_news"  />





<div class="body-title">
	
		<h4>${all_news}</h4> 
</div>

<form action="" method="post">
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
				<div class="news-link-to-wrapper">
					<div class="link-position">
						<c:if test="${sessionScope.role eq 'admin'}">
						
						<a href="controller?command=go_to_view_news&id=${news.idNews}">
						
						<font color="green">${admin_link} </font> </a>
						 
												      
						</c:if>
						
						<c:if test="${sessionScope.role eq 'user'}">
						
						<a href="controller?command=go_to_view_news&id=${news.idNews}">
						
						<font color="green">${user_link} </font> </a> 
						
						</c:if>
																						
   					    
   					    <c:if test="${sessionScope.role eq 'admin'}">
   					    
   	<!-- check box for admin <input type="checkbox" name="idNews" value="${news.idNews }" /> -->   
   					         
   					    </c:if>
					</div>
				</div>



			</div>
		</div>

	</c:forEach>

	<!-- 	<logic:notEmpty name="newsForm" property="newsList">
		<div class="delete-button-position">
			<html:submit>
				<bean:message key="locale.newslink.deletebutton" />
			</html:submit>
		</div>
	</logic:notEmpty> -->

	<div class="no-news">
		<c:if test="${requestScope.news eq null}">
		
		        <h4>${no_news}</h4> 
	</c:if>
	</div>
</form>
