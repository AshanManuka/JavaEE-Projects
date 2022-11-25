import model.Customer;
import util.crudUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Customer")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("received request");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoked doPost method");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("cId");
        String name = req.getParameter("cName");
        String address = req.getParameter("cAddress");
        String sal = req.getParameter("cSalary");
        double salary = Double.parseDouble(sal);

        System.out.println(id+" "+" "+name+" "+address+" "+salary);

        // Set to Object
        Customer customer = new Customer(id,name,address,salary);

        try {
            if (crudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",customer.getCustomerId(),customer.getCustomerName(),customer.getCustomerAddress(),customer.getCustomerSalary())) {
                System.out.println("data Saved !!!");
                writer.write("<h1>Your Data was Saved !!!</h1>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        /*try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/d4","root","1234");
            PreparedStatement psmt = connection.prepareStatement("INSERT INTO customer VALUES (?,?,?,?)");
            psmt.setObject(1,id);
            psmt.setObject(2,name);
            psmt.setObject(3,address);
            psmt.setObject(4,salary);
            boolean res = psmt.execute();
            System.out.println(res);


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

/*        writer.write("<h1>Done Response</h1>");
        writer.write("<table border = '2' width = 100%>");
        writer.write("<thead>");
        writer.write("<tr><th> Id </th><th> Name </th><th> Address </th><th> Salary </th></tr>");
        writer.write("</thead>");
        writer.write("<tbody>");
        writer.write("<tr><td>"+id+"</td><td>"+name+"</td><td>"+address+"</tr><tr>"+salary+"</td></tr>");
        writer.write("</tbody>");
        writer.write("</table>");*/
    }

}












