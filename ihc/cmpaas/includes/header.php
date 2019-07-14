<?php
    if(basename($_SERVER['PHP_SELF']) == 'index.php') {
        $home = "";
    } else {
        $home = "index.php";
    }
?>

<!-- <header style="margin-top:35px;" id="header">       -->
    <div class="container" style="margin-top:90px;">

        <div class="row">
            <div class="col-sm-12 overflow">
               <div class="social-icons pull-right">
                    <ul class="nav nav-pills">
                        <li><a href=""><i class="fa fa-facebook"></i></a></li>
                        <li><a href=""><i class="fa fa-twitter"></i></a></li>
                        <li><a href=""><i class="fa fa-google-plus"></i></a></li>
                        <li><a href=""><i class="fa fa-dribbble"></i></a></li>
                        <li><a href=""><i class="fa fa-linkedin"></i></a></li>
                    </ul>
                </div> 
            </div>
         </div>
    </div>
<!-- </header>   -->

<header id="header">         
    <div class="navbar navbar-inverse navbar-fixed-top align-middle" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="index.php">
                    <h1><img src="images/logo.png" alt="logo"></h1>
                </a>
                
            </div>
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.php">Início</a></li>
                    <li><a href="<?php echo $home ?>#sobre">Sobre</a></li>
                    <li><a href="<?php echo $home ?>#ferramentas">Ferramentas</a></li>                         
                    <li><a href="<?php echo $home ?>#publicacoes">Publicações</a></li>                         
                    <li><a href="<?php echo $home ?>#contato">Contato</a></li>                    
                    <li class="active"> <a href="login.php">Entrar</a></li>
                    <li class="active"> <a href="cadastrar.php" id="btn-insc">Inscrever-se</a></li>
                </ul>
            </div>
            <div class="search">
                <form role="form">
                    <i class="fa fa-search"></i>
                    <div class="field-toggle">
                        <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                    </div>
                </form>
            </div>
        </div>
</header>