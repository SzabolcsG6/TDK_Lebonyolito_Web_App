<%-- 
    Document   : DolgozatokSzerkesztes
    Created on : Mar 26, 2024, 4:22:55 PM
    Author     : misim
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="hu">
<head>
	<meta charset="UTF-8">
	<title>Tudományos Diákköri Konferencia - Sapientia EMTE - Marosvásárhely- Dolgozatok kezelése!</title>

	<meta name="description" content=" ">
	<meta name="author" content="Hallgatói Önkormányzat (HÖK) EMTE Marosvásárhely">

	<meta name="keywords" content="" >

	<meta property="og:title" content="TDK Tudományos Diákköri Konferencia Sapientia EMTE" >
	<meta property="og:type" content="website" >
	<meta property="og:url" content="http://localhost:8080" >
	<meta property="og:site_name" content="localhost" >
	<meta property="og:description" content="" >

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
                                    <span style="color:white;">Üdvözlünk, Géczi Szabolcs Próba!
                                         <a style="color:white;" href = "https://mtdk.tmd.ro/index.php/site/logout/">(Kilépés)</a>
                                    </span>
                                </div>
                                			<div class="header"></div>
			<div class="menu">
				<ul>
				<li><a href="Hirek.jsp" >Hírek</a></li><li><a href="Szakosztalyok.jsp" >Szakosztályok</a></li><li><a href="Formai_Kovetelmenyek.jsp" >Formai követelmények</a></li><li><a href="Dokumentumok.jsp" >Dokumentumok</a></li><li><a href="Jelentkezes.jsp" >Jelentkezés</a></li><li><a href="Archivum.jsp" >Archívum</a></li><li class="active"><a href="Ro.jsp" >Ro</a></li><li><a href="Eng.jsp" >Eng</a></li>					
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
  .padded{padding-top: 17px;}
  </style>

  <!-- popup start edit title -->
  <!-- Modal -->
  <div class="modal fade" id="Edit_title" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Dolgozat címének szerkesztése</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/edit_project_title">
        <div class="modal-body">          
            <input type="hidden" name="edit_id_em" id="edit_title_em_dt" value="NDQx">
            <label for="edit_title_em">Dolgozat címe:</label>
            <input type="text" class="form-control" id="edit_title_em" name="edit_title_em" value="Proba dolgozat">
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->

  <!-- popup start add new author -->
  <!-- Modal -->
  <div class="modal fade" id="addNewAuthor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Szerző hozzáadása a dolgozathoz</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/add_new_author_to_project">
        <div class="modal-body">          
            <input type="hidden" name="anapi" id="na_anapi">
            <div class="padded">
            <label for="na_name">Teljes név:</label>
            <input type="text" class="form-control" id="na_name" name="na_name" placeholder="Teljes név" required>
            </div>
            <div class="padded">
            <label for="na_email">E-mail cím:</label>
            <input type="text" class="form-control" id="na_email" name="na_email" placeholder="E-mail cím" required>
            </div>
            <div class="padded">
            <label for="na_university">Egyetem:</label>
            <input type="text" class="form-control" id="na_university" name="na_university" placeholder="Egyetem" required>
            </div>
            <div class="padded">
            <label for="na_department">Kar:</label>
            <input type="text" class="form-control" id="na_department" name="na_department" placeholder="Kar" required>
            </div>
            <div class="padded">
            <label for="na_profile">Szak:</label>
            <input type="text" class="form-control" id="na_profile" name="na_profile" placeholder="Szak" required>
            </div>
            <div class="padded">
            <label for="na_year">Évfolyam:</label>
            <input type="text" class="form-control" id="na_year" name="na_year" placeholder="Évfolyam" required>
            </div>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->

  <!-- popup start add new teacher -->
  <!-- Modal -->
  <div class="modal fade" id="addNewTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Vezető tanár hozzáadása a dolgozathoz</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/add_new_teacher_to_project">
        <div class="modal-body">          
            <input type="hidden" name="nt_anapi" id="nt_anapi">
            <div class="padded">
            <label for="nt_name">Teljes név:</label>
            <input type="text" class="form-control" id="nt_name" name="nt_name" placeholder="Teljes név" required>
            </div>
            <div class="padded">
            <label for="nt_email">E-mail cím:</label>
            <input type="text" class="form-control" id="nt_email" name="nt_email" placeholder="E-mail cím" required>
            </div>
            <div class="padded">
            <label for="nt_university">Egyetem:</label>
            <input type="text" class="form-control" id="nt_employment" name="nt_employment" placeholder="Egyetem" required>
            </div>
            <div class="padded">
            <label for="nt_department">Beosztás:</label>
            <input type="text" class="form-control" id="nt_job_title" name="nt_job_title" placeholder="Beosztás" required>
            </div>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->

  <!-- popup start edit author -->
  <!-- Modal -->
  <div class="modal fade" id="EditAuthor" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Szerző adatainak szerkesztése</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/edit_author_of_project">
        <div class="modal-body">          
            <input type="hidden" name="ed_anapi" id="ed_anapi">
            <input type="hidden" name="eda_anapi" id="eda_anapi">
            <div class="padded">
            <label for="na_name">Teljes név:</label>
            <input type="text" class="form-control" id="ed_name" name="ed_name" placeholder="Teljes név" required>
            </div>
            <div class="padded">
            <label for="na_email">E-mail cím:</label>
            <input type="text" class="form-control" id="ed_email" name="ed_email" placeholder="E-mail cím" required>
            </div>
            <div class="padded">
            <label for="na_university">Egyetem:</label>
            <input type="text" class="form-control" id="ed_university" name="ed_university" placeholder="Egyetem" required>
            </div>
            <div class="padded">
            <label for="na_department">Kar:</label>
            <input type="text" class="form-control" id="ed_department" name="ed_department" placeholder="Kar" required>
            </div>
            <div class="padded">
            <label for="na_profile">Szak:</label>
            <input type="text" class="form-control" id="ed_profile" name="ed_profile" placeholder="Szak" required>
            </div>
            <div class="padded">
            <label for="na_year">Évfolyam:</label>
            <input type="text" class="form-control" id="ed_year" name="ed_year" placeholder="Évfolyam" required>
            </div>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->

  <!-- popup start edit teacher -->
  <!-- Modal -->
  <div class="modal fade" id="EditTeacher" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Vezető tanár adatainak a szerkesztése</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/edit_teacher_of_project">
        <div class="modal-body">          
            <input type="hidden" name="edt_anapi" id="edt_anapi">
            <input type="hidden" name="edtt_anapi" id="edtt_anapi">
            <div class="padded">
            <label for="edt_name">Teljes név:</label>
            <input type="text" class="form-control" id="edt_name" name="edt_name" placeholder="Teljes név" required>
            </div>
            <div class="padded">
            <label for="ed_email">E-mail cím:</label>
            <input type="text" class="form-control" id="edt_email" name="edt_email" placeholder="E-mail cím" required>
            </div>
            <div class="padded">
            <label for="ed_university">Egyetem:</label>
            <input type="text" class="form-control" id="edt_employment" name="edt_employment" placeholder="Egyetem" required>
            </div>
            <div class="padded">
            <label for="ed_department">Beosztás:</label>
            <input type="text" class="form-control" id="edt_job_title" name="edt_job_title" placeholder="Beosztás" required>
            </div>
            
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->

  <!-- popup start edit abstract -->
  <!-- Modal -->
  <div class="modal fade" id="EditAbstract" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title" id="myModalLabel">Kivonat szerkesztése</h4>
        </div>
        <form method="post" action="https://mtdk.tmd.ro/index.php/site/save_project_abstract">
        <div class="modal-body">          
            <input type="hidden" name="ed_abapi" id="ed_abapi">
            <input type="hidden" name="id" value="NDQx">                
            <textarea name="abstract" id="abstract" style="width: 100%" rows="10" placeholder="Kivonat"></textarea>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Bezárás</button>
          <button type="submit" class="btn btn-primary">Mentés</button>
        </div>
        </form>
      </div>
    </div>
  </div>
  <!-- popup end -->
  <a href="https://mtdk.tmd.ro/index.php/site/apply/" style="display: inline-block; margin-bottom: 7px;" ><< Vissza a dolgozatok listájára</a>
  <div class="panel-group" id="accordion">

    <div class="panel panel-success">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
            A dolgozat álltalános adatai<span class="label label-danger pull-right">Határidő: 2024-04-15</span>
          </a>
        </h4>
      </div>
      <div class="panel-collapse">
        <div class="panel-body">

          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title pull-left">A dolgozat címe</h3>
                             <button type="button" id="em_edit_title" data-id="NDQx" data-title="UHJvYmEgZG9sZ296YXQ=" class="btn btn-success btn-xs pull-right" data-toggle="modal" data-target="#Edit_title"><span class="glyphicon glyphicon-pencil"></span> Cím szerkesztése</button>
                              <div class="clearfix" ></div>
            </div>
            <div class="panel-body">
              <b>Proba dolgozat</b>
            </div>
          </div>

         
         <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title pull-left">Szerzők</h3>
                                  <button id="anabtn" type="button" class="btn btn-success btn-xs pull-right" data-toggle="modal" data-target="#addNewAuthor" data-anapi="NDQx"><span class="glyphicon glyphicon-plus"></span> Új szerző hozzáadása</button>
                                 <div class="clearfix" ></div>
            </div>
            <div class="panel-body">
              <table class="table">
                <tr>
                  <th>Név</th>
                  <th>Egyetem</th>
                  <th>Kar</th>
                  <th>Szak</th>
                  <th>Évfolyam</th>
                  <th style="width: 140px">Eszközök</th>
                </tr>
                                    <tr>
                      <td>                      
                          Géczi Szabolcs Próba                      </td>
                       <td>                      
                          Sapientia                      </td>
                       <td>                      
                          MVH                      </td>
                      <td>                      
                          Távközlés                      </td>
                      <td>                      
                          4                      </td>
                      <td>
                                                      <form method="post" action="https://mtdk.tmd.ro/index.php/site/remove_author_from_project" style="display: inline-block;" onsubmit="return confirm('Valóban törölni szeretnéd ezt a szerzőt?');">
                              <input type="hidden" name="authorid" value="NTE3">
                              <input type="hidden" name="projectid" value="NDQx">
                              <button type="submit" class="btn btn-default btn-xs"><span class="glyphicon glyphicon-trash"></span></button>
                            </form>
                            <button type="button" data-toggle="modal" data-target="#EditAuthor"
                              data-anapi = "NTE3" 
                              data-anapia = "NDQx" 
                              data-name = "Géczi Szabolcs Próba" 
                              data-email = "misi.mester94@gmail.com" 
                              data-university = "Sapientia" 
                              data-department = "MVH" 
                              data-profile = "Távközlés" 
                              data-year = "4" 
                             class="ed_apr btn btn-default btn-xs"><span class="glyphicon glyphicon-pencil"></span> Szerkesztés</button>
                                                 </td>
                    </tr>
                            </table>
            </div>
          </div>


          <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title pull-left">Vezető tanárok</h3>
                              <button id="antbtn" type="button" class="btn btn-success btn-xs pull-right" data-toggle="modal" data-target="#addNewTeacher" data-anapi="NDQx"><span class="glyphicon glyphicon-plus"></span> Új vezető tanár hozzáadása</button>
                             <div class="clearfix" ></div>
            </div>
            <div class="panel-body">
              <table class="table">
                <tr>
                  <th>Név</th>
                  <th>Egyetem</th>
                  <th>Beosztás</th>
                  <th style="width: 140px">Eszközök</th>
                </tr>
                            </table> 
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="panel panel-success">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
            A dolgozat kivonata (sima szöveg formátumban)<span class="label label-danger pull-right">Határidő: 2024-04-15</span>
          </a>
        </h4>
      </div>
      <div class="panel-collapse">
        <div class="panel-body">
            <div class="panel panel-default">
            <div class="panel-heading">
              <h3 class="panel-title pull-left">A dolgozat kivonata</h3>
                              <button type="button" id="em_edit_abstract" data-toggle="modal" data-target="#EditAbstract" data-text="" data-abapi="NDQx" class="btn btn-success btn-xs pull-right" ><span class="glyphicon glyphicon-pencil"></span> Kivonat szerkesztése</button>
                            <div class="clearfix" ></div>
            </div>
            <div class="panel-body">
                        </div>
          </div>
        </div>
      </div>
    </div>

    <div class="panel panel-success">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
            A dolgozat feltöltése<span class="label label-danger pull-right">Határidő: 2024-04-15</span>
          </a>
        </h4>
      </div>
      <div class="panel-collapse">
        <div class="panel-body">
          <form enctype="multipart/form-data" method="POST" action="https://mtdk.tmd.ro/index.php/site/do_upload">
                      <div class="padded" >
                            <p>A dolgozatot PDF formátumban lehet feltölteni.</p>
              <input type="file" name="userfile" size="20" class="btn btn-default"/>
              <input type="hidden" name="ref" value="NDQx"/>
            </div>
            <div class="padded" ><input class="btn btn-success" type="submit" value="Dolgozat feltöltése" /></div>
                    <div class="padded" >
                    </div>
          </form>
        </div>
      </div>
    </div>  

  </div>

  <script type="text/javascript">
    $(document).ready(function(){      
      $("#anabtn").click(function(){
        var anapi = $(this).attr("data-anapi");
        $("#na_anapi").val(anapi);
      });
      $("#antbtn").click(function(){
        var anapi = $(this).attr("data-anapi");
        $("#nt_anapi").val(anapi);
      });
      $(".ed_apr").click(function(){
        var edaid = $(this).attr("data-anapi");
        var edaida = $(this).attr("data-anapia");
        var edaname = $(this).attr("data-name");
        var edaemail = $(this).attr("data-email");
        var edauniversity = $(this).attr("data-university");
        var edadepartment = $(this).attr("data-department");
        var edaprofile = $(this).attr("data-profile");
        var edayear = $(this).attr("data-year");
        $("#ed_anapi").val(edaid);
        $("#eda_anapi").val(edaida);
        $("#ed_name").val(edaname);
        $("#ed_email").val(edaemail);
        $("#ed_university").val(edauniversity);
        $("#ed_department").val(edadepartment);
        $("#ed_profile").val(edaprofile);
        $("#ed_year").val(edayear);
      });
      $(".ed_tpr").click(function(){
        var edtid = $(this).attr("data-anapi");
        var edtidt = $(this).attr("data-anapia");
        var edtname = $(this).attr("data-name");
        var edtemail = $(this).attr("data-email");
        var edtemployment = $(this).attr("data-employment");
        var edtjob_title = $(this).attr("data-job_title");
        
        $("#edt_anapi").val(edtid);
        $("#edtt_anapi").val(edtidt);
        $("#edt_name").val(edtname);
        $("#edt_email").val(edtemail);
        $("#edt_employment").val(edtemployment);
        $("#edt_job_title").val(edtjob_title);
        
      });
      $("#em_edit_abstract").click(function(){
        var abapi = $(this).attr("data-abapi");      
        $("#ed_abapi").val(abapi);      
      });
    });
  </script>
</div>

<div class="footer-container">
    <div class="sponsors">
        <a href="http://fundatiapolitehnica.ro/" target="_blank"><img height="30" src="images\logo3.png" /></a><a href="www.tmd.ro" target="_blank"><img height="30" src="images\tmdlogo.jpg" /></a><a href="http://mshok.ro/" target="_blank"><img height="30" src="images/logo2.png" /></a><a href="http://www.upt.ro/" target="_blank"><img height="30" src="images\upt.jpg" /></a><a href="www.ms.sapientia.ro" target="_blank"><img height="30" src="images\logo5.png" /></a><a href="http://uni-obuda.hu/" target="_blank"><img height="30" src="images\obudalogo.jpg" /></a><a href="tmdalapitvany.freeweb.hu" target="_blank"><img height="30" src="images\logo8.png" /></a><a href="https://www.facebook.com/omdsz/" target="_blank"><img height="30" src="images\partner_logo_omdsz.png" /></a><a href="http://www.otdt.hu/hu/cms/otdk/" target="_blank"><img height="30" src="images\otdk_logo_piros.jpg" /></a><a href="http://www.kormany.hu/hu/emberi-eroforrasok-miniszteriuma" target="_blank"><img height="30" src="images\logo9.png" /></a><a href="http://ofi.hu/" target="_blank"><img height="30" src="images\logo4.png" /></a>    </div>
</div>

</div>

</body>
</html>