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
                        <div class="panel-title">Vendeur n°${seller.idSeller}</div>
                    </div>
                    <div class="col-md-push-1 col-md-10">
                        <table class="table  table-bordered">
                            <tr>
                                <th>Id Vendeur</th>
                                <th>Nom</th>
                                <th>Prénom</th>
                                <th>Nom de rayon</th>
                                <th>Chef de rayon</th>
                                <th>Mail</th>
                                <th>Mot de passe</th>
                            </tr>

                            <tr>
                                <td>${seller.idSeller}</td>
                                <td>${seller.lastName}</td>
                                <td>${seller.firstName}</td>
                                <td>${seller.belongsTo.name}</td>
                                <td>${seller.isAdmin}</td>
                                <td>${seller.mail}</td>
                                <td>${seller.password}</td>
                            </tr>
                        </table>
                        <!-- construct an "update" link with item id -->
                        <c:url var="updateLink" value="/sellers/updateForm">
                            <c:param name="idSeller" value="${seller.idSeller}" />
                        </c:url>

                        <!-- construct an "delete" link with item id -->
                        <c:url var="deleteLink" value="/sellers/delete">
                            <c:param name="idSeller" value="${seller.idSeller}" />
                        </c:url>
                        <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                            <div class="btn-group mr-2" role="group" aria-label="First group">
                                <a href="${updateLink}" class="btn btn-default">Modifier</a>
                                <a href="${deleteLink}" class="btn btn-default" onclick="if (!(confirm('Etes-vous sur de vouloir supprimer ce vendeur ?')))
                                            return false">Supprimer</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
