<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Pasien Rawat</title>
    </head>
    <body>
        <h1>Daftar Pasien Rawat</h1>
        <table>
        <thead>
            <tr>
                <td>No</td>
                <td>Nama Pasien</td>
                <td>Nomor Ruangan</td>
                <td>Nama Dokter</td>
                <td>Waktu Register</td>
                <td>Aksi</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listRawat}" var="listRawat" varStatus="idx">
                <tr>
                    <td>${idx.count}</td>
                    <td>${listRawat.pasien.nama}</td>
                    <td>${listRawat.ruang.no_ruangan}</td>
                    <td>${listRawat.dokter.nama}</td>
                    <td>${listRawat.waktu_register}</td>
                    <td>
                        <c:if test="${listRawat.waktu_checkout!=null}">
                              <c:out value="Sudah Pulang"/>
                        </c:if>
                        <c:if test="${listRawat.waktu_checkout==null}">
                            <
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-lg" href="/latihan-1/index.html" role="button">Kembali ke Halaman Utama</a>
    </body>
    </html>
