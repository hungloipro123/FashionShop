package Controller.Common;

import dao.UserDAO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.User;
import org.apache.commons.io.IOUtils;

@WebServlet(name = "EditUserProfileController", urlPatterns = {"/edit"})
public class EditUserProfileController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");

    HttpSession session = request.getSession();
    UserDAO ud = new UserDAO();

    String url_avatar = "images/avatar/";

    try {
        Collection<Part> parts = request.getParts();
        HashMap<String, String> fields = new HashMap<>();
        for (Part part : parts) {
            String fieldName = part.getName();

            if (part.getContentType() == null) {
                // Xử lý các trường thông thường (không phải file upload)
                String fieldValue = request.getParameter(fieldName);
                fields.put(fieldName, fieldValue);
            } else {
                // Xử lý file upload
                String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                if (filename == null || filename.equals("")) {
                    String url_old = ud.getUrlImageById(Integer.parseInt(request.getParameter("userId")));
                    url_avatar = url_old;
                    break;
                } else {
                    Path path = Paths.get(filename);
                    String storePath = getServletContext().getRealPath("/images/avatar");
                    File uploadFile = new File(storePath + "/" + path.getFileName());
                    try (InputStream inputStream = part.getInputStream();
                         FileOutputStream outputStream = new FileOutputStream(uploadFile)) {
                        IOUtils.copy(inputStream, outputStream);
                    }
                    url_avatar += path.getFileName();
                }
            }
        }

        String uid_raw = fields.get("userId");
        String uname = fields.get("fullName");
        String umobile = fields.get("mobile");
        String uaddress = fields.get("address");
        String ugender = fields.get("gender");
        int uid = Integer.parseInt(uid_raw);

        ud.editUserProfile(uname, url_avatar, ugender, umobile, uaddress, uid);

        User u = ud.getUserById(uid);
        session.setAttribute("us", u);
        TimeUnit.SECONDS.sleep(2);
        response.sendRedirect("home");

    } catch (ServletException ex) {
        // Xử lý lỗi ServletException
    } catch (IOException ex) {
        // Xử lý lỗi IOException
    } catch (Exception ex) {
        // Xử lý lỗi khác
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}