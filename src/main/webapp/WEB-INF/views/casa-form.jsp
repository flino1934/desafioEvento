<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Casa de show</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>


	<header>

		<nav class="navbar navbar-expand-md navbar-light bg-primary">

			<div class="container">

				<h2>Cadastrar Casa de show</h2>
				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#nav-principal">
					<span class="navbar-toggler-icon"></span>

				</button>

				<div id="nav-principal" class="collapse navbar-collapse">

					<ul class="navbar-nav ml-auto">

						<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/clientes/list">Clientes</a></li>
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

	<div class="container">


		<form:form action="saveCasaDeShow" modelAttribute="casa" method="POST">

			<div class="form-row">

				<div class="form-group col-md-6">

					<label>Nome</label>
					<form:input class="form-control" placeholder="Nome do espaço"
						path="nomeCasaShow" />


				</div>

				<div class="form-group col-md-6">

					<label>Endereço</label>
					<form:input class="form-control"
						placeholder="EX: Rua Carlos Gomes Nº977)" path="endereco" />

				</div>

				<div class="form-group col-md-6">


					<label>CEP</label>
					<form:input class="form-control" placeholder="CEP: 11.704.190"
						path="cep" />


				</div>

				<div class="form-group col-md-6">


					<label>Descrição</label>
					<form:input class="form-control" placeholder="...."
						path="descricao" />

				</div>

				<div class="form-group col-md-6">


					<label>Capacidade</label>
					<form:input class="form-control" placeholder="EX: 1"
						path="capacidade" />

				</div>

				<div class="form-group col-md-6">


					<label>Valor locação</label>
					<form:input class="form-control" placeholder="EX: 2000.0"
						path="valorAluguel" />

				</div>

			</div>

			<button type="submit" class="btn btn-outline-primary"
				onclick="if(!(confirm('Deseja cadastrar o Casa?'))) return false">Salvar</button>

		</form:form>


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