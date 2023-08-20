/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pis.Bean.UsersBean;
import com.pis.Dao.UsersDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AR WorkStation
 */
public class pisupdateuser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pisupdateuser</title>");
            out.println(" <link rel='stylesheet' href='updateusersprofile.css'>");
            HttpSession hs = request.getSession();
            if (hs.getAttribute("user") == null) {
                response.sendRedirect("Login.html");
            }
            int userid = (Integer) hs.getAttribute("user");
            UsersDao ud = new UsersDao();
            UsersBean x = ud.FindbyId(userid);
            out.println("</head>");
            out.println("<body>");
            out.println("   <div class='cnt'>");
            out.println("<div class='item' id='item-1'>");
            out.println("   <div class='nav'>");
            out.println("  <ul>");
            out.println("  <li><a href='pisIncomeCategory'>Incomes Category</a></li>");
            out.println(" <li><a href='expensescategory'>Expenses Cateogory</a></li>");
            out.println(" <li><a href='incomes'>Incomes</a></li>");
            out.println(" <li><a href='expenses'>Expenses</a></li>");
            out.println("  <li><a href='CashBook'>Cash Book</a></li>");
            out.println(" <li><a href='BankData'>Bank Book</a></li>");
            out.println("   <li><a href='DayBook'>Day Book</a></li>");
            out.println("   <li><a href='BalanceSheet'>Balance Book</a></li>");
            out.println("  </ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='item' id='item-2'>");
            out.println("<div class='logo'>");
            out.println("<div id='line1'>");
            out.println("<span id='ps'>Personal</span>");
            out.println("</div>");
            out.println("<div id='line2'>");
            out.println("<span id='inv'>Inventory</span>");
            out.println("<span id='sys'> System</span>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='navbar'>");
            out.println("<ul class='nav-links'>");
           out.println("    <li><a href='Home'>Home  </a></li>");
            out.println("<li><a href='ViewProfile'> Profile</a></li>");
            out.println("<li><a href='pisupdateuser'>Update Profile</a></li>");
            out.println("<li><a href='Login.html'>Logout</a></li>");
            out.println("</ul>");
            out.println("</div>");
            out.println("</div>");
            out.println("<div class='item' id='item-3'>");
            out.println(" <form name='f1' method='post' action='pisupdatecontroller' >");
            out.println("   <div class='container'>");
            out.println("  <h1>Update Profile</h1>");
           
            out.println("  <table class='datatable'>");
            out.println("   <tr>");
            out.println("  <td><input type='hidden' name='userid'  value='" + x.getUserid() + "' required /></td>");
            out.println(" </tr>");
            out.println("   <tr>");
            out.println("   <td><label for='name'>Name</label></td>");
            out.println("  <td><input type='text' name='name' placeholder='Firstname' value='" + x.getName() + "' required /></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td><label for='username'><b>Username</b></label></td>");
            out.println(" <td><input type='text' placeholder='Enter Email' name='uname' value='" + x.getUsername() + "' required /></td>");
            out.println("  </tr>");
            out.println("  <tr>");
            out.println("  <td><label for='email'><b>Email</b></label></td>");
            out.println(" <td><input type='email' placeholder='Enter Email' name='email' value='" + x.getEmail() + "' required /></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='phone'>Phone</label></td>");
            out.println(" <td><input type='number' name='phone' placeholder='phone no.' value='" + x.getMobile() + "' required /></td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td><label for='address'><b>Address</b></label></td>");
            out.println(" <td><input type='text' placeholder='Enter Address' name='add' value='" + x.getAddress() + "' required /></td>");
            out.println("  </tr>");
            out.println(" <tr>");
            out.println("  <td><label for='password'><b>Password</b></label></td>");
            out.println("  <td><input type='password' placeholder='Enter Password' name='pass1' value='" + x.getPassword() + "' required /></td>");
            out.println(" </tr>");
            out.println("  <tr>");
            out.println(" <td>");
            out.println("  <div class='btns'>");
            out.println("   <input type='submit' class='registerbtn' value='Update' />");
            out.println("  </div>");
            out.println("  </td>");
            out.println(" </tr>");
            out.println("  </table>");
            out.println("</div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
