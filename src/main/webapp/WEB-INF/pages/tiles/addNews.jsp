<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->
<fmt:message bundle="${loc}" key="baselocal.menu.news.add" var="add_news" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.title" var="news_title" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.brief" var="news_brief" />
<fmt:message bundle="${loc}" key="baselocal.menu.news.content" var="news_content" />



<div class="body-title">
	<h2>
		<c:out value="${add_news}" />
	</h2>
	<br>
	<hr>
</div>

<div class="add-table-margin" align="left">
	<form action="controller" method="post">
		<input type="hidden" name="command" value="do_add_news" />
		<table class="news_text_format">
			<tr>
				<td class="space_around_title_text">${news_title}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="title" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${news_brief}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<input type="text" name="briefNews" />
					</div>
				</td>
			</tr>
			<tr>
				<td class="space_around_title_text">${news_content}</td>
				<td class="space_around_view_text">
					<div class="word-breaker">
						<textarea rows="30" cols="50" name="content"></textarea>
					</div>
				</td>
			</tr>
		</table>
		
		<c:if test="${sessionScope.role eq 'admin'}">
			<div class="first-view-button">
				<input type="submit" value="${add_news}" />
			</div>
		</c:if>
	</form>
</div>
