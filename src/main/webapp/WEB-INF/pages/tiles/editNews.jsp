<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.menu.news.title" var="news_title" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.brief" var="news_brief" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.content" var="news_content" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.date" var="news_date" />
<fmt:message bundle="${loc}" key="baselocal.button.news.delete" var="news_delete" />
<fmt:message bundle="${loc}" key="baselocal.button.news.save" var="news_save" />
<fmt:message bundle="${loc}" key="baselocal.edit.knews" var="edit_news" />




<div class="body-title">

<h1>  ${edit_news} </h1>	
</div>

<div class="add-table-margin">
  <form action="controller" method="post">
		<input type="hidden" name="command" value="do_edit_news" /> 
		<input 	type="hidden" name="id" value="${news.idNews}" /> 


	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">${news_title}</td>

			<td class="space_around_view_text"><div class="word-breaker">
					
					<input type="text" name="title"  value="${requestScope.news.title}" />
					
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_date}</td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.newsDate }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_brief}</td>
			<td class="space_around_view_text"><div class="word-breaker">
					<input type="text" name="briefNews"  value="${requestScope.news.briefNews}" />
					
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_content}</td>
			<td class="space_around_view_text"><div class="word-breaker">
			
			<textarea rows="25" cols="30" name="content">${requestScope.news.content } </textarea>
									
					
				</div></td>
		</tr>
	</table>



<c:if test="${sessionScope.role eq 'admin'}">

<div class="first-view-button">
	
		<input type="submit" value="${news_save}" />
		
				
	</div>	
	</c:if>
	
	
	</form>

</div>

