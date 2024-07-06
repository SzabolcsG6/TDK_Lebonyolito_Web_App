<%-- 
    Document   : JelszoVisszaallitas
    Created on : Jul 2, 2024, 12:10:57 PM
    Author     : misim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Tudományos Diákköri Konferencia - Sapientia EMTE - Marosvásárhely - Jelszó Visszaállítás</title>

    <meta name="description" content="Jelszó visszaállítás a Tudományos Diákköri Konferencia oldalán.">
    <meta name="author" content="Hallgatói Önkormányzat (HÖK) EMTE Marosvásárhely">

    <meta name="keywords" content="tdk, jelszó visszaállítás, konferencia, tudomány, diák, diákköri, konferencia" >

    <meta property="og:title" content="TDK Tudományos Diákköri Konferencia Sapientia EMTE" >
    <meta property="og:type" content="website" >
    <meta property="og:url" content="http://localhost:8080 >
    <meta property="og:site_name" content="localhost" >
    <meta property="og:description" content="Jelszó visszaállítás a Tudományos Diákköri Konferencia oldalán." >

    <link rel="stylesheet" type="text/css" href="site.css">
    <script>
        (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
        })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

        ga('create', 'UA-51155804-1', 'sapientia.ro');
        ga('send', 'pageview');
    </script>

    <script src="https://www.google.com/recaptcha/api.js?hl=hu&onload=recap_callback&render=explicit" async defer></script>
    <script>
        function recap_callback(){
            let cap2 = grecaptcha.render (document.getElementById("cap2"), {'sitekey': '6LeG6BITAAAAAIrIsMER8ukglclgh2xHOIi2YraB'});
            document.querySelector('.cap2btn').disabled = false;
        }
    </script>
</head>
<body>
 <div class="page-wrapper">
		<div class="page-wrapper">
		<div class="header-container">	
			<div class="header"></div>
			<div class="menu">
				<%@ include file="/WEB-INF/jspf/menu.jspf" %>
			</div>
		</div>
		<div class="content-container">
            <div class="content-col">
                <h1>Jelszó visszaállítás</h1>
<form action="JelszoVisszaallitasServlet" method="post">
    <div class="signup-col">
        <label>E-mail cím:</label>
        <input type="text" name="mail_passw_res" id="email" style="width:100%;" placeholder="E-mail cím" required />
        <input type="submit" value="Jelszó visszaállítás kérés küldése!" class="btn btn-default btn-sm fr" style="margin-top: 10px;" />
    </div>
</form>

                <div class="cb"></div>
            </div>
            <div class="cb"></div>
        </div>
        <div class="footer-container">
            <div class="sponsors">
                <a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images/sponsors/logo3.png" /></a>
                <a href="www.tmd.ro" target="_blank"><img height="30" src="images/sponsors/tmdlogo.jpg" /></a>
                <a href="http://mshok.ro/" target="_blank"><img height="30" src="images/sponsors/logo2.png" /></a>
                <a href="http://www.upt.ro/" target="_blank"><img height="30" src="images/sponsors/upt.jpg" /></a>
                <a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images/sponsors/logo5.png" /></a>
                <a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images/sponsors/obudalogo.jpg" /></a>
                <a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images/sponsors/logo8.png" /></a>
                <a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images/sponsors/partner_logo_omdsz.png" /></a>
                <a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images/sponsors/otdk_logo_piros.jpg" /></a>
                <a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images/sponsors/logo9.png" /></a>
                <a href="http://ofi.hu/" target="_blank"><img height="30" src="images/sponsors/logo4.png" /></a>
                <a href="https://eme.ro/" target="_blank"><img height="30" src="images/sponsors/eme.png" /></a>
            </div>
        </div>
    </div>
</body>
</html>
