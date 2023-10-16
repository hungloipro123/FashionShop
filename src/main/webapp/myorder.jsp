<%-- 
    Document   : myorder
    Created on : Jun 13, 2022, 3:35:42 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="./assets/fonts/themify-icons/themify-icons.css">
        <%@include file="components/javascript.jsp" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <script src="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"></script>
        <style>
            .mtop {
                margin-top: 6%;
            }
            .title-order {
                display: flex;
                justify-content: center;
                color: red;
            }
        </style>
    </head>
    <body>
        <%@include file="components/header.jsp" %>
       <br>
        <br>
        <h1 class="mtop title-order" >List of orders</h1>
        <div class="container mtop" style="width:80%">
            <table class="table table-striped table-bordered" id="sortTable">
                <thead>
                    <tr>
                        <th>OrderID</th>
                        <th>Purchase&nbspdate</th>
                        <th>Products</th>
                        <th>Total&nbspcost</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items ="${listMyOrder}" var="c">
                        <tr>
                            <td><a href="order-detail?orderId=${c.orderID}">
                                    ${c.orderID}</a></td>
                            <td>${c.date}</td>
                            <c:if test="${c.countProduct != 0}">
                                <td>${c.fullNameFirstProduct} và ${c.countProduct}Other products</td>
                            </c:if>
                            <c:if test="${c.countProduct == 0}">
                                <td>${c.fullNameFirstProduct}</td>
                            </c:if>
                            <td>${c.total_cost}</td>
                            <td>${c.status_order_name}</td>
                            <td>
                                <c:if test="${c.status_order_name eq 'Submited'}">
                                    <div class="row">
                                        <a href="cancel-order?order_id=${c.orderID}" class="btn btn-danger btn-lg active" role="button" aria-pressed="true" >Cancel</a>
                                    </div>

                                </c:if></td>
                        </tr>

                    </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="mtop"></div>
        <%@include file="components/footer.jsp" %>
        <script src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
        
        <script>
            $(document).ready(function () {
                $('#sortTable').DataTable({
                    "language": {
                        "decimal": "",
                        "emptyTable": "No data available in table",
                     //   "info": " _START_ đến _END_ của _TOTAL_ bản ghi",
                      //  "infoEmpty": "HIển thị 0 to 0 of 0 bản ghi",
                      //  "infoFiltered": "(kết quả từ _MAX_ tổng số bản ghi)",
                        "infoPostFix": "",
                        "thousands": ",",
                        "lengthMenu": "Display_MENU_record",
                        "loadingRecords": "Loading...",
                        "processing": "",
                        "search": "Search",
                        "zeroRecords": "No results found",
                        "paginate": {
                            "first": "F",
                            "last": "L",
                            "next": "Next",
                            "previous": "Pre"
                        },
                        "aria": {
                            "sortAscending": ": activate to sort column ascending",
                            "sortDescending": ": activate to sort column descending"
                        }
                    }
                });
            });
        </script>
    </body>
</html>
