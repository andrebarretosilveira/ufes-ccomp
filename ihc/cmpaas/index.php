<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Portal do Conhecimento | CMPaaS</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet"> 
    <link href="css/lightbox.css" rel="stylesheet"> 
    <link href="css/main.css" rel="stylesheet">
	<link href="css/sobre.css" rel="stylesheet">
    <link href="css/responsive.css" rel="stylesheet">
	<link href="css/maxim-stuff.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="images/ico/apple-touch-icon-57-precomposed.png">
    <!--<script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-client_id" content="YOUR_CLIENT_ID.apps.googleusercontent.com">-->


</head><!--/head-->

<body>
	<?php include_once("includes/header.php"); ?>
    <!--/#header-->

    <section id="home-slider">
        <div class="container">
            <div class="row">
                <div class="main-slider">
                    <div class="slide-text">
                        <div id="text-header">
                            <h1>Portal do Conhecimento Baseado em Mapas Conceituais</h1>
                            <p>Seja bem-vindo ao Portal do Conhecimento Baseado em Mapas Conceituais, o principal front-end dos serviços oferecidos pela plataforma CMPaaS.</p>
                        
                            <div id="btn-social">
                                <a class="btn btn-block btn-social btn-facebook" href="profile.php">
                                    <i class="fa fa-facebook"></i> Entrar com o Facebook  
                                </a>
                                <a class="btn btn-block btn-social btn-google-plus" href="profile.php">
                                    <i class="fa fa-google-plus"></i> Entrar com o Google+  
                                </a>
                            </div>
                            <p id="insc"> <a href="cadastrar.php">ou <b>inscrever-se</b></a></p>
                        </div>
                    </div>


                    <img src="images/home/slider/hill.png" class="slider-hill" alt="slider image">
                    <!-- <img src="images/home/slider/house.png" class="slider-house" alt="slider image"> -->
                    <!-- <img src="images/home/slider/sun.png" class="slider-sun" alt="slider image"> -->
                    <!-- <img src="images/home/slider/birds1.png" class="slider-birds1" alt="slider image"> -->
                    <!-- <img src="images/home/slider/birds2.png" class="slider-birds2" alt="slider image"> -->
                </div>
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

    <section id="sobre" style="padding-top: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-sm-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="images/home/ufes_logo.png" alt="">
                        </div>
                        <h3>Desenvolvido na UFES</h3>
                        <p>Todos os desenvolvedores do Portal do Conhecimento são Professores, Pesquisadores e Estudantes da UFES.</p>
                        <p><a class="links-page" href="sobre.php">Saiba mais</a></p>
                    </div>
                </div>
                <div class="col-sm-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="600ms">
                            <img src="images/home/portabilidade.png" alt="">
                        </div>
                        <h3>Fácil e Multiplataforma</h3>
                        <p>Todos as ferramentas deste Portal são de fácil utilização e estão disponíveis on-line. Cadastre-se e aproveite todas suas funções.</p>
                        <p><a class="links-page scroll-link" href="cadastrar.php">Cadastre-se</a></p>
                    </div>
                </div>
                <div class="col-sm-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="900ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="900ms">
                            <img src="images/home/colaborativo.png" alt="">
                        </div>
                        <h3>Trabalho Colaborativo</h3>
                        <p>Sentiu falta de alguma ferramenta? Junte-se ao nosso time e colabore com sua expansão.</p>
                        <p><a class="links-page scroll-link" href="#contato">Entre em contato</a></p>
                    </div>
                </div>
                <div class="col-sm-3 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="1200ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="1200ms">
                            <img src="images/home/cmaptools_logo.png" alt="">
                        </div>
                        <h3>Integrado ao CmapTools</h3>
                        <p>Importe seus mapas do CmapTools para o Portal do Conhecimento e aproveite das facilidades oferecidas pelo CMPaaS.</p>
                        <p><a class="links-page scroll-link" href="#ferramentas">Saiba mais</a></p>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--/#sobre-->

    <section id="action" class="responsive">
        <div class="vertical-center">
             <div class="container">
                <div class="row">
                    <div class="action take-tour">
                        <div class="col-sm-7 wow fadeInLeft" data-wow-duration="500ms" data-wow-delay="300ms">
                            <h3>Portal do Conhecimento e CMPaaS</h3>
                            <p>Interessado? Clique no botão ao lado e saiba mais sobre esta plataforma.</p>
                        </div>
                        <div class="col-sm-5 text-center wow fadeInRight" data-wow-duration="500ms" data-wow-delay="300ms">
                            <div class="tour-button">
                                <a href="sobre.php" class="btn btn-common">Saiba mais</a>
                             </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#action-->

    <section id="ferramentas">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="clients text-center">
                        <br>
                        <h2 class="title">Ferramentas</h2>
                        <!-- <p>A plataforma CMPaaS possui várias ferramentas que auxiliam no trabalho com mapas conceituais.<br>Nossas ferramentas são gratuitas e você também pode ajudar no desenvolvimento, para mais informações entre em contato. </p> -->
                    
                        <!-- <p style="margin-top: 50px; margin-bottom:10px;">A plataforma CMPaaS possui várias ferramentas que auxiliam no trabalho com mapas conceituais.<br> -->
                    <!-- Nossas ferramentas são gratuitas e você também pode ajudar no desenvolvimento, para mais informações entre em contato.</p> -->
                    </div>

                    <div id="ferramentas-carousel" class="carousel slide wow fadeIn" data-ride="carousel" data-wow-duration="400ms" data-wow-delay="400ms">
                        <!-- Indicators -->
                        <ol class="carousel-indicators visible-xs">
                            <li data-target="#ferramentas-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#ferramentas-carousel" data-slide-to="1"></li>
                        </ol>
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="editor"><img src="images/home/editor.png" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="editor">Editor de Mapas Conceituais</a></h3>
                                            <p>Crie, armazene e gerencie seus Mapas Conceituais de onde quiser.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><a href="#"><img src="images/home/iMap.png" class="img-circle img-responsive"></a></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">iMap</a></h3>
                                            <p>Interaja com seus mapas por meio de perguntas e respostas.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="images/home/ontoMap.png" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">OntoMap</a></h3>
                                            <p>Construa ontologias razas com nosso editor OWL.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="images/home/mapGenerator.png" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">Gerador de Mapas</a></h3>
                                            <p>Gere mapas conceituais automaticamente a partir de textos.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="http://placehold.it/200/BBBBBB/FFF" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">Informe aqui a Ferramenta 5</a></a></h3>
                                            <p>Informar neste campo tudo que se refere a ferramenta 5.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="http://placehold.it/200/BBBBBB/FFF" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">Ferramenta 6</a></h3>
                                            <p>Lorem ipsum dolor sit amet.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="http://placehold.it/200/BBBBBB/FFF" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">Ferramenta 7</a></h3>
                                            <p>Lorem ipsum dolor sit amet.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3 col-xs-6">
                                    <div class="team-single-wrapper">
                                        <div class="team-single">
                                            <div class="person-thumb">
                                                <a href="#"><img src="http://placehold.it/200/BBBBBB/FFF" class="img-circle img-responsive"></a>
                                            </div>
                                        </div>
                                        <div class="person-info">
                                            <h3><a href="#">Ferramenta 8</a></h3>
                                            <p>Lorem ipsum dolor sit amet.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left team-carousel-control hidden-xs" href="#ferramentas-carousel" data-slide="prev">left</a>
                        <a class="right team-carousel-control hidden-xs" href="#ferramentas-carousel" data-slide="next">right</a>
                    </div>


                    <div class="clients text-center">
                        <br>
                        <!-- <h2 class="title">Ferramentas</h2> -->
                        <!-- <p>A plataforma CMPaaS possui várias ferramentas que auxiliam no trabalho com mapas conceituais.<br>Nossas ferramentas são gratuitas e você também pode ajudar no desenvolvimento, para mais informações entre em contato. </p> -->
                    
                        <p style="margin-top: 40px; margin-bottom:10px;">A plataforma CMPaaS possui várias ferramentas que auxiliam no trabalho com mapas conceituais.<br>
                    Nossas ferramentas são gratuitas e você também pode ajudar no desenvolvimento, para mais informações entre em contato.</p>
                    </div>
            </div>

        </div>
     </section>
    <!--/#ferramentas-->

    <section id="publicacoes" style="padding-top: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <div class="clients text-center">
                        <h2 class="title">Publicações</h2>
                    </div>

                    <div class="clients-logo wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
                        <div class="col-xs-18 col-sm-6 col-md-3">
                          <div class="thumbnail">
                            <img src="images/home/pub1.png" alt="">
                              <div class="caption">
                                <h3>Site do CMPaaS revitalizado</h3>
                                <p id="desc1">O Portal do Conhecimento foi lindamente refeito para melhor apoiar o usuário na utilização de nossos serviços. Olha como ficou bonito!</p>
                                <p><a class="links-page" href="#">Continue lendo</a></p>
                            </div>
                          </div>
                        </div>

                        <div class="col-xs-18 col-sm-6 col-md-3">
                          <div class="thumbnail">
                            <img src="images/home/pub2.jpg" alt="">
                              <div class="caption">
                                <h3>Frente fria geladinha chegando</h3>
                                <p id="desc2">Temos baixíssimas temperaturas neste começo de julho. Agasalhe-se e lembre: muito melhor que no verão com os aparelhos de ar-condicionado queimando.</p>
                                <p><a class="links-page" href="#">Continue lendo</a></p>
                            </div>
                          </div>
                        </div>

                        <div class="col-xs-18 col-sm-6 col-md-3">
                          <div class="thumbnail">
                            <img src="images/home/pub3.jpg" alt="">
                              <div class="caption">
                                <h3>Professor descobre cura para câncer</h3>
                                <p id="desc3">O professor da UFES Davisdon Cury popularmente conhecido como "DD" descobre cura para câncer durante aula de IHC. "Eu só estava tentando criar uma interface agradável, mas esbarrei na cura", diz ele.</p>
                                <p><a class="links-page" href="#">Continue lendo</a></p>
                            </div>
                          </div>
                        </div>

                        <div class="col-xs-18 col-sm-6 col-md-3">
                          <div class="thumbnail">
                            <img src="images/home/pub4.jpg" alt="">
                              <div class="caption">
                                <h3>Gatas irlandesas são as melhores</h3>
                                <p id="desc4">De acordo com pesquisa realizadas no âmbito populacional diversificado, as evidências são claras quanto a preferência relativa da média individual a respeito do gosto particular de cada um para com as irlandesas.</p>
                                <p><a class="links-page" href="#">Continue lendo</a></p>
                            </div>
                          </div>
                        </div>
                    </div>

                    <div class="margin-bottom text-center">
                        <a href="blog.php" class="btn btn-common">Mais publicações</a>
                    </div>
                </div>
            </div>
        </div>
     </section>
    <!--/#publicacoes-->

    <section id="contato" style="padding-top: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="images/home/under.png" class="img-responsive inline" alt="">
                </div>

                <div class="col-sm-12">
                    <div class="clients text-center">
                        <h2 class="title">Fale conosco</h2>
                    </div>
               </div>

               <div class="col-md-8 col-sm-12">
                    <div class="contact-form bottom">
                        <h3>Envie sua mensagem</h3>
                        <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" required="required" placeholder="Nome">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" required="required" placeholder="E-mail">
                            </div>
                            <div class="form-group">
                                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Seu texto aqui"></textarea>
                            </div>                        
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Enviar">
                            </div>
                        </form>
                    </div>
                </div>

                <div class="col-md-4 col-sm-6">
                    <div class="contact-info bottom">
                        <h3>Contato</h3>
                        <address>
                        E-mail: <a href="mailto:cmpaas@gmail.com">cmpaas@gmail.com</a> <br> 
                        Tel: +55 (27) 4009 - 2061 <br> 
                        Horários: Segunda - Sexta, 8:00 às 17:00 <br> 
                        </address>

                        <h3>Endereço</h3>
                        <address>
                        UFES - Campus Universitário de Goiabeiras <br> 
                        CT VII - Departamento de Informática <br> 
                        Laboratório de Informática na Educação <br> 
                        Av. Fernando Ferrari, 514, 29075-910 <br>
                        Vitória/ES, Brasil <br> 
                        </address>
                    </div>
                </div>

                <!-- Map Column
                <div class="col-sm-12 map-margin">
                    <!-- Embedded Google Map
                    <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d17803.18130116059!2d-40.29831118382717!3d-20.273020634922776!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0000000000000000%3A0xef39e58c104c8a86!2sUFES+-+Departamento+de+Inform%C3%A1tica!5e0!3m2!1sen!2sbr!4v1460728645466" width="100%" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
                -->
            </div>
        </div>
    </section>
    <!--/#contato-->

    <?php include_once("includes/footer.php"); ?>
    <!--/#footer-->

    <?php include_once("includes/scroll-top-link.php"); ?>

    <!-- Javascript file includes -->
    <?php include_once("includes/javascripts.php"); ?>
</body>
</html>
