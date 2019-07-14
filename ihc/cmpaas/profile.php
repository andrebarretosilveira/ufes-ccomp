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

        <!-- /col-3 -->
        <div  id="perfil" class="col-md-9">
          <span class="section-title"><i class="glyphicon glyphicon-user"></i> Meu Perfil</span>  
          <hr>
          <div class="row">
            <div class="col-md-12">
              <div class="media">
                  <a class="pull-left" href="#">
                      <img class="media-object dp img-circle" src="images/aboutus/dede-small.jpg">
                  </a>
                  <div class="media-body">
                      <h4 class="media-heading">Davidson Cury <small> Brasil</small></h4>
                      <h5>Professor em <a href="http://ufes.br">UFES</a></h5>

                      <span class="label label-default">HTML5/CSS3</span>
                      <span class="label label-default">jQuery</span>
                      <span class="label label-info">CakePHP</span>
                      <span class="label label-default">Android</span>

                      <p><br></p>
                      <p>Tenho uma ótima casa em Manguinhos.<br>Ela é excelente para churrascos.</p>
                  </div>
              </div>
            </div>
          </div>
          <!--/row-->
          <hr id="mapas">
          <span class="section-title"><i class="glyphicon glyphicon-file"></i> Mapas Produzidos</span>
          <hr>
          <div class="row">
            <div class="col-md-12">
              <ul class="list-group">
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-file"></i> concepts-map</a><div class="icons" style="float:right;"> <a href="editor" data-toggle="tooltip" title="Editor de mapas conceituais" ><i class="glyphicon glyphicon-edit"></i></a> <a href="#" data-toggle="tooltip" title="iMap"><i class="glyphicon glyphicon-comment"></i> </a>  <a href="#" data-toggle="tooltip" title="OntoMap"><i class="glyphicon glyphicon-link"></i> </a>  <a href="#" data-toggle="tooltip" title="Gerador de Mapas"><i class="glyphicon glyphicon-refresh"></i> </a></div></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-file"></i> digital-concepts-map</a><div class="icons" style="float:right;"> <a href="editor" data-toggle="tooltip" title="Editor de mapas conceituais"><i class="glyphicon glyphicon-edit"></i></a> <a href="#" data-toggle="tooltip" title="iMap"><i class="glyphicon glyphicon-comment"></i> </a>  <a href="#" data-toggle="tooltip" title="OntoMap"><i class="glyphicon glyphicon-link"></i> </a>  <a href="#" data-toggle="tooltip" title="Gerador de Mapas"><i class="glyphicon glyphicon-refresh"></i> </a></div></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-file"></i> digital-recursive-concepts-map</a><div class="icons" style="float:right;"> <a href="editor" data-toggle="tooltip" title="Editor de mapas conceituais"><i class="glyphicon glyphicon-edit"></i></a> <a href="#" data-toggle="tooltip" title="iMap"><i class="glyphicon glyphicon-comment"></i> </a>  <a href="#" data-toggle="tooltip" title="OntoMap"><i class="glyphicon glyphicon-link"></i> </a>  <a href="#" data-toggle="tooltip" title="Gerador de Mapas"><i class="glyphicon glyphicon-refresh"></i> </a></div></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-file"></i> complex-digital-recursive-concepts-map</a><div class="icons" style="float:right;"> <a href="editor" data-toggle="tooltip" title="Editor de mapas conceituais"><i class="glyphicon glyphicon-edit"></i></a> <a href="#" data-toggle="tooltip" title="iMap"><i class="glyphicon glyphicon-comment"></i> </a>  <a href="#" data-toggle="tooltip" title="OntoMap"><i class="glyphicon glyphicon-link"></i> </a>  <a href="#" data-toggle="tooltip" title="Gerador de Mapas"><i class="glyphicon glyphicon-refresh"></i> </a></div></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-file"></i> just-some-map</a><div class="icons" style="float:right;"> <a href="editor" data-toggle="tooltip" title="Editor de mapas conceituais"><i class="glyphicon glyphicon-edit"></i></a> <a href="#" data-toggle="tooltip" title="iMap"><i class="glyphicon glyphicon-comment"></i> </a>  <a href="#" data-toggle="tooltip" title="OntoMap"><i class="glyphicon glyphicon-link"></i> </a>  <a href="#" data-toggle="tooltip" title="Gerador de mapas"><i class="glyphicon glyphicon-refresh"></i> </a></div></li>
              </ul>
            </div>
          </div>
          <!--/row-->
          <hr id="mensagens">
          <span class="section-title"><strong><i class="glyphicon glyphicon-comment"></i> Mensagens</span>  
          <hr>
          <div class="row">
            <div class="col-md-12">
              <ul class="list-group">
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(3 mins ago)</small> The 3rd page reports don't contain any links. Does anyone know why..</a></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(1 hour ago)</small> Hi all, I've just post a report that show the relationship betwe..</a></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart"></i> <small>(2 hrs ago)</small> Paul. That document you posted yesterday doesn't seem to contain the over..</a></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart-empty"></i> <small>(4 hrs ago)</small> The map service on c243 is down today. I will be fixing the..</a></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-heart"></i> <small>(yesterday)</small> I posted a new document that shows how to install the services layer..</a></li>
                <li class="list-group-item"><a href="#"><i class="glyphicon glyphicon-flash"></i> <small>(yesterday)</small> ..</a></li>
              </ul>
            </div>
          </div>
        </div>
        <!--/col-span-9-->
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