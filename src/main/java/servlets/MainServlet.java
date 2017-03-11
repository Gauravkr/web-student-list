package servlets;

import logic.Group;
import logic.ManagementSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet
public class MainServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.println("<H1>Список групп</H1>");
        pw.println("<table border=1>");
        try {
            List<Group> l = ManagementSystem.getInstance().getGroups();
            for (Group gr : l) {
                pw.println("<tr>");
                pw.println("<td>" + gr.getGroupId() + "</td>");
                pw.println("<td>" + gr.getNameGroup() + "</td>");
                pw.println("<td>" + gr.getCurator() + "</td>");
                pw.println("<td>" + gr.getSpeciality() + "</td>");
                pw.println("</tr>");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        pw.println("<table>");
    }
}
