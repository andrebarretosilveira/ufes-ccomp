<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Perfil do usuário | CMPaaS</title>
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
    <link href="css/profile.css" rel="stylesheet">


  </head>
  <!--/head-->
  <body>
    <!-- Profile Header Navigation -->
    <?php include_once("includes/profile-header.php"); ?>

    <!-- Main -->
    <div class="container">
      <div class="row">
        <!-- Profile Left column -->
        <?php include_once("includes/profile-left-column.php"); ?>

        <div class="col-md-8">
          <div class="card">
              <span class="section-title"><i class="glyphicon glyphicon-user"></i> Editar Perfil</span>
              <hr>
              <div class="content">
                  <form>
                      <div class="row">
                          <div class="col-md-5">
                              <div class="form-group">
                                  <label>Tipo de conta (disabled)</label>
                                  <input type="text" class="form-control" disabled placeholder="Company" value="Colaborador.">
                              </div>
                          </div>
                          <div class="col-md-3">
                              <div class="form-group">
                                  <label>Nome do usuário</label>
                                  <input type="text" class="form-control" placeholder="Username" value="">
                              </div>
                          </div>
                          <div class="col-md-4">
                              <div class="form-group">
                                  <label for="exampleInputEmail1">E-mail</label>
                                  <input type="email" class="form-control" placeholder="Email">
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="col-md-6">
                              <div class="form-group">
                                  <label>Nome</label>
                                  <input type="text" class="form-control" placeholder="Nome" value="">
                              </div>
                          </div>
                          <div class="col-md-6">
                              <div class="form-group">
                                  <label>Sobrenome</label>
                                  <input type="text" class="form-control" placeholder="Sobrenome" value="">
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="col-md-6">
                              <div class="form-group">
                                  <label>Senha</label>
                                  <input type="password" class="form-control" placeholder="Informe a senha." value="">
                              </div>
                          </div>
                          <div class="col-md-6">
                              <div class="form-group">
                                  <label>Repetir Senha</label>
                                  <input type="password" class="form-control" placeholder="Repita a senha." value="">
                              </div>
                          </div>
                      </div>


                      <!-- <div class="row">
                          <div class="col-md-12">
                              <div class="form-group">
                                  <label>Endereço</label>
                                  <input type="text" class="form-control" placeholder="Endereço" value="">
                              </div>
                          </div>
                      </div> -->

                      <div class="row">
                          <div class="col-md-4">
                              <div class="form-group">
                                  <label>Cidade</label>
                                  <input type="text" class="form-control" placeholder="Cidade" value="">
                              </div>
                          </div>
                          <div class="col-md-4">
                              <div class="form-group">
                                  <label>Bairro</label>
                                  <input type="text" class="form-control" placeholder="Bairro" value="" >
                              </div>
                          </div>
                          <div class="col-md-4">
                              <div class="form-group">
                                  <label>CEP</label>
                                  <input type="number" class="form-control" placeholder="CEP">
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="col-md-12">
                              <div class="form-group">
                                  <label>Sobre mim</label>
                                  <textarea rows="5" class="form-control" placeholder="Insira aqui sua descrição." value="">...</textarea>
                              </div>
                          </div>
                      </div>

                      <button type="submit" class="btn btn-info btn-fill pull-right">Atualizar perfil</button>
                      <div class="clearfix"></div>
                  </form>
              </div>
          </div>
        </div>
        <!--<div class="col-md-3">
              <div class="card card-user">
                  <div class="image">
                      <img src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400" alt="..."/>
                  </div>
                  <div class="content">
                      <div class="author">
                           <a href="">
                          <img class="avatar border-gray" src="https://dronk.ru/img/user-icon.png" alt="..."/>

                            <h4 class="title">Teste<br />
                               <small>username</small>
                            </h4>
                          </a>
                      </div>
                      <p class="description text-center">  Lorem impsun..."
                      </p>
                  </div>
                  <hr>
                  <div class="text-center">
                      <button href="#" class="btn btn-simple"><i class="fa fa-facebook-square"></i></button>
                      <button href="#" class="btn btn-simple"><i class="fa fa-twitter"></i></button>
                      <button href="#" class="btn btn-simple"><i class="fa fa-google-plus-square"></i></button>

                  </div>
              </div>
        </div> -->
        
      </div>
    </div>

      </div>
    </div>
    <!-- /Main -->

    <!-- Footer -->
    <?php include_once("includes/footer.php"); ?>

    <div class="modal" id="addWidgetModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h4 class="modal-title">Add Widget</h4>
          </div>
          <div class="modal-body">
            <p>Add a widget stuff here..</p>
          </div>
          <div class="modal-footer">
            <a href="#" data-dismiss="modal" class="btn">Close</a>
            <a href="#" class="btn btn-primary">Save changes</a>
          </div>
        </div>
        <!-- /.modal-content -->
      </div>
      <!-- /.modal-dalog -->
    </div>
    <!-- /.modal -->
    
    <!-- Scroll to Top link -->
    <?php include_once("includes/scroll-top-link.php"); ?>

    <!-- Javascript file includes -->
    <?php include_once("includes/javascripts.php"); ?>
    <script type="text/javascript" src="js/profile.js"></script>
    
  </body>
</html>