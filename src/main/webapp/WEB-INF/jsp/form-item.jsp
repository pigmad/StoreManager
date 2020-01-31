<%@ include file="/WEB-INF/jsp/header.jsp" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
                            <a class="navbar-brand">Navigation</a>
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
                <p>Nous sommes le <c:out value="${date}"/>, il est <c:out value="${time}"/>. </p>
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <div class="panel-title">${message}</div>
                    </div>
                    <div class="panel-body">
                        <form:form action="saveItem" cssClass="form-horizontal" method="post" modelAttribute="item">
                            <!-- need to associate this data with item id -->
                            <form:hidden path="idItem" />
                            <form:hidden path="shelf.idShelf" value="${shelf.idShelf}" />

                            <div class="form-group">
                                <label for="name" class="col-md-3 control-label">Nom</label>
                                <div class="col-md-9">
                                    <form:input path="name" type="text" required="required" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="price" class="col-md-3 control-label">Prix</label>
                                <div class="col-md-9">
                                    <form:input path="price" type="number" min="0.01" step="0.01" required="required" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="quantity" class="col-md-3 control-label">Quantité</label>
                                <div class="col-md-9">
                                    <form:input path="quantity" type="number" min="1" max="999" required="required" cssClass="form-control" />
                                </div>
                            </div>

                            <div class="form-group">
                                <!-- Button -->
                                <div class="col-md-offset-3 col-md-9">
                                    <form:button cssClass="btn btn-default">Confirmer</form:button>
                                    </div>
                                </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
