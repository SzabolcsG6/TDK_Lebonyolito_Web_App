<%@ page import="JavaClasses.Diak" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
	<title>Tudományos Diákköri Konferencia - Sapientia EMTE - Marosvásárhely- Hírek</title>
	<meta name="description" content="Műszaki Tudományos Diákköri Konferencia Temesvár hírek ">
	<meta name="author" content="Hallgatói Önkormányzat (HÖK) EMTE Marosvásárhely">
	<meta name="keywords" content="Műszaki Tudományos Diákköri Konferencia Temesvár hírek" >
	<meta property="og:title" content="TDK Tudományos Diákköri Konferencia Sapientia EMTE" >
	<meta property="og:type" content="website" >
	<meta property="og:url" content="http://localhost:8080" >
	<meta property="og:site_name" content="localhost" >
	<meta property="og:description" content="Műszaki Tudományos Diákköri Konferencia Temesvár hírek" >
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
				<h1>Hírek</h1>
				<p><strong><em>XXV. Erd&eacute;lyi Műszaki Tudom&aacute;nyos Di&aacute;kk&ouml;ri Konferencia</em></strong></p>
				<p><em><strong>2024. m&aacute;jus 10-12</strong>.</em></p>
				<p style="text-align: justify;">A Temesv&aacute;ri Magyar Di&aacute;kszervezet (TMD) &eacute;s a Sapientia EMTE Marosv&aacute;s&aacute;rhelyi Kar&aacute;nak Hallgat&oacute;i &Ouml;nkorm&aacute;nyzata (msH&Ouml;K) az Erd&eacute;lyi Magyar Műszaki Tudom&aacute;nyos Tan&aacute;cs szakmai ir&aacute;ny&iacute;t&aacute;s&aacute;val meghirdeti a XXV. Erd&eacute;lyi Műszaki Tudom&aacute;nyos Di&aacute;kk&ouml;ri Konferenci&aacute;t (MTDK 2024). A konferencia c&eacute;lja, hogy &ouml;szt&ouml;n&ouml;zze a hallgat&oacute;i tudom&aacute;nyos di&aacute;kk&ouml;ri tev&eacute;kenys&eacute;get &eacute;s teret biztos&iacute;tson a hallgat&oacute;k p&aacute;lyamunk&aacute;inak ismertet&eacute;s&eacute;re. A konferenci&aacute;ra v&aacute;rjuk azon hallgat&oacute;k jelentkez&eacute;s&eacute;t, akik tanulm&aacute;nyaik folytat&aacute;sa mellett &ouml;nk&eacute;pz&eacute;si c&eacute;lal tudom&aacute;nyos tev&eacute;kenys&eacute;get folytatnak műszaki szakter&uuml;leten, &eacute;s annak eredm&eacute;nyeit sz&iacute;nvonalas dolgozatba foglalj&aacute;k (magyar vagy angol nyelven).</p>
				<p style="text-align: justify;">A&nbsp;XXV. Erd&eacute;lyi Műszaki Tudom&aacute;nyos Di&aacute;kk&ouml;ri Konferencia jel&ouml;l&eacute;si f&oacute;rum a 2025-ban sorra ker&uuml;lő&nbsp;37. Orsz&aacute;gos Tudom&aacute;nyos Di&aacute;kk&ouml;ri Konferenci&aacute;ra (OTDK).</p>
				<p style="text-align: justify;">A konferenci&aacute;n a p&aacute;lyamunk&aacute;k bemutat&aacute;sa magyar vagy angol nyelven t&ouml;rt&eacute;nik. A beny&uacute;jtand&oacute; dolgozatok tartalmi &eacute;s formai k&ouml;vetelm&eacute;nyei megegyeznek az OTDK műszaki szekci&oacute;j&aacute;nak elv&aacute;r&aacute;saival.&nbsp;Rem&eacute;lj&uuml;k, hogy&nbsp;a konferenci&aacute;t&nbsp;ism&eacute;t a hagyom&aacute;nyokhoz h&iacute;ven szem&eacute;lyes jelenl&eacute;ttel&nbsp;szervezhess&uuml;k meg.</p>
				<p><br />Figyelem! A konferenci&aacute;r&oacute;l magyarorsz&aacute;gi r&eacute;sztvevő nem deleg&aacute;lhat&oacute; az OTDK-ra.<br /><br /></p>
				<p><strong>A&nbsp;konferencia tervezett szakoszt&aacute;lyai:</strong></p>
				<ol>
					<li>Automatiz&aacute;l&aacute;s &eacute;s alkalmazott informatika</li>
					<li>Villamosm&eacute;rn&ouml;ki</li>
					<li>G&eacute;p&eacute;szm&eacute;rn&ouml;ki</li>
					<li>&Eacute;p&iacute;tőm&eacute;rn&ouml;ki &eacute;s &Eacute;p&iacute;t&eacute;sz</li>
					<li>Vegy&eacute;szm&eacute;rn&ouml;ki</li>
					<li>K&ouml;nnyűipari m&eacute;rn&ouml;ki</li>
					<li>Bolyai TDK</li>
					<li>Poszter-szesszi&oacute; (k&ouml;z&eacute;piskol&aacute;sok &eacute;s I. &eacute;ves egyetemist&aacute;k r&eacute;sz&eacute;re)</li>
				</ol>
				<p>Figyelem! A be&eacute;rkezett dolgozatok t&eacute;mak&ouml;re alapj&aacute;n a tervezett szakoszt&aacute;lyok m&oacute;dosulhatnak, illetve &uacute;j szakoszt&aacute;lyok is indulhatnak.<br /><br /><strong>MTDK fontos időpontok:</strong></p>
				<ul>
					<li>Előzetes regisztr&aacute;ci&oacute;:&nbsp;<span style="background-color: #ffffff;"><strong>2024. &aacute;prilis 5.</strong></span></li>
					<li><span style="background-color: #ffffff;">Kivonat lead&aacute;sa: <strong>2024. &aacute;prilis 5.</strong></span></li>
					<li>P&aacute;lyamunka felt&ouml;lt&eacute;se:<strong>2024. &aacute;prilis 15</strong></li>
					<li>A konferencia időpontja: <strong>2024. m&aacute;jus</strong><strong>&nbsp;10-12.</strong></li>
				</ul>
				<p>Az MTDK hivatalos Facebook oldala: <a href="https://www.facebook.com/MTDKTM/" target="_blank"><img src="https://mtdk.tmd.ro/docs/facebook.png" alt="" width="20" height="20" /></a></p>
				<p>Az MTDK posztere&nbsp;el&eacute;rhető&nbsp;<a href="https://drive.google.com/file/d/1FfRHVXGMAcIGrn6Q6uVf2S3hC100g1x2/view?usp=s haring" target="_blank">itt.</a></p>
				<p>A konferenci&aacute;ra minden p&aacute;ly&aacute;z&oacute;t, &eacute;rdeklődőt szeretettel v&aacute;runk!</p>
				<p><strong>Az MTDK szervező bizotts&aacute;ga</strong></p>
				<p>&nbsp;</p>
				<p>Ha technikai gondjai vannak a honlappal a <strong>tdkadmin kukac ms pont sapientia</strong> pont ro c&iacute;mre &iacute;rjon.</p>
				<p>&nbsp;</p>
				<p>&nbsp;</p>
			</div>
			<div class="cb"></div>
		</div>
		<div class="footer-container">
			<div class="sponsors">
				<a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images\logo3.png" /></a><a href="www.tmd.ro" target="_blank"><img height="30" src="images\tmdlogo.jpg" /></a><a href="http://mshok.ro/" target="_blank"><img height="30" src="images/logo2.png" /></a><a href="http://www.upt.ro/" target="_blank"><img height="30" src="images\upt.jpg" /></a><a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images\logo5.png" /></a><a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images\obudalogo.jpg" /></a><a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images\logo8.png" /></a><a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images\partner_logo_omdsz.png" /></a><a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images\otdk_logo_piros.jpg" /></a><a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images\logo9.png" /></a><a href="http://ofi.hu/" target="_blank"><img height="30" src="images\logo4.png" /></a>    
			</div>
		</div>
	</div>
</body>
</html>
