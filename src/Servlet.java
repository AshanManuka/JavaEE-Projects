import model.Customer;
import util.crudUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(urlPatterns = "/Customer")
public class Servlet extends HttpServlet {
    ArrayList<Customer> tmp = new ArrayList<>();

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

        // Set to Object
        Customer customer = new Customer(id, name, address, salary);
        boolean done = addCustomer(customer);

        if (done) {
            writer.write("<h1>Your Data was Saved !!!</h1>");
            resp.sendRedirect("index.jsp");
        }

        try {
            boolean loadData = loadAllCustomer();
            if (loadData) {
                System.out.println("Can't load data to HTML table.. so I have to use jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

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


    public boolean addCustomer(Customer cus){
        try {
            if (crudUtil.execute("INSERT INTO customer VALUES(?,?,?,?)",cus.getCustomerId(),cus.getCustomerName(),cus.getCustomerAddress(),cus.getCustomerSalary())) {
                System.out.println("data Saved !!!");
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean loadAllCustomer() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = crudUtil.execute("SELECT * FROM customer");
        while (resultSet.next()){
            tmp.add(
                    new Customer(
                    resultSet.getString("cusId"),
                    resultSet.getString("cusName"),
                    resultSet.getString("cusAddress"),
                    Double.parseDouble(resultSet.getString("salary"))
                    )
            );
        }
        return true;
    }

}












