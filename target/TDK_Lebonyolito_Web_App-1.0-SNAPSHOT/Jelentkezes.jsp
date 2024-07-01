<%-- 
    Document   : Jelentkezes
    Created on : Mar 26, 2024, 4:23:29 PM
    Author     : misim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.io.*, java.util.*, javax.mail.*, javax.mail.internet.*, javax.naming.*, javax.activation.*" %>
<%--<%@ page import="JavaClasses.EmailKuldo" %>
<%@ page import="JavaClasses.AdatbazisKezelo" %>--%>

<!doctype html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
	<title>Tudományos Diákköri Konferencia - Sapientia EMTE - Marosvásárhely- Jelentkezés</title>

	<meta name="description" content="Regisztráció a diákköri konferenciára mint résztvevő. ">
	<meta name="author" content="Hallgatói Önkormányzat (HÖK) EMTE Marosvásárhely">

	<meta name="keywords" content="tdk, dolgozatok, regisztráció, konferencia, tudomány, diák, kiákköri, diákköri konferencia" >

	<meta property="og:title" content="TDK Tudományos Diákköri Konferencia Sapientia EMTE" >
	<meta property="og:type" content="website" >
	<meta property="og:url" content="http://localhost:8080" >
	<meta property="og:site_name" content="localhost" >
	<meta property="og:description" content="Regisztráció a diákköri konferenciára mint résztvevő." >

	<link rel="stylesheet" type="text/css" href="site.css">
<!--	<script>
	  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

	  ga('create', 'UA-51155804-1', 'sapientia.ro');
	  ga('send', 'pageview');

	</script>-->

<script src="https://www.google.com/recaptcha/api.js?hl=hu&onload=recap_callback&render=explicit" async defer></script>
<script>
function recap_callback() {
    let cap2 = grecaptcha.render(document.getElementById("cap2"), {'sitekey': '6LeIxAcTAAAAAJcZVRqyHh71UMIEGNQ_MXjiZKhI'});
    document.querySelector('.cap2btn').disabled = false; 
}
</script>
</head>
<body>
		<div class="page-wrapper">
		
		<div class="header-container">
                        			<div class="header"></div>
			<div class="menu">
				<ul>
				<li><a href="Hirek.jsp" >Hírek</a></li><li><a href="Szakosztalyok.jsp" >Szakosztályok</a></li><li><a href="Formai_Kovetelmenyek.jsp" >Formai követelmények</a></li><li><a href="Dokumentumok.jsp" >Dokumentumok</a></li><li><a href="Jelentkezes.jsp" >Jelentkezés</a></li><li><a href="Archivum.jsp" >Archívum</a></li><li class="active"><a href="Ro.jsp" >Ro</a></li><li><a href="Eng.jsp" >Eng</a></li>					
					<!-- <li class="active"><a href="#" >aktiv menü</a></li> -->
				</ul>
			</div>
		</div>
                <div class="content-container">
<div class="content-col content-col-wide">
        <h1 id="jelentkezes">Jelentkezés</h1>
        <div class="cb"></div>
                <div class="login-col">
            <form method = "post" class = "login_form" >
                    <h3>Bejelentkezés</h3>
                    <label>E-mail cím:</label>
                    <input class="inp" type = "text" name = "mail" id ="mail" placelholder="E-mail cím" required />
                    <label>Jelszó:</label>
                    <input class="inp" type = "password" name = "passw" id ="passw" placelholder="Jelszó" required />
                    <!-- div id="cap1" style="margin-top:10px;" class="g-recaptcha" ></div -->
                    <input type="submit" value ="Belépés" class="cap1btn btn btn-default btn-sm fr" style="margin-top: 10px;" />
                    <a style="float:left; display: inline-block; margin-top: 17px" href = "https://mtdk.tmd.ro/index.php/site/apply/?s=passw_res">Elfelejtettem a jelszavam.</a>
                    <div class="cb"></div>
            </form>
        </div>

        <div class="signup-col">
            <form method = "post" class = "login_form" >
                <h3>Regisztráció</h3>
                <label>Név:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "name" id ="name" placelholder="Név" required />
                <label>E-mail cím:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "mail" id ="mail" placelholder="E-mail cím" required />
                <label>Jelszó:</label>
                <input class="inp" autocomplete = "off" type = "password" name = "password" id ="password" placelholder="Jelszó" required />
                <label>Jelszó újra:</label>
                <input class="inp" autocomplete = "off" type = "password" name = "password2" id ="password2" placelholder="Jelszó újra" required />
                <label>Egyetem:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "univers" id ="univers" placelholder="Egyetem" required />
                <label>Kar:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "department" id ="department" placelholder="Kar" required />
                <label>Szak:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "profile" id ="profile" placelholder="Szak" required />
                <label>Évfolyam:</label>
                <input class="inp" autocomplete = "off" value = "" type = "text" name = "year" id ="year" placelholder="Évfolyam(1-4)" required />
               
                <div id="cap2" style="margin-top:10px;" class="g-recaptcha" ></div>
 
                <input type="submit" value ="Regisztráció" class="cap2btn btn btn-default btn-sm fr" style="margin-top: 10px;" />
                <div class="cb"></div>
            </form>
        </div>
        <div class="cb"></div>
</div>
<div class="cb"></div>

</div>

<div class="footer-container">
    <div class="sponsors">
        <a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images\logo3.png" /></a><a href="www.tmd.ro" target="_blank"><img height="30" src="images\tmdlogo.jpg" /></a><a href="http://mshok.ro/" target="_blank"><img height="30" src="images/logo2.png" /></a><a href="http://www.upt.ro/" target="_blank"><img height="30" src="images\upt.jpg" /></a><a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images\logo5.png" /></a><a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images\obudalogo.jpg" /></a><a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images\logo8.png" /></a><a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images\partner_logo_omdsz.png" /></a><a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images\otdk_logo_piros.jpg" /></a><a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images\logo9.png" /></a><a href="http://ofi.hu/" target="_blank"><img height="30" src="images\logo4.png" /></a>    </div>
</div>

</div>
  
</body>
</html>