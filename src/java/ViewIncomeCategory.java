/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.pis.Bean.ExpensesCategoryBean;
import com.pis.Bean.IncomeCategoryBean;
import com.pis.Dao.ExpensesCategoryDao;
import com.pis.Dao.IncomeCategoryDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AR WorkStation
 */
public class ViewIncomeCategory extends HttpServlet {

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
            out.println("<title>Servlet ViewProfile</title>");
            out.println("</head>");
            out.println(" <link rel='stylesheet' href='viewincomecategory.css'>");
            out.println("<body>");

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
            out.println("   <li><a href='BalanceSheet'>Balance Sheet</a></li>");

            out.println("  </ul>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class='item' id='item-2'>");
            out.println("  <div class='logo'>");
            out.println("   <div id='line1'>");
            out.println("     <span id='ps'>Personal</span>");
            out.println("  </div>");
            out.println(" <div id='line2'>");
            out.println("  <span id='inv'>Inventory</span>");
            out.println("  <span id='sys'> System</span>");
            out.println("  </div>");
            out.println("  </div>");
            out.println("  <div class='navbar'>");
            out.println("  <ul class='nav-links'>");
            out.println("    <li><a href='Home'>Home  </a></li>");
            out.println("   <li><a href='ViewProfile'> Profile</a></li>");
            out.println("   <li><a href='pisupdateuser'>Update Profile</a></li>");
            out.println("   <li><a href='Login.html'>Logout</a></li>");
            out.println(" </ul>");
            out.println("  </div>");
            out.println(" </div>");

            out.println("<div class='item' id='item-3'>");
            out.println("<div class='container'>");
            out.println("<h1> Incomes Category</h1>");
            out.println("<div class='table_container'>");
            out.println(" <a href='pisIncomeCategory' class='backbutton datatable'>&#8592</a>");

            HttpSession hs = request.getSession();
            if (hs.getAttribute("user") == null) {
                response.sendRedirect("Login.html");
            }

            int userid = (Integer) hs.getAttribute("user");

            out.println("<table class='database'>");
            out.println("<tr>");
            out.println("<th>Category Name</th>");
            out.println("<th>Category Details</th>");
            out.println("<th>Edit</th>");
            out.println(" <th>Delete</th>");
            out.println("</tr>");

            IncomeCategoryBean ib = new IncomeCategoryBean();
            IncomeCategoryDao id = new IncomeCategoryDao();
            ArrayList<IncomeCategoryBean> al = id.FindAllCategoryName(userid);
            for (IncomeCategoryBean el : al) {
                out.println("<tr>");
                out.println("<td>" + el.getInc_catname() + "</td>");
                out.println("<td>" + el.getInc_catdetails() + "</td>");
                out.println("<td><a href='UpdateIncomesCategory?inc_catid=" + el.getInc_catid() + "' id='edit'>edit</a></td>");
                out.println("<td><a href='DeleteIncomesCategory?inc_catid=" + el.getInc_catid() + "' id='delete'>delete</a></td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

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
