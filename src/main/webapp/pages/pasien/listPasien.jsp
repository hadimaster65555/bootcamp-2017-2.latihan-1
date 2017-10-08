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
        <title>Daftar Pasien</title>
    </head>
    <body>
        <h1>Daftar Pasien</h1>
        <table>
            <thead>
                <tr>
                    <td>No</td>
                    <td>Nama Pasien</td>
                    <td>Alamat Pasien</td>
                    <td>Tanggal Lahir Pasien</td>
                    <td>Perintah</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listPasien}" var="daftarPasien" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${daftarPasien.nama}</td>
                        <td>${daftarPasien.alamat}</td>
                        <td>${daftarPasien.tanggal_lahir}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/pasien/delete?kode_pasien=${daftarPasien.id}">Hapus</a>
                            <a href="${pageContext.servletContext.contextPath}/pasien/update?kode_pasien=${daftarPasien.id}">Ubah</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <a class="btn btn-lg" href="/latihan-1/index.html" role="button">Kembali ke Halaman Utama</a>
             <br>
            <a class="btn btn-lg" href="${pageContext.servletContext.contextPath}/pasien/new" role="button">Tambah Ruangan</a>
    </body>
</html>
