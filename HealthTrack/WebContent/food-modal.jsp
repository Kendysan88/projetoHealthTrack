<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1">
	<title>Health Track</title>
  </head>
  <body>
    <div class="modal fade" id="modalAlimento" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">

          <div class="modal-header">
            <h5 class="modal-title" id="modalAlimento">Adicionar Alimentos</h5>

            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>

          <div class="modal-body">
            <form action="food" method="post">
              <input type="hidden" value="create" name="action">

              <div class="form-group">
                <label for="">Nome</label>
                <input type="text" name="name" id="" class="form-control">
              </div>

              <div class="form-group">
                <label for="">Descrição</label>
                <textarea class="form-control" name="description" id="" rows="3"></textarea>
              </div>

              <div class="form-row">
                <div class=" form-group col-md-4">
                  <label for="">Quantidade</label>
                  <input type="text" name="amount" id="" class="form-control">
                </div>
                
                <div class="form-group col-md-4">
                  <label for="">Tipo de Medida</label>
                  <select name="unit" id="" class="form-control">
                    <option selected>Escolha...</option>
                    <option>ml</option>
                    <option>g</option>
                  </select>
                </div>

                <div class=" form-group col-md-4">
                  <label for="">Calorias</label>
                  <input type="text" name="calories" id="" class="form-control">
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
