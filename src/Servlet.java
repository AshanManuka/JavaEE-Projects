import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Customer")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("received request");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoked doPost method");

        String id = req.getParameter("cId");
        String name = req.getParameter("cName");
        String address = req.getParameter("cAddress");
        String salary = req.getParameter("cSalary");

        System.out.println(id+" "+" "+name+" "+address+" "+salary);

//        PrintWriter writer = resp.getWriter();
//
//        writer.write("<h1>Done Response</h1>");
//        writer.write("<table border = '2' width = 100%>");
//        writer.write("<thead>");
//        writer.write("<tr><th> Id </th><th> Name </th><th> Address </th><th> Salary </th></tr>");
//        writer.write("</thead>");
//        writer.write("<tbody>");
//        writer.write("<tr><td>"+id+"</td><td>"+name+"</td><td>"+address+"</tr><tr>"+salary+"</td></tr>");
//        writer.write("</tbody>");
//        writer.write("</table>");
    }
}
