<%-- 
    Document   : accueil
    Created on : 28 mars 2018, 11:56:14
    Author     : FLEXICSSS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Accueil Page</title>
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" 
                  href="Vlava/js/rs-plugin/css/settings.css" media="screen">
            <link rel="stylesheet" type="text/css" href="Vlava/css/isotope.css" media="screen">
            <link rel="stylesheet" 
                  href="flexslider.css" type="text/css">
            <link rel="stylesheet" href="Vlava/js/jquery.fancybox.css" type="text/css" 
                  media="screen">
            <link rel="stylesheet" href="Vlava/css/bootstrap.css">
            <link rel="stylesheet" 
                  href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
            <link rel="stylesheet" href="Vlava/css/style.css">
            <!-- skin -->
            <link rel="stylesheet" href="Vlava/css/default.css">
        </head>

        <body>
        <section id="header" class="appear"></section>
        <div class="navbar navbar-fixed-top" role="navigation" 
             data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" 
             data-300="line-height:60px; height:60px; background-color:rgba(5, 42, 62, 1);">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="fa fa-bars color-white"></span>
                    </button>
                </div>

                <!-- Menu en haut -->
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                        
                        <li><a href="#testimonials">Aperçu</a></li>
                        <li><a href="#section-contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <!-- Bienvenue -->
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Bienvenue 
                </h3>
                <div>
                    <a href="connection.jsp" class="btn-get-started scrollto">CONNEXION </a>
                    <a href="inscription.jsp" class="btn-get-started scrollto">INSCRIPTION</a>
                </div>
            </div>
        </section>

        <!-- Apercu -->
        <section id="testimonials" class="section" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="align-center">
                            <div class="flexslider testimonials-slider">
                                <ul class="slides">
                                    <li>
                                        <div class="testimonial clearfix">
                                            
                                            <i class="fa fa-quote-left fa-5x"></i>
                                            <h5>Des programmes sportifs</h5>
                                            <br/>
                                            <h5>Vous souhaitez améliorer votre forme physique? Choisissez celui-ci!</h5>
                                            <div class="mar-bot20">
                                                <img alt="" src="Vlava/img/testimonial/coachsportif.jpg" class="img-circle">
                                            </div>
                                        </div>
                                    </li>

                                    <li>
                                        <div class="testimonial clearfix">
                                            
                                            <i class="fa fa-quote-left fa-5x"></i>
                                            <h5>Des programmes minceurs</h5>
                                            <br/>
                                            <h5>Envie de retrouver la forme avant l'été? Choisissez celui-ci!</h5>
                                            <div class="mar-bot20">
                                                <img alt="" src="Vlava/img/testimonial/majiaxian.jpg" class="img-circle">
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- contact -->
        <section id="section-contact" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Contactez nous </h2>
                        </div>
                        <ul>
                            <li>
                                Admin: <a href="mailto:yiqingshao19940903@gmail.com">SerbiSociety.com</a>
                            </li>
                            <li>
                                Coach: <a href="mailto:flexic.s@hotmail.com">Jean-DavidCoaching@hotmail.com</a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </section>

        <section id="footer" class="section footer">
            <div class="container">
                <div class="row animated opacity mar-bot20" data-andown="fadeIn" data-animation="animation">
                    <div class="col-sm-12 align-center">
                        <ul class="social-network social-circle">
                            <li><a href="#" class="icoRss" title="Rss"><i class="fa fa-rss"></i></a></li>
                            <li><a href="#" class="icoFacebook" title="Facebook"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#" class="icoTwitter" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" class="icoGoogle" title="Google +"><i class="fa fa-google-plus"></i></a></li>
                            <li><a href="#" class="icoLinkedin" title="Linkedin"><i class="fa fa-linkedin"></i></a></li>
                        </ul>
                    </div>
                </div>
                <div class="row align-center mar-bot20">
                    <ul class="footer-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="#testimonials">Apercu</a></li>
                        <li><a href="#section-contact">Contact</a></li>
                    </ul>
                </div>
                <div class="row align-center copyright">
                    <div class="col-sm-12">
                        <p>Copyright &copy; All rights reserved</p>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
</f:view>
