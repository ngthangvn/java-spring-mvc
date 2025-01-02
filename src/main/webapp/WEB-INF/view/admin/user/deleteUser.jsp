<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html lang="en">
    <head>
        <title>User delete ${id}</title>
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
                <div class="col-12 mx-auto">
                    <div
                        class="d-flex border-bottom justify-content-between mb-3">
                        <h2>User delete where id = ${id}</h2>
                    </div>
                    <div class="alert alert-danger">
                        Are you sure to delete this user?
                    </div>
                    <form:form method="POST" action="/admin/user/delete"
                        modelAttribute="newUser">
                        <div class="mb-3" style="display: none;">
                            <label for="exampleInputPassword1"
                                class="form-label">Id</label>
                            <form:input type="text" class="form-control" value = "${id}"
                                path="id" />
                        </div>
                        <button type="submit" class="btn btn-danger">confirm</button>
                    </form:form>
                </div>
            </div>
        </div>

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
