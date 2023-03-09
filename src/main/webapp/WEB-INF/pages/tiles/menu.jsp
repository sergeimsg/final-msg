<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.menu.start" var="menu_start"  />
<fmt:message bundle="${loc}" key="baselocal.menu.news.list" var="menu_list_news"  />
<fmt:message bundle="${loc}" key="baselocal.menu.news.add" var="menu_add_news"  />



<div class="menu-wrapper">
	<div class="menu-title-wrapper">
		<div class="menu-title">
		       <h3> ${menu_start} </h3>
		</div>
	</div>

	<div class="list-menu-invisible-wrapper">
		<div class="list-menu-wrapper" style="float: left;">
			<ul style="list-style-image: url(images/img.jpg); text-align: left;">
				<li style="padding-left: 15px;">
				
				<a href="controller?command=go_to_news_list">${menu_list_news}</a><br />
				</li>

				<c:if test="${sessionScope.role eq 'admin'}">
				   <li style="padding-left: 15px;">
				
				    <a href="controller?command=go_to_add_news"> ${menu_add_news} </a>
                
                   <br />
					
				</li></c:if>
			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<!--  grey free space at the bottom of menu -->
	<div style="height: 25px;"></div>
</div>

