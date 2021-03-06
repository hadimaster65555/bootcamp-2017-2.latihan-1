<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Laman Pendaftaran Pasien</title>
    </head>
    <body>
        <h1>Halaman Tambah Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/new" method="post">
              <div>
                  <label for="namaPasien">Nama Pasien</label>
                  <input type="text" name="namaPasien" id="namaPasien"/>
              </div>
              <div>
                  <label for="alamatPasien">Alamat Pasien</label>
                  <input type="text" name="alamatPasien" id="alamatPasien"/>
            </div>
              <div>
                  <label for="tanggalLahir">Tanggal Lahir</label>
                  <input type="text" name="tanggalLahir" id="tanggalLahir" pattern="^(19[5-9][0-9]|20[0-9][0-9]|2999)[-](0?[1-9]|1[0-2])[-](0?[1-9]|[12][0-9]|3[01])$"/>
            </div>
              <div>
                  <button type="submit">Tambah</button>
                  <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
