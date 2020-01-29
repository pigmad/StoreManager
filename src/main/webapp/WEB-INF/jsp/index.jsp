<%@ include file="/WEB-INF/jsp/header.jsp" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title><fmt:message key="title"/></title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    </head>
    <body>
        <div class="container">            
		<div class="col-md-offset-4 col-md-4">
			<h3 class="text-center"><fmt:message key="heading"/></h3>
                        <p>Nous sommes le <c:out value="${date}"/>, il est <c:out value="${time}"/>. </p>
                        <button class="btn btn-sm btn-secondary btn-block" onClick="JavaScript:window.location='/StoreManager/login';">Se connecter</button>                               
		</div>
	</div>
                    
    </body>
</html>