<%@ page import="JavaClasses.DolgozatDiakDAO,JavaClasses.Dolgozat,JavaClasses.DiakServlet,JavaClasses.DolgozatDAO,JavaClasses.DolgozatDAO,java.util.List,java.util.ArrayList" %>
<!doctype html>
<html lang="hu">
<head>
    <meta charset="UTF-8">
    <title>Tudom�nyos Di�kk�ri Konferencia - Sapientia EMTE - Marosv�s�rhely- H�rek</title>
    <meta name="description" content="M?szaki Tudom�nyos Di�kk�ri Konferencia Temesv�r h�rek ">
    <meta name="author" content="Hallgat�i �nkorm�nyzat (H�K) EMTE Marosv�s�rhely">
    <meta name="keywords" content="M?szaki Tudom�nyos Di�kk�ri Konferencia Temesv�r h�rek" >
    <meta property="og:title" content="TDK Tudom�nyos Di�kk�ri Konferencia Sapientia EMTE" >
    <meta property="og:type" content="website" >
    <meta property="og:url" content="http://localhost:8080" >
    <meta property="og:site_name" content="localhost" >
    <meta property="og:description" content="M?szaki Tudom�nyos Di�kk�ri Konferencia Temesv�r h�rek" >
    <link rel="stylesheet" type="text/css" href="site.css">
    <script>
        // Function to sort table columns
        let sortDirections = {};

        function sortTable(n) {
            var table, rows, switching, i, x, y, shouldSwitch, dir, switchcount = 0;
            table = document.getElementById("dolgozatokTable");
            switching = true;

            // Initialize direction to ascending or toggle it
            dir = sortDirections[n] === "asc" ? "desc" : "asc";
            sortDirections[n] = dir;

            while (switching) {
                switching = false;
                rows = table.rows;

                for (i = 1; i < (rows.length - 1); i++) {
                    shouldSwitch = false;
                    x = rows[i].getElementsByTagName("TD")[n];
                    y = rows[i + 1].getElementsByTagName("TD")[n];

                    if (dir === "asc") {
                        if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
                            shouldSwitch = true;
                            break;
                        }
                    } else if (dir === "desc") {
                        if (x.innerHTML.toLowerCase() < y.innerHTML.toLowerCase()) {
                            shouldSwitch = true;
                            break;
                        }
                    }
                }
                if (shouldSwitch) {
                    rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
                    switching = true;
                    switchcount++;
                } else {
                    if (switchcount === 0 && dir === "asc") {
                        dir = "desc";
                        switching = true;
                    }
                }
            }
        }
    </script>
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
            <h1>Dolgozatok List�ja</h1>
            <a href="https://drive.google.com/drive/folders/1s6EJJln9msU2uqRr7jJEstvdewXqgc8x" target="_blank">Kivonatok �s Projektek</a>
           <table border="1" id="dolgozatokTable">
                <thead>
                    <tr>
                        <th onclick="sortTable(0)">ID</th>
                        <th onclick="sortTable(1)">C�m</th>
                        <th onclick="sortTable(2)">Kateg�ria</th>
                        <th onclick="sortTable(3)">Vezet? Tan�rok</th>
                        <th onclick="sortTable(4)">Elfogadva</th>
                        <th onclick="sortTable(5)">Jegy</th>
                    </tr>
                </thead>
                 <tbody>
            <% 
                Integer diakId = (Integer) session.getAttribute("diak_id");
                List<Integer> dolgozatIds = DolgozatDiakDAO.getDolgozatIdsByDiakId(diakId);
     // out.println("<script>alert('Diak ID: " + diakId + "');</script>");
            
              out.println("<script type=\"text/javascript\">");
           out.println("alert('Dolgozat IDs: '+ 'diakId');"+dolgozatIds+diakId);
             out.println("window.location.href = 'Dolgozatok.jsp';");
            out.println("</script>");
for (Integer dolgozatId : dolgozatIds) {
    Dolgozat dolgozat = DolgozatDiakDAO.getDolgozatById(dolgozatId);
    System.out.println("Dolgozat: " + dolgozat);
}
                if (dolgozatIds == null || dolgozatIds.isEmpty()) {
            %>
                <tr>
                    <td colspan="6">Nincs el�rhet? dolgozat.</td>
                </tr>
            <% } else {
                    for (int i = 0; i < dolgozatIds.size(); i++) {
                                Integer dolgozatId = dolgozatIds.get(i);
                                Dolgozat dolgozat = DolgozatDiakDAO.getDolgozatById(dolgozatId);
                                if (dolgozat != null) {
            %>
                <tr>
                    <td><%= dolgozat.getDolgozatId() %></td>
                    <td><%= dolgozat.getCim() %></td>
                    <td><%= dolgozat.getKategoria() %></td>
                    <td><%= dolgozat.getVezetoTanarok() %></td>
                    <td><%= dolgozat.isElfogadva() ? "Igen" : "Nem" %></td>
                    <td><%= dolgozat.getJegy() %></td>
                </tr>
            <%         }
                   }
                }
            %>
             <tr>
                        <td colspan="6">
                            <a href="UjDolgozat.jsp">�j Dolgozat L�trehoz�sa</a>
                        </td>
                    </tr>
        </tbody>
            </table>
             
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
