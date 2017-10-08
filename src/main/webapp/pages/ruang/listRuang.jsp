<%-- 
    Document   : listRuang
    Created on : Oct 8, 2017, 4:33:44 PM
    Author     : USER
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/bootstrap.min.css">
        <title>Daftar Ruangan Yang Tersedia</title>
    </head>
    <body>
        <h1>Daftar Ruangan yang Tersedia</h1>
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nomor Ruangan</td>
                    <td>Keterangan</td>
                    <td>Aksi</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listRuang}" var="listRuang" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${listRuang.no_ruangan}</td>
                        <td>
                            <c:if test="${listRuang.kosong!=true}">
                                <c:out value="Kamar Terisi"/>
                            </c:if>
                            <c:if test="${listRuang.kosong==true}">
                                <c:out value="Kamar Kosong"/>
                            </c:if>
                        </td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/ruang/delete?kode_ruang=${listRuang.id}">Hapus</a>
                            <a href="${pageContext.servletContext.contextPath}/ruang/update?kode_ruang=${listRuang.id}">Ubah</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a class="btn btn-lg" href="/latihan-1/index.html" role="button">Kembali ke Halaman Utama</a>
        <br>
        <a class="btn btn-lg" href="${pageContext.servletContext.contextPath}/ruang/new" role="button">Tambah Ruangan</a>
    </body>
</html>
