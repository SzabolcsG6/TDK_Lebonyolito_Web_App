<%-- 
    Document   : Jelentkezes
    Created on : Mar 26, 2024, 4:23:29 PM
    Author     : misim
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="JavaClasses.DiakServlet,JavaClasses.AdatbazisKezelo,JavaClasses.Diak,JavaClasses.DiakDAO, java.sql.*, java.io.*, java.util.*" %>


<!doctype html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Tudományos Diákköri Konferencia - Sapientia EMTE - Marosvásárhely- Jelentkezés</title>
    <meta name="description" content="Regisztráció a diákköri konferenciára mint résztvevő. ">
    <meta name="author" content="Hallgatói Önkormányzat (HÖK) EMTE Marosvásárhely">
    <meta name="keywords" content="tdk, dolgozatok, regisztráció, konferencia, tudomány, diák, kiákköri, diákköri konferencia">
    <meta property="og:title" content="TDK Tudományos Diákköri Konferencia Sapientia EMTE">
    <meta property="og:type" content="website">
    <meta property="og:url" content="http://localhost:8080">
    <meta property="og:site_name" content="localhost">
    <meta property="og:description" content="Regisztráció a diákköri konferenciára mint résztvevő.">
    <link rel="stylesheet" type="text/css" href="site.css">
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
				<%@ include file="/WEB-INF/jspf/menu.jspf" %>
			</div>
		</div>
		<div class="content-container">
        <div class="content-col content-col-wide">
            <h1 id="jelentkezes">Jelentkezés</h1>
            <div class="cb"></div>
            <div class="login-col">
                <%@ include file="/WEB-INF/jspf/Bejelentkezes.jspf" %>
            </div>
            <div class="signup-col">
                <%@ include file="/WEB-INF/jspf/Regisztracio.jspf" %>
            </div>
            <div class="cb"></div>
        </div>
        <div class="cb"></div>
    </div>
    <div class="footer-container">
        <div class="sponsors">
            <a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images/logo3.png" /></a>
            <a href="www.tmd.ro" target="_blank"><img height="30" src="images/tmdlogo.jpg" /></a>
            <a href="http://mshok.ro/" target="_blank"><img height="30" src="images/logo2.png" /></a>
            <a href="http://www.upt.ro/" target="_blank"><img height="30" src="images/upt.jpg" /></a>
            <a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images/logo5.png" /></a>
            <a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images/obudalogo.jpg" /></a>
            <a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images/logo8.png" /></a>
            <a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images/partner_logo_omdsz.png" /></a>
            <a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images/otdk_logo_piros.jpg" /></a>
            <a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images/logo9.png" /></a>
            <a href="http://ofi.hu/" target="_blank"><img height="30" src="images/logo4.png" /></a>
        </div>
    </div>
</div>
</body>
</html>