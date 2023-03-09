<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- localization -->
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="localization.local" var="loc" />
<!-- localization -->

<fmt:setLocale value="${sessionScope.locale}"/>    
 
<center>

<jsp:useBean id="now" class="java.util.Date"></jsp:useBean>  
   
<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="long"/>
 
<a class="icon" href="https://www.facebook.com/" target="_blank"> 
<img src="images/Facebook.svg" alt="Facebook" width="20" height="20" border="0"> </a>  
<a class="icon" href="https://twitter.com/" target="_blank"> 
<img alt="Twitter" src="images/Twitter.svg" width="20" height="20" border="0" > </a> 
 <a class="icon" href="https://www.instagram.com/" target="_blank">
  <img alt="Instagram" src="images/Instagram.svg" width="20" height="20" border="0"> </a> 
  <a class="icon" href="https://www.youtube.com/" target="_blank">
   <img alt="Youtube" src="images/Youtube.svg" width="20" height="20" border="0"></a>
   
 
 </center>

