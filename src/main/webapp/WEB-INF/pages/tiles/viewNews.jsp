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
<fmt:message bundle="${loc}" key="baselocal.menu.news.date" var="news_date" />
<fmt:message bundle="${loc}" key="baselocal.button.news.delete" var="news_delete" />
<fmt:message bundle="${loc}" key="baselocal.button.news.edit" var="news_edit" />
<fmt:message bundle="${loc}" key="baselocal.button.news.delete.warning" var="news_warning" />







<script type="text/javascript">
	function checkDelete() {
	    if (confirm(" ${news_warning} ")) {
	        return true;
	    } else {
	        return false;
	    }
	}
</script>


<!--   <div class="body-title">
	<a href="">News >> </a> View News
</div>
     -->


<div class="add-table-margin">
	<table class="news_text_format">
		<tr>
			<td class="space_around_title_text">${news_title} </td>

			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.title }" />
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
					<c:out value="${requestScope.news.briefNews }" />
				</div></td>
		</tr>
		<tr>
			<td class="space_around_title_text">${news_content}</td>
			<td class="space_around_view_text"><div class="word-breaker">
					<c:out value="${requestScope.news.content }" />
				</div></td>
		</tr>
	</table>
</div>


<c:if test="${sessionScope.role eq 'admin'}">
<div class="first-view-button">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="go_to_edit_news" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="${news_edit}" />
	</form>
</div>

<div class="second-view-button">
	<form action="controller" method="post" onsubmit="return checkDelete()">
		<input type="hidden" name="command" value="do_delete_news" /> <input
			type="hidden" name="id" value="${news.idNews}" /> <input
			type="submit" value="${news_delete}" />
	</form>
</div>
</c:if>