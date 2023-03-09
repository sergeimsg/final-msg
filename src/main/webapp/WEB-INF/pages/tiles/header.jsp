<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.locbutton.name.en" var="en_button"  />
<fmt:message bundle="${loc}" key="baselocal.locbutton.name.ru" var="ru_button" />
<fmt:message bundle="${loc}" key="baselocal.enter.login" var="enter_login" />
<fmt:message bundle="${loc}" key="baselocal.enter.password" var="enter_password" />
<fmt:message bundle="${loc}" key="baselocal.registration.link" var="registration_link" />
<fmt:message bundle="${loc}" key="baselocal.site.naming" var="site_naming" />
<fmt:message bundle="${loc}" key="baselocal.signin.button" var="sign_in" />
<fmt:message bundle="${loc}" key="baselocal.signout.button" var="sign_out" />
<fmt:message bundle="${loc}" key="baselocal.greeting" var="greeting" />



	<div class="wrapper">
		<div class="newstitle">
		<a class="icon" href="controller?command=go_to_base_page" target="_blank"> 
		<img src="images/Twitter.svg" alt="site logo" width="20" height="20" border="0"> 
		</a>  
  		
  		
  		<font color="blue"> 
		<c:out value="${site_naming}"> 	</c:out>
		</font>
		
	 

	 
	</div>


	<div class="local-link">

		<div align="right">

			<a href="controller?link_locale=en&command=change_locale&link=${sessionScope.link}">
			<!-- <a href="controller?local=en&command=set_new_local&link=${sessionScope.link} -->
			
			 <c:out value="${en_button}"></c:out> </a> &nbsp;&nbsp; 
			<a	href="controller?link_locale=ru&command=change_locale&link=${sessionScope.link}"> 
			<c:out value="${ru_button}"></c:out> </a> <br /> <br />
		</div>

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" /> 
					<c:out value="${enter_login}"></c:out>
					 <input type="text" name="login" value="" placeholder="your login"/><br /> 
					<c:out value="${enter_password}"></c:out>
					 <input type="password" name="password" value="" placeholder="your password"/><br />
					   

					<c:if test="${not (requestScope.AuthenticationError eq null)}">
						<font color="red"> 
						   <c:out value="${requestScope.AuthenticationError}" />
						</font> 
					</c:if>
					
					<a href="controller?command=go_to_registration_page_command"> ${registration_link}</a>  
					 <input type="submit" value="${sign_in}" /><br />
				</form>
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="${sign_out}" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
