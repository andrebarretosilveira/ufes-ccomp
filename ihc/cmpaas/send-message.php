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
    <link href="css/mensagem.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

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
            <span class="section-title"><i class="glyphicon glyphicon-send"></i> Enviar Mensagem</span>
            <hr>
            <div class="panel panel-default">
              <div class="panel-body message">
                <form class="form-horizontal" role="form">
                  <div class="form-group">
                      <label for="to" class="col-sm-1 control-label">To:</label>
                      <div class="col-sm-11">
                                      <input type="email" class="form-control select2-offscreen" id="to" placeholder="Type email" tabindex="-1">
                      </div>
                    </div>
                  <div class="form-group">
                      <label for="cc" class="col-sm-1 control-label">CC:</label>
                      <div class="col-sm-11">
                                      <input type="email" class="form-control select2-offscreen" id="cc" placeholder="Type email" tabindex="-1">
                      </div>
                    </div>
                  <div class="form-group">
                      <label for="bcc" class="col-sm-1 control-label">BCC:</label>
                      <div class="col-sm-11">
                                      <input type="email" class="form-control select2-offscreen" id="bcc" placeholder="Type email" tabindex="-1">
                      </div>
                    </div>
                  
                </form>
                
                <div class="col-sm-11 col-sm-offset-1">
                  
                  <div class="btn-toolbar" role="toolbar">
                    
                    <div class="btn-group">
                        <button class="btn btn-default"><span class="fa fa-bold"></span></button>
                        <button class="btn btn-default"><span class="fa fa-italic"></span></button>
                      <button class="btn btn-default"><span class="fa fa-underline"></span></button>
                    </div>

                    <div class="btn-group">
                        <button class="btn btn-default"><span class="fa fa-align-left"></span></button>
                        <button class="btn btn-default"><span class="fa fa-align-right"></span></button>
                        <button class="btn btn-default"><span class="fa fa-align-center"></span></button>
                      <button class="btn btn-default"><span class="fa fa-align-justify"></span></button>
                    </div>
                    
                    <div class="btn-group">
                        <button class="btn btn-default"><span class="fa fa-indent"></span></button>
                        <button class="btn btn-default"><span class="fa fa-outdent"></span></button>
                    </div>
                    
                    <div class="btn-group">
                        <button class="btn btn-default"><span class="fa fa-list-ul"></span></button>
                        <button class="btn btn-default"><span class="fa fa-list-ol"></span></button>
                    </div>
                    <button class="btn btn-default"><span class="fa fa-trash-o"></span></button>  
                    <button class="btn btn-default"><span class="fa fa-paperclip"></span></button>
                    <div class="btn-group">
                      <button class="btn btn-default dropdown-toggle" data-toggle="dropdown"><span class="fa fa-tags"></span> <span class="caret"></span></button>
                      <ul class="dropdown-menu">
                        <li><a href="#">add label <span class="label label-danger"> Home</span></a></li>
                        <li><a href="#">add label <span class="label label-info">Job</span></a></li>
                        <li><a href="#">add label <span class="label label-success">Clients</span></a></li>
                        <li><a href="#">add label <span class="label label-warning">News</span></a></li>
                      </ul>
                    </div>
                  </div>
                  <br>  
                  
                  <div class="form-group">
                    <textarea class="form-control" id="message" name="body" rows="12" placeholder="Click here to reply"></textarea>
                  </div>
                  
                  <div class="form-group">  
                    <button type="submit" class="btn btn-success">Send</button>
                    <button type="submit" class="btn btn-default">Draft</button>
                    <button type="submit" class="btn btn-danger">Discard</button>
                  </div>
                </div>  
              </div>  
            </div>  
          </div><!--/.col-->

      </div>
      <!-- /col-3 -->
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