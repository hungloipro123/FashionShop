/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlller.Marketing;

import dao.BlogDAO;
import dao.CategoryDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Blog;
import model.CategoryBlog;
import model.User;

/**
 *
 * @author son22
 */
public class PostsListController extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            final int PAGE_SIZE = 6;  // Set total product each page
            BlogDAO bd = new BlogDAO();
            // Set page
            int page = 1;
            String strPage = request.getParameter("page");
            if (strPage != null) {
                page = Integer.parseInt(strPage);
            }

            // Set key for search 
            String searchKey = "";
            String strSearchKey = request.getParameter("key");
            if (strSearchKey != null) {
                searchKey = strSearchKey;
            }

            // Set category
            String categoryId = "!= -1";
            String strCategoryId = request.getParameter("categoryId");
            if (strCategoryId != null) {
                categoryId = "= " + strCategoryId;
            }

            // Set sort 
            String value = "updated_date";
            String type = "";
            String strType = request.getParameter("type");
            String strValue = request.getParameter("value");
            if (strType != null) {
                type = strType;
            }
            if (strValue != null) {
                value = strValue;
            }

            // Set status
            String status = "!= -1";
            String strStatus = request.getParameter("status");
            if (strStatus != null) {
                status = "= " + strStatus;
            }

            // Set author
            String author = "!= -1";
            String strAuthor = request.getParameter("authorId");
            if (strAuthor != null) {
                author = "= " + strAuthor;
            }

            // Set total page 
            int totalBlog = bd.getTotalBlog(searchKey, categoryId, status, author);
            int totalPage = totalBlog / PAGE_SIZE;
            if (totalBlog % PAGE_SIZE != 0) {
                totalPage += 1;
            }

            // Get list product, new, category, slider
            List<Blog> listBlog = bd.getBlogWithPaging(page, PAGE_SIZE, searchKey, categoryId, type, value, status, author);
            List<CategoryBlog> listCategoryBlog_BlogList = new CategoryDAO().getAllCategoryBlog();
            session.setAttribute("listCategoryBlog", listCategoryBlog_BlogList);
            UserDAO ud = new UserDAO();
            List<User> listAuthor = ud.getAllAuthor();
            session.setAttribute("listAuthor", listAuthor);
            Blog newBlog = bd.getBlogNew();
            session.setAttribute("newBlog", newBlog);

            // Set param request to jsp page
            session.setAttribute("listBlogList", listBlog);
            String history = "posts-list?page=" + page;
            if (strSearchKey != null) {
                history = history + "&key=" + strSearchKey;
                request.setAttribute("historyKey", "&key=" + strSearchKey);
                request.setAttribute("key", strSearchKey);
            }
            if (strCategoryId != null) {
                history = history + "&categoryId=" + strCategoryId;
                request.setAttribute("historyCategoryId", "&categoryId=" + strCategoryId);
                request.setAttribute("categoryId", strCategoryId);
            }
            if (strValue != null) {
                history = history + "&value=" + strValue;
                request.setAttribute("historyValue", "&value=" + strValue);
                request.setAttribute("value", strValue);
            }
            if (strType != null) {
                history = history + "&type=" + strType;
                request.setAttribute("historyType", "&type=" + strType);
                request.setAttribute("type", strType);
            }
            if (strStatus != null) {
                history = history + "&status=" + strStatus;
                request.setAttribute("historyStatus", "&status=" + strStatus);
                request.setAttribute("status", strStatus);
            }
            if (strAuthor != null) {
                history = history + "&authorId=" + strAuthor;
                request.setAttribute("historyAuthor", "&authorId=" + strAuthor);
                request.setAttribute("authorId", strAuthor);
            }

            request.setAttribute("page", page);
            request.setAttribute("totalPage", totalPage);
            session.setAttribute("historyUrl", history);

            // Request
            request.getRequestDispatcher("MKTPostList.jsp").forward(request, response);
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
