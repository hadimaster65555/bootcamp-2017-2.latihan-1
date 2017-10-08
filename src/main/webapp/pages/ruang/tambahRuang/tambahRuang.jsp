<%-- 
    Document   : tambahDokter
    Created on : Oct 7, 2017, 9:00:07 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
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
                  <input type="text" name="no_ruangan" id="no_ruangan"/>
              </div>
              <div>
                  <label for="kosong" pl>Ketersediaan:</label>
                  <select name="kosong">
                      <option value="FALSE">Terisi</option>
                      <option value="TRUE">Kosong</option>
                  </select>
              </div>
              <div>
                  <button type="submit">Tambah</button>
                  <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
