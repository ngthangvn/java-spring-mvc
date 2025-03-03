<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            $(document).ready(() => {
                const avatarFile = $("#imageFile");
                avatarFile.change(function (e) {
                const imgURL = URL.createObjectURL(e.target.files[0]);
                    $("#avatarPreview").attr("src", imgURL);
                    $("#avatarPreview").css({ "display": "block" });
                });
                });
        </script>
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="../layout/header.jsp" />
        <div id="layoutSidenav">
            <jsp:include page="../layout/sidebar.jsp" />
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Product</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Product</li>
                        </ol>
                        <div class="container mt-5">
                            <div class="row">
                                <div class="col-md-6 col-12 mx-auto">
                                    <h1 class="pb-3 border-bottom">Create a product</h1>
                                    <form:form method="POST" action="/admin/product/create" modelAttribute="newProduct" class="row" enctype="multipart/form-data"  >
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="errorName">
                                                    <form:errors path="name" cssClass="invalid-feedback"/>
                                                </c:set>
                                                <label for="exampleInputEmail1"
                                                    class="form-label">Name:</label>
                                                <form:input type="text" class="form-control ${not empty errorName ? 'is-invalid' : ''}"
                                                    path="name" />
                                                ${errorName}
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="errorPrice">
                                                    <form:errors path="price" cssClass="invalid-feedback"/>
                                                </c:set>
                                                <label for="exampleInputPassword1"
                                                    class="form-label">Price:</label>
                                                <form:input type="text" class="form-control ${not empty errorPrice ? 'is-invalid' : ''}"
                                                    path="price" />
                                                ${errorPrice}
                                            </div>

                                            <div class="mb-3">
                                                <c:set var="errorDetailDesc">
                                                    <form:errors path="detailDesc" cssClass="invalid-feedback"/>
                                                </c:set>
                                                <label for="exampleInputPassword1"
                                                    class="form-label">Detail description:</label>
                                                <form:textarea type="text" class="form-control ${not empty errorDetailDesc ? 'is-invalid' : ''}"
                                                    path="detailDesc" />
                                                ${errorDetailDesc}
                                            </div>
                                            <div class="mb-3 col-12 col-md-6">
                                                <c:set var="errorShortDesc">
                                                    <form:errors path="shortDesc" cssClass="invalid-feedback"/>
                                                </c:set>
                                                <label for="exampleInputPassword1"
                                                    class="form-label">Short description:</label>
                                                <form:input type="text" class="form-control ${not empty errorShortDesc ? 'is-invalid' : ''}"
                                                    path="shortDesc" />
                                                ${errorShortDesc}
                                            </div>


                                        <div class="mb-3 col-12 col-md-6">
                                            <c:set var="errorQuantity">
                                                <form:errors path="quantity" cssClass="invalid-feedback"/>
                                            </c:set>
                                            <label for="exampleInputPassword1"
                                                class="form-label">Quantity:</label>
                                            <form:input type="text" class="form-control ${not empty errorQuantity ? 'is-invalid' : ''}"
                                                path="quantity" />
                                            ${errorQuantity}
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="exampleInputPassword1"
                                                class="form-label">Factory:</label>
                                                <form:select class="form-select" aria-label="Default select example" path="factory">
                                                    <form:option value="Apple">Apple</form:option>
                                                    <form:option value="Acer">Acer</form:option>
                                                    <form:option value="Dell">Dell</form:option>
                                                </form:select>
                                        </div>
                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="exampleInputPassword1"
                                                class="form-label">Target:</label>
                                                <form:select class="form-select" aria-label="Default select example" path="target">
                                                    <form:option value="Học tập">Học tập</form:option>
                                                    <form:option value="Văn phòng">Văn phòng</form:option>
                                                    <form:option value="Gaming">Gaming</form:option>
                                                </form:select>
                                        </div>


                                        <div class="mb-3 col-12 col-md-6">
                                            <label for="exampleInputPassword1"
                                            class="form-label">Image:</label>
                                        <input type="file" class="form-control" accept=".png, .jpg, .jpeg" id="imageFile" name="uploadFileProduct"/>
                                        </div>

                                        <div class="mb-3 col-12 col-md-6">
                                            <img style="max-width: 250px; display: none;" id="avatarPreview" alt="">
                                        </div>
                                        <div class="col-12 mb-5">
                                            <button type="submit"class="btn btn-primary">Create</button>
                                        </div>
                                    </form:form>
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
