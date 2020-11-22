<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div class="modal fade" id="modalExercicio" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modalExercicio">Editar Atividade</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="physicalActivity" method="post">
						 <input type="hidden" value="create" name="action">
						<div class="form-group">
							<label for="">Atividade Físca</label> <input type="text" name="activityName"
								id="" class="form-control">
						</div>
						<div class="form-group">
							<label for="">Tipo de Atividade</label> <select name="activityType" id=""
								class="form-control">
								<option selected>Escolha...</option>
								<option>...</option>
								<option>...</option>
								<option>...</option>
							</select>
						</div>
						<div class="form-group">
							<label for="">Data</label> <input type="date" name="date" id=""
								class="form-control">
						</div>
						<div class="form-row">
							<div class=" form-group col-md-6">
								<label for="">Início</label> <input type="time" name="startTime" id=""
									class="form-control">
							</div>
							<div class="form-group col-md-6">
								<label for="">Fim</label> <input type="time" name="endTime" id=""
									class="form-control">
							</div>
						</div>
						<div class="form-row">
							<div class=" form-group col-md-6">
								<label for="">Calorias</label> <input type="text" name="calories" id=""
									class="form-control">
							</div>
							<div class="form-group col-md-6">
								<label for="">Distância</label> <input type="text" name="distance" id=""
									class="form-control">
							</div>
						</div>
						<div class="form-row">
							<div class=" form-group col-md-4">
								<label for="">Séries</label> <input type="text" name="series" id=""
									class="form-control">
							</div>
							<div class="form-group col-md-4">
								<label for="">Repetições</label> <input type="text" name="repetitions"
									id="" class="form-control">
							</div>
							<div class="form-group col-md-4">
								<label for="">Peso Levantado</label> <input type="text" name="liftedWeight"
									id="" class="form-control">
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