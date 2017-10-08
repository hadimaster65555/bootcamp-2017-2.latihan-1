<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Informasi Ruangan</title>
    </head>
    <body>
        <h1>Update Informasi Ruangan</h1>
        <form action="${pageContext.servletContext.contextPath}/ruang/update" method="post">
            <input type="hidden" name="id" value="${ruang.id}"/>
        <div>
            <label for="no_ruangan">Nomor Ruangan:</label>
                <input type="text" name="no_ruangan" id="no_ruangan" value="${ruang.no_ruangan}"/>
        </div>
        <div>
            <label for="kosong">Ketersediaan Ruang:</label>
              <select name="kosong">
                  <option value="FALSE">Terisi</option>
                  <option value="TRUE">Kosong</option>
              </select>
        </div>
        <div>
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </div>
        </form>
    </body>
</html>
