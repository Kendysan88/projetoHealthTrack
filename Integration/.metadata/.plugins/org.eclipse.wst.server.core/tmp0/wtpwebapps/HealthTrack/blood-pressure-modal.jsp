<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div class="modal fade" id="modalPressao" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalPressao">Editar Pressão
						Arterial</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-row">
							<div class=" form-group col-md-6">
								<label for="">Pressão Arterial Sistólica</label> <input
									type="text" name="" id="" class="form-control">
							</div>
							<div class="form-group col-md-6">
								<label for="">Pressão Arterial Diastólica</label> <input
									type="text" name="" id="" class="form-control">
							</div>
						</div>
						<div class="form-row">
							<div class=" form-group col-md-6">
								<label for="">Data</label> <input type="date" name="" id=""
									class="form-control">
							</div>
							<div class="form-group col-md-6">
								<label for="">Horário</label> <input type="time" name="" id=""
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