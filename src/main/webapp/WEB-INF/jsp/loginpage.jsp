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
		<div class="col-md-offset-3 col-md-7">
			<h3 class="text-center"><fmt:message key="heading"/></h3>
                        <p>Nous sommes le <c:out value="${date}"/>, il est <c:out value="${time}"/>. </p>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Connexion</div>
				</div>
				<div class="panel-body">
					<form class="form-signin" action="login" method="post">
                                            <label for="inputMail" class="sr-only">Adresse mail</label>
                                            <input type="email" id="inputMail" name="inputMail" class="form-control" placeholder="Adresse mail" required autofocus>
                                            <label for="inputPassword" class="sr-only">Mot de passe</label>
                                            <input type="password" id="inputPassword" name="inputPassword" class="form-control mb-5" placeholder="Mot de passe" required>
                                            <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
                                        </form>
				</div>
			</div>
		</div>
	</div>
                    
    </body>
</html>