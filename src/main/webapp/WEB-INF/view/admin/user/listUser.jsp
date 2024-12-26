<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
    <head>
        <title>Title</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
    </head>

    <body>

        <div class="container mt-5">
            <div class="row">
                <div class="col-12 mx-auto">
                    <div class="d-flex border-bottom justify-content-between pb-3">
                        <h2>User</h2>
                        <a href="/admin/user/create" class="btn btn-primary">Create user</a>
                    </div>

                    <table class="table table-bordered mt-3">
                        <thead>
                          <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Full Name</th>
                            <th>Action</th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach var="user" items="${users1}">
                            <tr>
                              <th>${user.id}</th>
                              <td>${user.email}</td>
                              <td>${user.fullName}</td>
                              <td>
                                  <a href="#" class="btn btn-success">View</a>
                                  <a href="/admin/user/update" class="btn btn-warning">Update</a>
                                  <a href="#" class="btn btn-danger">Delete</a>
                              </td>
                            </tr>
                          </c:forEach>

                        </tbody>
                      </table>
                </div>
            </div>
          </div>

        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
