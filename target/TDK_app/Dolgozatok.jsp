<%-- 
    Document   : Dolgozatok
    Created on : Mar 26, 2024, 4:22:43 PM
    Author     : misim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
                                                        <div class='logged-in-user'>
                                    <span style="color:white;">Üdvözlünk, Próba!
                                         <a style="color:white;" href = "https://mtdk.tmd.ro/index.php/site/logout/">(Kilépés)</a>
                                    </span>
                                </div>
                                			<div class="header"></div>
			<div class="menu">
				<ul>
				<li><a href="Hirek.jsp" >Hírek</a></li><li><a href="Program.jsp">Program</a></li><li><a href="Szakosztalyok.jsp" >Szakosztályok</a></li><li><a href="Formai_Kovetelmenyek.jsp" >Formai követelmények</a></li><li><a href="Dokumentumok.jsp" >Dokumentumok</a></li><li class="active"><a href="Dolgozatok.jsp">Dolgozatok</a></li><li><a href="Archivum.jsp" >Archívum</a></li><li><a href="Ro.jsp" >Ro</a></li><li><a href="Eng.jsp" >Eng</a></li>					
					<!-- <li class="active"><a href="#" >aktiv menü</a></li> -->
				</ul>
			</div>
		</div>
                <div class="content-container">
<link rel="stylesheet" href="https://mtdk.tmd.ro/assets/css/bootstrap.min.css">
<link rel="stylesheet" href="https://mtdk.tmd.ro/assets/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://mtdk.tmd.ro/assets/js/bootstrap.min.js"></script>

  <style>
  .panel-heading{background-image: none!important}
  .panel-success{border-color: #D2CBC9}
  .panel-success > .panel-heading{background-color: #D2CBC9; color: #695352;}
  .padded{padding-top: 7px;}
  </style>


<!-- popup start -->
<!-- Modal -->
<div class="modal fade" id="addNew" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title" id="myModalLabel">Új dolgozat regisztrálása</h4>
      </div>
      <form method="post" action="https://mtdk.tmd.ro/index.php/site/save_new_project">
      <div class="modal-body">     
          <label for="title">Dolgozat címe:</label>     
          <input type="text" name="title" class="form-control" placeholder="Cím" required><br>
         
          <div class="padded"><label for="category">Dolgozat kategóriája:</label></div>
          <div class="padded">
          <select name="category" style="padding: 5px">
                                <option value="37">Alkalmazott informatika</option>
                                <option value="38">Villamosmérnöki</option>
                                <option value="39">Építő- és építészmérnöki</option>
                                <option value="40">Gépészmérnöki</option>
                                <option value="41">Vegyészmérnöki</option>
                                <option value="42">Poszter</option>
                                <option value="44">Könnyűipari mérnöki</option>
                                <option value="45">Bolyai Szakkollégium</option>
                                      </select>
          </div>
          <div class="padded">
          <input type="checkbox" style="vertical-align: top;" id="new_category_check" name="new_category_check" vlaue="1" class="btn btn-default"> <label style="font-weight: normal; vertical-align: baseline;" for="new_category_check">Új kategória ajánlása</label>
          </div>
          <div id="new_category_sec" style="display:none;" class="padded">
            <label for="new_category_text">Kategória megnevezése:</label>
            <input type="text" id="new_category_text" name="new_category_text" class="form-control" placeholder="Kategória megnevezése">
          </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
        <button type="submit" class="btn btn-primary">Tovább a második lépésre <span class="glyphicon glyphicon-chevron-right"></span></button>
      </div>
      </form>
    </div>
  </div>
</div>
<!-- popup end -->

<script type="text/javascript">
  $(document).ready(function(){
      $("#new_category_check").change(function(){
          if($(this).is(":checked")){
              $("#new_category_sec").show();
              $("#new_category_text").attr("required","true");
          }else{
              $("#new_category_sec").hide();
              $("#new_category_text").removeAttr("required");
          }
      });
  });
</script>

<div>
  <h1 style="margin-top: 0px; padding-top: 0px;">Dolgozatok</h1>
  <button type="button" class="btn btn-success pull-right btn-sm" data-toggle="modal" data-target="#addNew"><span class="glyphicon glyphicon-plus"></span> Új dolgozat regisztrálása</button>
</div>

<div class="panel panel-success">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
            Regisztrált dolgozataid listája
          </a>
        </h4>
      </div>
      <div class="panel-collapse">
        <div class="panel-body">
<table class="table table-hover">
  <thead>
    <tr>
      <th>Cím</th>
      <th>Kivonat</th>      
      <th>Kategória</th>      
      <th>Szerzők</th>
      <th style="width: 150px">Vezető tanárok</th>
      <th style="width: 140px">Eszközök</th>
    </tr>
  </thead>
  <tbody>
                <tr>
          <td><b><a href="https://mtdk.tmd.ro/index.php/site/edit_project?ref=NDQx" >Proba dolgozat</a></b></td>
            <td><small></small></td>
              <td><small>
                  Villamosmérnöki</small>
              </td>
              <td><small>
                  Géczi Szabolcs Próba</small>
              </td>             
              <td><small>
                  </small>
              </td>
              <td>                
                  <form method="post" action="https://mtdk.tmd.ro/index.php/site/remove_project" style="display: inline-block;" onsubmit="return confirm('Valóban törölni szeretnéd ezt a dolgozatot?');">
                    <input type="hidden" name="projectid" value="NDQx">
                    <button type="submit" class="btn btn-default btn-xs"><span class="glyphicon glyphicon-trash"></span></button>
                </form>
                  <button type="button" onclick="javascript:window.location.href='https://mtdk.tmd.ro/index.php/site/edit_project?ref=NDQx'" class="edstig btn btn-default btn-xs"><span class="glyphicon glyphicon-pencil"></span> Szerkesztés</button>                                                  
              </td>
          </tr>
        </tbody>
</table>
</div>
</div>
</div></div>

<div class="footer-container">
    <div class="sponsors">
        <a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images\logo3.png" /></a><a href="www.tmd.ro" target="_blank"><img height="30" src="images\tmdlogo.jpg" /></a><a href="http://mshok.ro/" target="_blank"><img height="30" src="images/logo2.png" /></a><a href="http://www.upt.ro/" target="_blank"><img height="30" src="images\upt.jpg" /></a><a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images\logo5.png" /></a><a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images\obudalogo.jpg" /></a><a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images\logo8.png" /></a><a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images\partner_logo_omdsz.png" /></a><a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images\otdk_logo_piros.jpg" /></a><a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images\logo9.png" /></a><a href="http://ofi.hu/" target="_blank"><img height="30" src="images\logo4.png" /></a>    </div>
</div>

</div>

</body>
</html>
