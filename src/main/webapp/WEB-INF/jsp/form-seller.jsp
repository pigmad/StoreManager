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
                        <form:form action="saveSeller" cssClass="form-horizontal" method="post" modelAttribute="seller">
                            <!-- need to associate this data with seller id -->
                            <form:hidden path="idSeller" />
                            <form:hidden path="store.idStore" value="${user.store.idStore}"/>
                            
                            <div class="form-group">
                                <label for="belongsTo" class="col-md-3 control-label">Rayon</label>
                                <div class="col-md-9">
                                    <form:select path="belongsTo.idShelf" cssClass="form-control">
                                        <form:options items="${shelves}" itemValue="idShelf" itemLabel="name"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="isAdmin" class="col-md-3 control-label">Chef de rayon</label>
                                <div class="col-md-9">
                                    <form:select path="isAdmin" cssClass="form-control">
                                        <form:option value="false" label="non"/>
                                        <form:option value="true" label="oui"/>
                                    </form:select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="col-md-3 control-label">Nom</label>
                                <div class="col-md-9">
                                    <form:input id="lastName" path="lastName" type="text" placeholder="Nom" required="required" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="firstName" class="col-md-3 control-label">Prénom</label>
                                <div class="col-md-9">
                                    <form:input id="firstName" path="firstName" type="text" placeholder="Prénom" required="required" cssClass="form-control" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail" class="col-md-3 control-label">Mail</label>
                                <div class="col-md-9">
                                    <form:input id="mail" path="mail" type="email" placeholder="email@magasin.fr" required="required" cssClass="form-control" />
                                </div>
                            </div>
                            <script>
                                $("#lastName").keyup(function () {
                                    $("#mail").val($("#firstName").val() + "." + $("#lastName").val() + "@magasin.fr");
                                });
                                $("#firstName").keyup(function () {
                                    $("#mail").val($("#firstName").val() + "." + $("#lastName").val() + "@magasin.fr");
                                });
                            </script>
                            <div class="form-group">
                                <label for="password" class="col-md-3 control-label">Mot de Passe</label>
                                <div class="col-md-9">
                                    <form:input path="password" type="text" placeholder="mot de passe" required="required" cssClass="form-control" />
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
