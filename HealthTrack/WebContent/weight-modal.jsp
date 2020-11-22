<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
    <title>Peso</title>
  </head>
  <body>
    <div class="modal fade" id="modalPeso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="modalPeso">Editar Peso</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
            <form action="weight" method="post">
              <input type="hidden" value="create" name="action">

              <div class="form-group">
                <label for="">Peso</label>
                <input type="text" name="value" id="" class="form-control">
              </div>
              <div class="form-row">
                <div class=" form-group col-md-6">
                  <label for="">Data</label>
                  <input type="date" name="date" id="" class="form-control">
                </div>
                <div class="form-group col-md-6">
                  <label for="">Horário</label>
                  <input type="time" name="time" id="" class="form-control">
                </div>
              </div>
              <div class="form-row">
                <div class="form-group col-md-12">
                  <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                  <button type="submit" class="btn btn-primary">Salvar</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
