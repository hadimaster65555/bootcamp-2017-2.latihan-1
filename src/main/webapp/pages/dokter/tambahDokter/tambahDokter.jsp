<%-- 
    Document   : tambahDokter
    Created on : Oct 7, 2017, 9:00:07 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Halaman Tambah Dokter</title>
    </head>
    <body>
        <h1>Halaman Tambah Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/new" method="post">
              <div>
                  <label for="namaDokter">Nama Dokter</label>
                  <input type="text" name="namaDokter" id="namaDokter"/>
              </div>
              <div>
                  <label for="spesialis">Spesialis</label>
                  <input type="text" name="spesialisDokter" id="spesialisDokter"/>
            </div>
              <div>
                  <button type="submit">Tambah</button>
                  <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
