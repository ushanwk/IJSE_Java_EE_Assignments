package lk.ijse.servlet;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/pages/customer")
public class customerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaEEAssignment ", "root", "ushan1234");

            PreparedStatement pstm = connection.prepareStatement("select * from customer");
            ResultSet rst = pstm.executeQuery();
            PrintWriter writer = resp.getWriter();

            resp.addHeader("Content-Type","application/json");

            JsonArrayBuilder allCustomers = Json.createArrayBuilder();


            while (rst.next()) {
                String id = rst.getString(1);
                String name = rst.getString(2);
                String address = rst.getString(3);

                JsonObjectBuilder customer = Json.createObjectBuilder();

                customer.add("id",id);
                customer.add("name",name);
                customer.add("address",address);

                allCustomers.add(customer.build());
            }

            writer.print(allCustomers.build());


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        String cusID = req.getParameter("cusID");
        String cusName = req.getParameter("cusName");
        String cusAddress = req.getParameter("cusAddress");
        String option = req.getParameter("option");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaEEAssignment", "root", "ushan1234");
            PrintWriter writer = resp.getWriter();

            switch (option) {
                case "add":
                    PreparedStatement pstm = connection.prepareStatement("insert into customer values(?,?,?)");
                    pstm.setObject(1, cusID);
                    pstm.setObject(2, cusName);
                    pstm.setObject(3, cusAddress);
                    if (pstm.executeUpdate() > 0) {

                        resp.addHeader("Content-Type","application/json");

                        JsonObjectBuilder m = Json.createObjectBuilder();
                        m.add("state","OK");
                        m.add("message","Succesfuly Added");
                        m.add("data","Succesfuly Added");
                        writer.print(m.build());

                    }

                    break;



                case "delete":
                    PreparedStatement pstm2 = connection.prepareStatement("delete from customer where customerId=?");
                    pstm2.setObject(1, cusID);
                    if (pstm2.executeUpdate() > 0) {
                        resp.addHeader("Content-Type","application/json");

                        JsonObjectBuilder m = Json.createObjectBuilder();
                        m.add("state","OK");
                        m.add("message","Succesfuly Delete");
                        m.add("data","Succesfuly Delete");
                        writer.print(m.build());
                    }

                    break;

            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            PrintWriter writer = resp.getWriter();

            resp.addHeader("Content-Type","application/json");

            JsonObjectBuilder m = Json.createObjectBuilder();
            m.add("state","NO");
            m.add("message",e.getMessage());
            m.add("data","Not Added");
            writer.print(m.build());
        }

    }

}
