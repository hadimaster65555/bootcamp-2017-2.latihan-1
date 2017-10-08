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
        <title>Halaman Tambah Ruang</title>
    </head>
    <body>
        <h1>Halaman Tambah Ruang</h1>
        <form action="${pageContext.servletContext.contextPath}/ruang/new" method="post">
              <div>
                  <label for="no_ruang">Nomor Ruangan:</label>
                  <input type="text" name="no_ruang" id="no_ruang"/>
              </div>
              <div>
                  <label for="kosong">Spesialis:</label>
                  <input type="text" name="kosong" id="kosong"/>
              </div>
              <div>
                  <button type="submit">Tambah</button>
                  <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
