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
                        <div class="panel-title">Liste des vendeurs</div>
                    </div>
                    <div class="panel-body">
                        <link href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" rel="stylesheet"/>
                        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
                        <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
                        <div class="col-md-push-1 col-md-10">
                            <table id="sellersTable" class="table table-striped table-bordered post-list-table">
                                <thead>                      
                                    <tr>
                                        <th>Nom</th>
                                        <th>Magasin</th>
                                        <th>Nom  de rayon</th>
                                        <th>Chef de rayon</th>
                                        <th>Mail</th>
                                        <th>Options</th>
                                    </tr>
                                </thead>
                                <tbody> 
                                    <!-- loop and print all stores -->
                                    <c:forEach var="seller" items="${sellers}">

                                        <!-- construct an "update" link with customer id -->
                                        <c:url var="updateLink" value="/sellers/updateForm">
                                            <c:param name="idSeller" value="${seller.idSeller}" />
                                        </c:url>

                                        <!-- construct an "delete" link with customer id -->
                                        <c:url var="deleteLink" value="/sellers/delete">
                                            <c:param name="idSeller" value="${seller.idSeller}" />
                                        </c:url>

                                        <c:url var="shelfLink" value="/shelves/shelf">
                                            <c:param name="idShelf" value="${seller.belongsTo.idShelf}" />
                                        </c:url>

                                        <tr>
                                            <td>${seller.lastName} ${seller.firstName}</td>
                                            <td>${seller.store.city}</td>
                                            <td><a href="${shelfLink}">${seller.belongsTo.name}</a></td>
                                            <td>
                                                <c:if test="${seller.isAdmin}">
                                                    Oui
                                                </c:if> 
                                                <c:if test="${!seller.isAdmin}">
                                                    Non
                                                </c:if>     
                                            </td>
                                            <td>${seller.mail}</td>

                                            <td>
                                                <!-- display the update link --> 
                                                <a href="${updateLink}" class="btn btn-default">Modifier</a>
                                                <a href="${deleteLink}" class="btn btn-default" onclick="if (!(confirm('Etes-vous sur de vouloir supprimer ce vendeur ?')))
                                                            return false">Supprimer</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                                <div class="btn-group mr-2" role="group" aria-label="First group">
                                    <a href="/sellers/addForm" class="btn btn-default">Ajouter vendeur</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script>
            $('#sellersTable').DataTable({
                "columnDefs": [{"orderable": false, "targets": 5}],
                "language": {
                    "sEmptyTable": "Aucune donnée disponible dans le tableau",
                    "sInfo": "Affichage de l'élément _START_ à _END_ sur _TOTAL_ éléments",
                    "sInfoEmpty": "Affichage de l'élément 0 à 0 sur 0 élément",
                    "sInfoFiltered": "(filtré à partir de _MAX_ éléments au total)",
                    "sInfoPostFix": "",
                    "sInfoThousands": ",",
                    "sLengthMenu": "Afficher _MENU_ éléments",
                    "sLoadingRecords": "Chargement...",
                    "sProcessing": "Traitement...",
                    "sSearch": "Rechercher :",
                    "sZeroRecords": "Aucun élément correspondant trouvé",
                    "oPaginate": {
                        "sFirst": "Premier",
                        "sLast": "Dernier",
                        "sNext": "Suivant",
                        "sPrevious": "Précédent"
                    },
                    "oAria": {
                        "sSortAscending": ": activer pour trier la colonne par ordre croissant",
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
