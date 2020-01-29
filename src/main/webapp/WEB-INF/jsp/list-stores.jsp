<%@ include file="/WEB-INF/jsp/header.jsp" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                                <li><a href="/StoreManager/home">Accueil</a></li>
                                <c:if test="${user.getClass() == 'class entity.Director'}">
                                  <li><a href="/StoreManager/sellers/list">Administration</a></li>
                                </c:if>
                                <li><a href="/StoreManager/stores/list">Magasins</a></li>
                                <li><a href="/StoreManager/shelves/list">Rayons</a></li>
                                <li><a href="/StoreManager/logout">Se déconnecter</a></li>
                            </ul>
                            </div>
                        </nav>   
                        <p>Nous sommes le <c:out value="${date}"/>, il est <c:out value="${time}"/>. </p>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Liste des magasins</div>
				</div>
                                <div class="panel-body">
                                        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet"/>
                                        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                                        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
                                        <div class="col-md-push-1 col-md-10">
                                            <table id="storesTable" class="table table-striped table-bordered post-list-table">
                                              <thead>                      
                                                <tr>
                                                    <th>Id magasin</th>
                                                    <th>Ville</th>
                                                    <th>Manager</th>
                                                    <th>Vendeurs</th>
                                                    <th>Rayons</th>
                                                </tr>
                                              </thead>
                                              <tbody> 
                                                    <!-- loop and print all stores -->
                                                    <c:forEach var="store" items="${stores}">

                                                        <!-- construct an "update" link with customer id -->
                                                        <c:url var="updateLink" value="/stores/updateForm">
                                                            <c:param name="idStore" value="${store.idStore}" />
                                                        </c:url>

                                                        <!-- construct an "delete" link with customer id -->
                                                        <c:url var="deleteLink" value="/stores/delete">
                                                            <c:param name="idStore" value="${store.idStore}" />
                                                        </c:url>

                                                        <tr>
                                                            <td>${store.idStore}</td>
                                                            <td>${store.city}</td>
                                                            <td>${store.director.lastName} ${store.director.firstName}</td>

                                                            <!-- Print the seller list of each store -->
                                                            <td>
                                                                <c:forEach var="seller" items="${sellers}">
                                                                    <c:if test="${seller.store.idStore == store.idStore}">
                                                                        <c:url var="sellerLink" value="/sellers/seller">
                                                                            <c:param name="idSeller" value="${seller.idSeller}" />
                                                                        </c:url>
                                                                        <a href="${sellerLink}">${seller.lastName} ${seller.firstName}</a><br/>
                                                                    </c:if>  
                                                                </c:forEach>
                                                            </td>

                                                            <!-- Print the shelf list of each store -->
                                                            <td>
                                                                <c:forEach var="shelf" items="${shelves}">
                                                                    <c:if test="${shelf.store.idStore == store.idStore}">
                                                                        <c:url var="shelfLink" value="/shelves/shelf">
                                                                            <c:param name="idShelf" value="${shelf.idShelf}" />
                                                                        </c:url>
                                                                        <a href="${shelfLink}">${shelf.name}</a><br/>
                                                                    </c:if>
                                                                </c:forEach>    
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
				</div>
			</div>
		</div>
	</div>
        <script>
            $('#storesTable').DataTable({
                "language":{
                    "sEmptyTable":     "Aucune donnée disponible dans le tableau",
                    "sInfo":           "Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments",
                    "sInfoEmpty":      "Affichage de l'élément 0 à 0 sur 0 élément",
                    "sInfoFiltered":   "(filtré à partir de _MAX_ éléments au total)",
                    "sInfoPostFix":    "",
                    "sInfoThousands":  ",",
                    "sLengthMenu":     "Afficher _MENU_ éléments",
                    "sLoadingRecords": "Chargement...",
                    "sProcessing":     "Traitement...",
                    "sSearch":         "Rechercher :",
                    "sZeroRecords":    "Aucun élément correspondant trouvé",
                    "oPaginate": {
                        "sFirst":    "Premier",
                        "sLast":     "Dernier",
                        "sNext":     "Suivant",
                        "sPrevious": "Précédent"
                    },
                    "oAria": {
                        "sSortAscending":  ": activer pour trier la colonne par ordre croissant",
                        "sSortDescending": ": activer pour trier la colonne par ordre décroissant"
                    },
                    "select": {
                            "rows": {
                                "_": "%d lignes sélectionnées",
                                "0": "Aucune ligne sélectionnée",
                                "1": "1 ligne sélectionnée"
                            } 
                    }
                }
            });
        </script>            
    </body>
</html>
