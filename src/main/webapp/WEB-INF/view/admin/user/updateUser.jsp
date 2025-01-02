<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no" />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous" />
    </head>

    <body>

        <div class="container mt-5">
            <div class="row">
                <div class="col-md-6 col-12 mx-auto">
                    <h1 class="pb-3 border-bottom">Update a user</h1>
                    <form:form method="POST" action="/admin/user/update" modelAttribute = "newUser">
                        <div class="mb-3" style="display: none;">
                            <label for="exampleInputPassword1"
                                class="form-label">Id</label>
                            <form:input type="text" class="form-control"
                                placeholder="0" path="id" />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputEmail1"
                                class="form-label">Email </label>
                            <form:input type="email" class="form-control" path="email" disabled ="true"
                                 />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1"
                                class="form-label">fullName</label>
                            <form:input type="text" class="form-control" path="fullName"
                                 />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1"
                                class="form-label">address</label>
                            <form:input type="text" class="form-control" path="address"
                                 />
                        </div>
                        <div class="mb-3">
                            <label for="exampleInputPassword1"
                                class="form-label">phone</label>
                            <form:input type="text" class="form-control" path="phone"
                                 />
                        </div>

                        <button type="submit"
                            class="btn btn-warning">Update</button>
                    </form:form>
                </div>
            </div>
        </div>

        <!-- Bootstrap JavaScript Libraries -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"></script>
    </body>
</html>
