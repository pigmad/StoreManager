<%@ include file="/WEB-INF/jsp/header.jsp" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entity.Director" %>
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
            <div class="col-md-12">
                <h3 class="text-center"><fmt:message key="heading"/></h3>
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="">Navigation</a>
                        </div>
                        <ul class="nav navbar-nav">
                            <li><a href="/home">Accueil</a></li>
                                <c:if test="${user.getClass() == 'class entity.Director'}">
                                <li><a href="/sellers/list">Administration</a></li>
                                </c:if>
                            <li><a href="/stores/list">Magasins</a></li>
                            <li><a href="/shelves/list">Rayons</a></li>
                            <li><a href="/logout">Se déconnecter</a></li>
                        </ul>
                    </div>
                </nav>      
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">Accueil</div>
                    </div>
                    <div class="panel-body">
                        <div class="col-md-offset-3 col-md-6">
                            <p>Nous sommes le <c:out value="${date}"/>, il est <c:out value="${time}"/>. </p>
                            <p>Vous etes connecté au système via le login <c:out value="${user.mail}"/>. </p>
                            <p>Bonjour <c:out value="${user.lastName}"/> <c:out value="${user.firstName}"/>.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>