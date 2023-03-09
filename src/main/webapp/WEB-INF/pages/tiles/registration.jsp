<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:message bundle="${loc}" key="baselocal.enter.login" var="enter_login"  />
<fmt:message bundle="${loc}" key="baselocal.enter.password" var="enter_password"  />
<fmt:message bundle="${loc}" key="baselocal.enter.email" var="enter_email"  />
<fmt:message bundle="${loc}" key="baselocal.send.button" var="send_button"  />
<fmt:message bundle="${loc}" key="baselocal.back.to.main.page" var="back_to_m_page"  />





	<form action="controller" method="post">
	
	<input type="hidden" name="command" value="do_registration"/>
	
	<c:out value="${enter_login}" />
		<br /> 
	    <input type="text" name="login" value="" placeholder="your login" />
	    		
		<br />
		<c:out value="${enter_password}" />
		<br /> 
		<input type="password" name="password" value="" placeholder="your password"/>
		
		<br /> 
		<c:out value="${enter_email}"/>
		<br /> 
		
		<input type="email" name="email"  value="" placeholder="name@example.com"  />
		
		<br />
		<br />  
		
		<input type="submit" value="${send_button}" />
		<br />
		<br />  
		
		
		
		<a href="controller?command=go_to_base_page"> <font color="green"> 
		<c:out value="${back_to_m_page}"/> 
		</font>
		</a>  
				
		
		
	
	</form>


