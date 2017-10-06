<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ubah Data Pasien</title>
    </head>
    <body>
        <h1>Ubah Data Pasien</h1>
        <form action="${pageContext.servletContext.contextPath}/pasien/ubah" method="post">
            <input type="hidden" name="id" value="${}"
        </form>
    </body>
</html>
