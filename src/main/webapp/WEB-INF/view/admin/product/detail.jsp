<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content />
        <meta name="author" content />
        <title>Admin Nguyễn Đình Thắng</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js"
            crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Orders</h1>
                        <ol class="breadcrumb">
                          <li class="breadcrumb-item"><a href="/admin">Dashboard</a></li>
                          <li class="breadcrumb-item active" aria-current="page">Orders</li>
                        </ol>
                        <div class="row">
                            <div class="col-12 mx-auto">
                                <div class="d-flex border-bottom justify-content-between mb-3">
                                    <h2>User detail where id = ${id}</h2>
                                </div>
                                <div class="card" style="width: 60%;">
                                    <div class="card-header">
                                        <img src="/images/product/${product.image}" alt="">
                                    User information
                                    </div>
                                    <ul class="list-group list-group-flush">
                                    <li class="list-group-item">Id: ${id}</li>
                                    <li class="list-group-item">Name: ${product.name}</li>
                                    <li class="list-group-item">Price: ${product.price}</li>
                                    </ul>
                                   </div>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="../layout/footer.jsp" />
            </div>
        </div>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
