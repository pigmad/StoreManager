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
    <div class="col-md-offset-3 col-md-6">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">404 - Page not found</div>
            </div>
            <div class="panel-body">
                <div id="notfound">
                        <div class="notfound">
                                <div class="notfound-404">
                                        <h1>Oops!</h1>
                                </div>
                                <p>La page que vous avez demandé n'est pas disponible.</p>
                                <a href="/StoreManager/">Retour accueil</a>
                        </div>
                </div>
            </div>
        </div>
    </div>    
</body>
</html>
