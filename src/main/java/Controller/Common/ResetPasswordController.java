/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Common;

import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import model.SendMailOK;
import model.User;

/**
 *
 * @author GanKPoet
 */
public class ResetPasswordController extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ResetPasswordController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ResetPasswordController at " + request.getContextPath() + "</h1>");
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
        String email = request.getParameter("email");
        if (email == null || email.trim().isEmpty()) {
            request.setAttribute("notification", "Email cannot be empty");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        if (!email.matches("^\\w+@[fF][pP][tT]\\.[eE][dD][uU]\\.[vV][nN]$") && !email.matches("^\\w+@[gG][mM][aA][iI][lL]\\.[cC][oO][mM]$")) {
            request.setAttribute("notification", "Email must have fpt.edu.vn or gmail.com");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        User user = new UserDAO().getUserByEmail(email);
        if (user == null) {
            request.setAttribute("notification", "Email is not exists");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getSession().setAttribute("email", email);

            String to = email;

            String subject = "Re-issue old password\n";
            String body
                    = "<!DOCTYPE html>\n"
                    + "<html lang=\"en\">\n"
                    + "\n"
                    + "<head>\n"
                    + "</head>\n"
                    + "\n"
                    + "<body>\n"
                    + "    <h3 style=\"color: blue;\">Hello " + user.getFull_Name() + "</h3>\n"
                    + "    <div>We have received a password reset request for your account at VDreamer.</div>\n"
                    + " <a href=\"http://localhost:8080/change-password?email=" + user.getEmail() + "\">Click here</a>"
                    + "    <div>If you didn't make this request, you can safely ignore this email. However, if you have indeed forgotten your password, please click the button above to log in to VDreamer and reset your password. Wishing you a great shopping experience with VDreamer</div>\n"
                    + "    <div>I hope you won't forget your password, but if you do, we're here to help.</div>\n"
                    + "    <h3 style=\"color: blue;\">We sincerely appreciate your valued patronage!</h3>\n"
                    + "\n"
                    + "</body>\n"
                    + "\n"
                    + "</html>";
            boolean result = sendEmail(to, subject, body);
        }
        request.setAttribute("notification", "Please check your email!");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private boolean sendEmail(String to, String subject, String body) {
        // Cấu hình các thông tin cần thiết để gửi email
        String host = "smtp.gmail.com";
        String port = "587";
        final String username = "thongvmce171505@fpt.edu.vn";
        final String password = "tqcuplgprqejdqev";

        // Thiết lập các thuộc tính cho kết nối SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Tạo đối tượng Authenticator để xác thực người dùng
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };

        // Tạo phiên gửi email
        Session s = Session.getInstance(props, authenticator);

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage message = new MimeMessage(s);

            // Đặt thông tin người gửi và người nhận
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Đặt tiêu đề và nội dung email
            message.setSubject(subject, "UTF-8");
            message.setContent(body, "text/html; charset=UTF-8");

            // Gửi email
            Transport.send(message);

            return true;
        } catch (MessagingException ex) {
            ex.printStackTrace();
            return false;
        }
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
