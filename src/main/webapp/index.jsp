<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controle de lançamentos de despesas</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #2c3e50">
			<div>
				<a href="/webapp" class="navbar-brand"> Controle Financeiro </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listarTitulos" class="nav-link">Visualizar titulos</a></li>
			</ul>
		</nav>
	</header>

	<br>
	
	 <div class="row">

                <div class="container">
                    <h3 class="text-center">Titulos - Obrigação / Direto</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/novo" class="btn btn-primary">Cadastrar</a>
                    </div>
                    <br>
                    
                    <table class="table table-bordered table-hover table-sm">
                        <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Data Vencimento</th>
                                <th scope="col">status</th>
                                <th scope="col">valor</th>
                                <th scope="col">ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="titulo" items="${listaTitulos}">

                                <tr>
                                    <td>
                                        <c:out value="${titulo.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${titulo.descricao}" />
                                    </td>
                                    <td>
                                        <c:out value="${titulo.tipo}" />
                                    </td>
                                    <td>
                                        <c:out value="${titulo.dataVencimento}" />
                                    </td>
                                    <td>
                                        <c:out value="${titulo.status}" />
                                    </td>
                                    <td>
                                        <c:out value="${titulo.valor}" />
                                        
                                    </td>
                                    <td>
                                    	<a class="btn btn-success btn-sm" href="editar?id=<c:out value='${titulo.id}' />">Editar</a>
                                    	<a class="btn btn-danger btn-sm" href="deletar?id=<c:out value='${titulo.id}' />">Deletar</a>
                                    </td>
                                </tr>
                            </c:forEach>

                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>

	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

	<script type="text/javascript">

    $(function () {
        $('[data-toggle="popover"]').popover();
    });

</script>

</body>
</html>