<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Customer" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="util.crudUtil" %>
<%@ page import="java.sql.SQLException" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer</title>
    <meta name="keywords" content="restaurant, food, drinks, order">
    <meta name="description" content="online food ordering site">
    <meta name="author" content="Ashan Manuka Jayarathne">
    <meta name="owner" content="Ashan Manuka">
    <meta name="viewport" content="width=device-width initial-scale=1 user-scalable=no">
    <link rel="stylesheet" href="event/css/bootstrap.min.css">
    <link rel="stylesheet" href="style/customer.css">
</head>
<body>
<main class="container-fluid">

    <section class="row" id="sec-one">
        <div class="col-2">
<!--            <img src="../event/images/gift-img.png" alt="gift" id="im">-->
        </div>
        <div class="col-3">
            <h1 id="anC">Customer</h1>
        </div>
        <div class="col-3">
            <a href="#"><button id="item-btn"><b>Items</b></button></a>
        </div>
        <div class="col-3">
            <a href="#"><button id="order-btn"><b>Orders</b></button></a>
        </div>
        <div class="col-1"></div>
    </section>

    <section class="row" id="free-sec">
        <div class="col-12"></div>
    </section>

    <section class="row" id="sec-two">
        <div class="col-1"></div>
        <div class="col-3">
            <a href="#sec-four"><button id="all-search" form="customer-form" formmethod="post" formaction="index.jsp"><b>All Customers</b></button></a>
        </div>
        <div class="col-5">
            <label for="txtSearch"></label>
            <input class="form-control" id="txtSearch" type="text">
        </div>
        <div class="col-2">
            <a href="#"><button id="search-btn"><b>Search</b></button></a>
        </div>
        <div class="col-1"></div>
    </section>

    <section id="sec-free-two" class="row">
        <div class="col-12"></div>
    </section>

    <section class="row" id="sec-three">
        <div class="col-1"></div>
        <div class="col-7">
            <div class="form-group">
                <form action="Customer" method="post" id="customer-form">
                <label for="cId" id="lblOne">Customer ID</label>
                <input class="form-control" id="cId" name="cId" required type="text">
                <span class="control-error" id="lblcusid"></span>
            <br>
                <label for="cName" id="lblTwo">Customer Name</label>
                <input class="form-control" id="cName" name="cName" type="text">
                <span class="control-error" id="lblcusname"></span>
            <br>
                <label for="cAddress" id="lblThree">Customer Address</label>
                <input class="form-control" id="cAddress" name="cAddress" type="text">
                <span class="control-error" id="lblcusaddress"></span>
            <br>
                <label for="cSalary" id="lblFour">Customer Salary</label>
                <input class="form-control" id="cSalary" name="cSalary" type="text">
                <span class="control-error" id="lblcussalary"></span>

                    <br>
                    <div class="d-flex col-5">
                        <button id="Add" class="col-3" formaction="Customer?option=save"><b>Add</b></button>
                        <button id="update" class="col-3" formaction="Customer?option=update"><b>Update</b></button>
                        <button id="delete" class="col-3" formaction="Customer?option=delete" ><b>Delete</b></button>
                    </div>

                </form>
            </div>
            <br>
        </div>

        <div class="col-1"></div>
    </section>

    <%--<%%>--%>
<%--scriplet--%>
    <%



        ArrayList<Customer> customerList = new ArrayList<>();


            try {
                ResultSet result = crudUtil.execute("SELECT * FROM customer");
                while (result.next()){
                customerList.add(
                        new Customer(
                                result.getString("cusId"),
                                result.getString("cusName"),
                                result.getString("cusAddress"),
                                Double.parseDouble(result.getString("salary"))
                          ));
                        }
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }




    %>

    <section class="row" id="sec-four">
        <div class="col-1"></div>
        <div class="col-10">
            <table class="table table-bordered table-hover" id="cus-tbl">
                <thead class="bg-info text-black">
                <tr>
                    <th>Customer ID</th>
                    <th>Customer Name</th>
                    <th>Customer Address</th>
                    <th>Customer Salary</th>
                </tr>
                </thead>
                <tbody id="tblCustomer">
                <%
                    for (Customer customer: customerList) {
                %>

                <tr>
                <td><%=customer.getCustomerId()%></td>
                <td><%=customer.getCustomerName()%></td>
                <td><%=customer.getCustomerAddress()%></td>
                <td><%=customer.getCustomerSalary()%></td>
                </tr>
                <%
                    }
                %>

                </tbody>
            </table>
        </div>
        <div class="col-1"></div>
    </section>

</main>
<script src="event/jQuery/jquery-3.6.1.min.js"></script>
<script src="controller/CustomerController.js"></script>
</body>
</html>