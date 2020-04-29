<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

</head>


<header>

	<nav class="navbar navbar-expand-md navbar-light bg-light">
	
		<div class="container">

			<h2>Clientes</h2>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#nav-principal">
				<span class="navbar-toggler-icon"></span>

			</button>

			<div id="nav-principal" class="collapse navbar-collapse">

				<ul class="navbar-nav ml-auto">

					<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/clientes/list">Clientes</a></li>
					<li class="nav-item"><a class="nav-link" href="/eventos/list">Eventos</a></li>
					<li class="nav-item"><a class="nav-link"
						href="/casaDeShow/list">Casas de show</a></li>

					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false">Cadastrar</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="/clientes/showFormForAdd">Cliente</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="/eventos/showFormForAddEvento">Evento</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item"
								href="/casaDeShow/showFormForAddCasaDeShow">Casa de show</a>

						</div></li>

				</ul>

			</div>

		</div>

	</nav>


</header>

<div id="container">
	<div id="content">


		<!-- add our html table here -->

		<table class ="table table-hover table-bordered" >
			<thead class = "thead-dark">
				<tr>
					<th scope = "col" >First Name:</th>
					<th scope = "col">Last Name:</th>
					<th scope = "col">CPF:</th>
					<th scope = "col">Email::</th>
					<th scope = "col">Telefone:</th>
					<th scope = "col">Action</th>
	
				</tr>
			</thead>
			<!-- Loop over and print our cliente -->



			<c:forEach var="tempCliente" items="${clientes}">

				<!-- construc an update link with cliente id -->

				<c:url var="updateLink" value="/clientes/showFormForUpdate">

					<c:param name="clienteId" value="${tempCliente.id}"></c:param>

				</c:url>

				<c:url var="deleteLink" value="/clientes/delete">

					<c:param name="clienteId" value="${tempCliente.id}"></c:param>

				</c:url>

				<tr>
					<td>${tempCliente.firstName}</td>
					<td>${tempCliente.lastName}</td>
					<td>${tempCliente.cpf}</td>
					<td>${tempCliente.email}</td>
					<td>${tempCliente.telefone}</td>
					<!-- Display the update link -->

					<td><a href="${updateLink}">Update</a> <a href="${deleteLink}"
						onclick="if(!(confirm('Deseja deletar o cliente?'))) return false">Delete</a></td>
				</tr>
			</c:forEach>

		</table>

	</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</body>
</html>