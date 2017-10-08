<%-- 
    Document   : listPasien
    Created on : Oct 6, 2017, 8:53:18 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false" language="java"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Dokter</title>
    </head>
    <body>
        <h1>Daftar Dokter</h1>
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Dokter</td>
                    <td>Spesialisasi Dokter</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDokter}" var="daftarDokter" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${daftarDokter.nama}</td>
                        <td>${daftarDokter.spesialis}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/dokter/delete?kode_dokter=${daftarDokter.id}">Hapus</a>
                            <a href="${pageContext.servletContext.contextPath}/dokter/update?kode_dokter=${daftarDokter.id}">Ubah</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                <a class="btn btn-lg" href="/latihan-1/index.html" role="button">Kembali ke Halaman Utama</a>
                 <br>
                <a class="btn btn-lg" href="${pageContext.servletContext.contextPath}/dokter/new" role="button">Tambah Ruangan</a>

    </body>
</html>
