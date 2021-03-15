<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastrar titulo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #2c3e50">
			<div>
				<a href="#" class="navbar-brand"> Cadastro de Titulo </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listaTitulos" class="nav-link">Titulos</a></li>
			</ul>
		</nav>
	</header>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${titulo != null}">
					<form action="alterar" method="post">
				</c:if>
				<c:if test="${titulo == null}">

					<form action="cadastrar" method="post">
				</c:if>

				<caption>
					<h3>
						<c:if test="${titulo != null}"> Editar Titulo </c:if>
						<c:if test="${titulo == null}"> Cadastrar Titulo </c:if>
					</h3>
				</caption>

				<c:if test="${titulo != null}">
					<input type="hidden" name="id"
						value="<c:out value='${titulo.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Descrição</label> <input type="text"
						value="<c:out value='${titulo.descricao}' />" class="form-control"
						name="descricao" required="required">
				</fieldset>

				<fieldset class="form-group mt-4 mb-2">
					<select class="form-select" aria-label="Default select example" name="tipo">
						<option selected>Tipo</option>
						<option value="D">Titulo de Direito</option>
						<option value="O">Titulo de Obrigação</option>
					</select>
				</fieldset>

				<fieldset class="form-group mb-4">
					<label>Data de Vencimento</label> <input type="date"
						value="<c:out value='${titulo.dataVencimento}' />"
						class="form-control" name="dataVencimento">
				</fieldset>

				<fieldset class="form-group mb-2">
					<select class="form-select" aria-label="Default select example" name="status">
						<option selected>Status</option>
						<option value="A">Em aberto</option>
						<option value="Q">Quitado</option>
					</select>
				</fieldset>

				<fieldset class="form-group mb-2">
					<label>Valor</label> <input type="text"
						value="<c:out value='${titulo.valor}' />" class="form-control" name="valor">
				</fieldset>

				<button type="submit" class="btn btn-primary">Salvar</button>
				</form>
			</div>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

</body>
</html>