/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlller.Marketing;

import dao.BlogDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author son22
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class AddPostController extends HttpServlet {

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
            out.println("<title>Servlet AddPostController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddPostController at " + request.getContextPath() + "</h1>");
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
//        
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//        HttpSession session = request.getSession();
//        User u = (User) session.getAttribute("us");
//
//        String url_thumbnail = "images/blog/";
//
//        // Create a factory for disk-based file items
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//// Configure a repository (to ensure a secure temp location is used)
//        ServletContext servletContext = this.getServletConfig().getServletContext();
//        File repository = (File) servletContext.getAttribute("jakarta.servlet.context.tempdir");
//        factory.setRepository(repository);
//
//// Create a new file upload handler
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        upload.setHeaderEncoding("UTF-8");
//
//        try {
//            // Parse the request
//           //List<FileItem> items = upload.parseRequest(request);
//           List<FileItem> items = upload.parseRequest(new ServletRequestContext((javax.servlet.http.HttpServletRequest) request));
//            // Process the uploaded items
//            Iterator<FileItem> iter = items.iterator();
//            HashMap<String, String> fields = new HashMap<>();
//            while (iter.hasNext()) {
//                FileItem item = iter.next();
//
//                if (item.isFormField()) {
//                    fields.put(item.getFieldName(), item.getString("UTF-8"));
//
//                } else {
//                    String filename = item.getName();
//                    if (filename == null || filename.equals("")) {
//                        break;
//                    } else {
//                        Path path = Paths.get(filename);
//                        String storePath = servletContext.getRealPath("../../web/images/blog");
//                        File uploadFile = new File(storePath + "/" + path.getFileName());
//                        item.write(uploadFile);
//                        url_thumbnail += filename;
//                    }
//
//                }
//            }
//
//            String title = fields.get("title");
//            int user_id = u.getUser_Id();
//            String content = fields.get("content");
//            String brief_infor = fields.get("brief_infor");
//            int category_id = Integer.parseInt(fields.get("categoryId"));
//            int status = Integer.parseInt(fields.get("status"));
//
//            BlogDAO bd = new BlogDAO();
//            bd.addNewBlog(title, user_id, content, brief_infor, category_id, status, url_thumbnail);
//            response.sendRedirect("posts-list");
//        } catch (FileUploadException ex) {
//
//        } catch (Exception ex) {
//
//        }
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("us");
        if (u == null) {
            response.getWriter().println("Error: User not found in session.");
            return;
        }
//        Part part = request.getPart("thumbnail");
//        if (part == null) {
//            response.getWriter().println("Error: No file part in the request.");
//            return;
//        }
//
//        String fileName = extractFileName(part);
//        if (fileName == null || fileName.isEmpty()) {
//            response.getWriter().println("Error: Invalid file name.");
//            return;
//        }
//
//        fileName = new File(fileName).getName();
//        try {
//            part.write(this.getFolderUpload().getAbsolutePath() + File.separator + fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//            response.getWriter().println("Error: Unable to save uploaded file.");
//            return;
//        }
//
//        String title = request.getParameter("title");
//        int user_id = u.getUser_Id();
//        String content = request.getParameter("content");
//        String brief_infor = request.getParameter("brief_infor");
//
//        if (title == null || content == null || brief_infor == null) {
//            response.getWriter().println("Error: Missing required parameters (title, content, brief_infor).");
//            return;
//        }
//
//        int category_id;
//        int status;
//        try {
//            category_id = Integer.parseInt(request.getParameter("categoryId"));
//            status = Integer.parseInt(request.getParameter("status"));
//        } catch (NumberFormatException e) {
//            response.getWriter().println("Error: Invalid number format in parameters.");
//            return;
//        }
//
//        BlogDAO bd = new BlogDAO();
//        bd.addNewBlog(title, user_id, content, brief_infor, category_id, status,fileName); //fileName url_thumbnail);
//        response.sendRedirect("posts-list");}

        Part part = request.getPart("thumbnail");
        if (part == null) {
            response.getWriter().println("Error: No file part in the request.");
            return;
        }

        String fileName = extractFileName(part);
        if (fileName == null || fileName.isEmpty()) {
            response.getWriter().println("Error: Invalid file name.");
            return;
        }

        fileName = new File(fileName).getName();

        String urlThumbnail = saveThumbnail(part, fileName); // Lưu trữ hình ảnh và nhận lại URL thumbnail

        String title = request.getParameter("title");
        int user_id = u.getUser_Id();
        String content = request.getParameter("content");
        String brief_infor = request.getParameter("brief_infor");

        if (title == null || content == null || brief_infor == null) {
            response.getWriter().println("Error: Missing required parameters (title, content, brief_infor).");
            return;
        }

        int category_id;
        int status;
        try {
            category_id = Integer.parseInt(request.getParameter("categoryId"));
            status = Integer.parseInt(request.getParameter("status"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Error: Invalid number format in parameters.");
            return;
        }

        BlogDAO bd = new BlogDAO();
        bd.addNewBlog(title, user_id, content, brief_infor, category_id, status, urlThumbnail); // Lưu `urlThumbnail` vào cơ sở dữ liệu
        response.sendRedirect("posts-list");}

//    HttpSession session = request.getSession();
//    User u = (User) session.getAttribute("us");
//
//    String url_thumbnail = "images/blog/";
//
//    try {
//        Collection<Part> parts = request.getParts();
//        HashMap<String, String> fields = new HashMap<>();
//        for (Part part : parts) {
//            if (part.getSubmittedFileName() == null) {
//                fields.put(part.getName(), IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8));
//            } else {
//                String filename = part.getSubmittedFileName();
//                Path path = Paths.get(filename);
//                String storePath = request.getServletContext().getRealPath("../../web/images/blog");
//                File uploadFile = new File(storePath + "/" + path.getFileName());
//                Files.copy(part.getInputStream(), uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//                url_thumbnail += filename;
//            }
//        }
//
//        String title = fields.get("title");
//        int user_id = u.getUser_Id();
//        String content = fields.get("content");
//        String brief_infor = fields.get("brief_infor");
//        int category_id = Integer.parseInt(fields.get("categoryId"));
//        int status = Integer.parseInt(fields.get("status"));
//
//        BlogDAO bd = new BlogDAO();
//        bd.addNewBlog(title, user_id, content, brief_infor, category_id, status, url_thumbnail);
//        System.out.println("Redirecting to posts-list");
//        if (response.isCommitted()) {
//    System.out.println("Cannot redirect because the response has already been committed");
//} else {
//    System.out.println("Redirecting to posts-list");
//    response.sendRedirect("posts-list");
//}
//        response.sendRedirect("posts-list");
//    } catch (Exception ex) {
//        // Handle exception
//        ex.printStackTrace();
//    }
//HttpSession session = request.getSession();
//User u = (User) session.getAttribute("us");
//
//String url_thumbnail = "images/blog/";
//
//try {
//    Collection<Part> parts = request.getParts();
//    HashMap<String, String> fields = new HashMap<>();
//    for (Part part : parts) {
//        if (part.getSubmittedFileName() == null) {
//            fields.put(part.getName(), IOUtils.toString(part.getInputStream(), StandardCharsets.UTF_8));
//        } else {
//            String filename = part.getSubmittedFileName();
//            Path path = Paths.get(filename);
//            String storePath = request.getServletContext().getRealPath("../../images/blog");
//            File uploadFile = new File(storePath + "/" + path.getFileName());
//            Files.copy(part.getInputStream(), uploadFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
//            url_thumbnail += filename;
//        }
//    }
//
//    String title = fields.get("title");
//    int user_id = u.getUser_Id();
//    String content = fields.get("content");
//    String brief_infor = fields.get("brief_infor");
//    int category_id = Integer.parseInt(fields.get("categoryId"));
//    int status = Integer.parseInt(fields.get("status"));
//
//    BlogDAO bd = new BlogDAO();
//    bd.addNewBlog(title, user_id, content, brief_infor, category_id, status, url_thumbnail);
//    
//
//    
//    if (response.isCommitted()) {
//        System.out.println("Cannot redirect because the response has already been committed");
//    } else {
//        System.out.println("Redirecting to posts-list");
//        response.sendRedirect("posts-list");
//    }
//}catch (Exception ex) {
//    // Handle exception
//    System.out.println("An error occurred: " + ex.getMessage());
//    ex.printStackTrace();
//}
//        // Handle runtime exception
//         catch (Error err) {
//    // Handle error
//    System.out.println("An unexpected error occurred: " + err.getMessage());
//    err.printStackTrace();
//}
//
//    
        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
        
            () {
        return "Short description";
        }// </editor-fold>
    
    

private String saveThumbnail(Part part, String fileName) throws IOException {
    String folderPath = getFolderUpload().getAbsolutePath();
    String filePath = folderPath + File.separator + fileName;
    
    try (InputStream inputStream = part.getInputStream();
         FileOutputStream outputStream = new FileOutputStream(filePath)) {
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
    }
    
    return "/images/blog/" + fileName; // Return the URL of the saved thumbnail
}
    

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        if (contentDisp == null) {
            // Handle the case where there is no "content-disposition" header in the part.
            // This could involve showing an error message to the user, for example.
            return "";
        }
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String fileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
                if (isImageExtension(fileExtension)) {
                    return fileName;
                } else {
                    Logger.getLogger(AddPostController.class.getName()).log(Level.SEVERE, "File uploaded is not an image");
                    return "";
                }
            }
        }
        return "";
    }

    public static boolean isImageExtension(String extension) {
        String[] imageExtensions = {"jpg", "jpeg", "png", "gif", "bmp"};
        for (String imageExtension : imageExtensions) {
            if (extension.equalsIgnoreCase(imageExtension)) {
                return true;
            }
        }
        return false;
    }

    public File getFolderUpload() {
        // sua nay theo duong link toi thu muc images trong may.
        File folderUpload = new File("E:\\STUDIES\\Ki5\\SWP\\Fashion\\FashionShop\\src\\main\\webapp\\images\\blog");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }

}
