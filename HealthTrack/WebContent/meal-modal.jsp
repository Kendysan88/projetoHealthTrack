<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="modal fade" id="modalAlimento" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalAlimento">Adicionar Refeições</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="">Lista de Alimentos</label> <select name="" id=""
								class="form-control">
								<option selected>Escolha...</option>
								<option>...............</option>
								<option>...............</option>
								<option>...............</option>
								<option>...............</option>
								<option>...............</option>
								<option>...............</option>
							</select>
						</div>
						<div class="form-row">
							<div class=" form-group col-md-6">
								<label for="">Quantidade</label> <input type="text" name=""
									id="" class="form-control">
							</div>
							<div class=" form-group col-md-6">
								<label for="">Total de Calorias</label> <input type="text" name="" id=""
									class="form-control">
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Fechar</button>
					<button type="button" class="btn btn-primary">Salvar</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>