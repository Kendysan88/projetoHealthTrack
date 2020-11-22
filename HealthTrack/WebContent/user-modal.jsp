<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="modalPerfil" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
		aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalPerfil">Editar Dados</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="">Nome do Usuário</label> <input type="text" name=""
								id="" class="form-control">

						</div>
						<div class="form-group">
							<label for="">Email</label> <input type="email" name="" id=""
								class="form-control">
						</div>
						<div class="form-group">
							<label for="">Telefone</label> <input type="tel" name="" id=""
								class="form-control" placeholder="Telefone para Contato">
						</div>
						<div class="form-group">
							<label for="">Peso</label> <input type="text" name="" id=""
								class="form-control">
						</div>
						<div class="form-group">
							<label for="">Altura</label> <input type="text" name="" id=""
								class="form-control">
						</div>
						<div class="form-group">
							<label for="">Sexo</label> <select name="" id=""
								class="form-control">
								<option selected>Escolha...</option>
								<option>...</option>
								<option>...</option>
								<option>...</option>
							</select>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
					<button type="button" class="btn btn-primary">Atualizar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>