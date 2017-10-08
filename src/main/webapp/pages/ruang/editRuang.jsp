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
            <label for="no_ruang">Nomor Ruangan:</label>
                <input type="text" name="no_ruang" id="no_ruang" value="${ruang.no_ruang}"/>
        </div>
        <div>
            <label for="kosong">Ketersediaan Ruang:</label>
            <input type="text" name="kosong" id="kosong" value="${ruang.kosong}"/>
        </div>
        <div>
            <button type="submit">Update</button>
            <button type="reset">Reset</button>
        </div>
        </form>
    </body>
</html>
