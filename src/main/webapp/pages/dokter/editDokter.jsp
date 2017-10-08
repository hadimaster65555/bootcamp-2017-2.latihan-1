<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Informasi Dokter</title>
    </head>
    <body>
        <h1>Update Informasi Dokter</h1>
        <form action="${pageContext.servletContext.contextPath}/dokter/update" method="post">
            <input type="hidden" name="id" value="${dokter.id}"/>
        <div>
            <label for="nama">Nama Dokter:</label>
                <input type="text" name="nama" id="nama" value="${dokter.nama}"/>
        </div>
        <div>
            <label for="spesialis">Spesialis:</label>
            <input type="text" name="spesialis" id="spesialis" value="${dokter.spesialis}"/>
        </div>
        <div>
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </div>
        </form>
    </body>
</html>
