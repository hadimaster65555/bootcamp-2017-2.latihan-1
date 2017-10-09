<%-- 
    Document   : addRawat
    Created on : Oct 8, 2017, 11:12:52 PM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tambahkan Pasien Rawat</title>
    </head>
    <body>
        <h1>Tambahkan Pasien Rawat</h1>
        <form action="${pageContext.servletContext.contextPath}/rawat/new" method="post">
            <div>
                <label for="pasienId">Nama Pasien</label>
                <select name="pasienId" id="pasienId">
                    <c:forEach items="${listPasien}" var="pasien">
                        <option value="${pasien.id}">${pasien.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="dokterId">Nama Dokter</label>
                <select name="dokterId" id="dokterId">
                    <c:forEach items="${listDokter}" var="dokter">
                        <option value="${dokter.id}">${dokter.nama} (${dokter.spesialis})</option>
                    </c:forEach>
                </select>   
            </div>
            <div>
                <label for="ruangId">Nomor Ruangan</label>
                <select name="ruangId" id="ruangId">
                    <c:forEach items="${listRuang}" var="ruang">
                        <option value="${ruang.id}">${ruang.no_ruangan} (${ruang.kosong})</option>
                    </c:forEach>
                </select>   
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="submit">Reset</button>
            </div>
        </form>
    </body>
</html>
