<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Customer" %>
<%--
  Created by IntelliJ IDEA.
  User: WWW
  Date: 11/26/2022
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>new JSP</title>
</head>
<body>
<h1>First jsp</h1>

<%--Scriplet Using--%>
<%
    ArrayList<Customer> arList = new ArrayList<>();
    String i;
    String n;
    String a;
    double s;


    arList.add(new Customer("C100","Ashan","kandy",25000));
    arList.add(new Customer("C200","Manuka","colombo",20000));
    arList.add(new Customer("C300","kusal","panadura",29000));
    arList.add(new Customer("C400","Amith","galle",28000));
    arList.add(new Customer("C500","Nande","madamulana",26000));

   /* System.out.println(arList.get(0));
    System.out.println(arList.get(1));
    System.out.println(arList.get(3));
    System.out.println(arList.get(3));
    System.out.println(arList.get(4));*/

//    for (Customer customer : arList) {
//            i = customer.getCustomerId();
//            n = customer.getCustomerName();
//            a = customer.getCustomerAddress();
//            s = customer.getCustomerSalary();
//    }


%>

<h1>Load to the table</h1>
<br>

<table border="2">
<thead>
    <tr><th>Id</th><th>Name</th><th>Address</th><th>Salary</th></tr>
</thead>
<tbody>

</tbody>
    <%
      for (Customer customer : arList) {
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
</table>

<%--Expression using--%>
<%--<h1>my name is : <%= name%> </h1>
<h1>my age is : <%= age%> </h1>--%>

<%--Declaration using--%>
<%! String address = "kandy"; %>


<%--<%%>--%>

</body>
</html>
