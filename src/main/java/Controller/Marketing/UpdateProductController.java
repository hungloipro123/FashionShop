/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlller.Marketing;

import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.nio.file.FileSystems;
import java.nio.file.Files;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 6,
        maxFileSize = 1024 * 1024 * 30,
        maxRequestSize = 1024 * 1024 * 150)



public class UpdateProductController extends HttpServlet {
    private static final String imgDir = "images/product";

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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        ProductDAO p = new ProductDAO();
        String imgFolderPath = "images/product";
        String appPath = getServletContext().getRealPath("/");
        String uploadPath = appPath + File.separator + imgFolderPath;
        
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        int product_id = Integer.parseInt(request.getParameter("productId"));
        
        Part filePart = request.getPart("thumbnail");
        String fileName = filePart.getSubmittedFileName();
        String fileUrl = "";
        String oldFileUrl = p.getImgProduct(product_id);
        Path path = FileSystems.getDefault().getPath(appPath + oldFileUrl);
        if (fileName == "") {
            fileUrl = oldFileUrl;
        } else {
            Files.delete(path);
            String filePath = uploadPath + File.separator + fileName;
            filePart.write(filePath);
            fileUrl = request.getContextPath() + "/" + imgDir + "/" + fileName;
        }
            
            String name = request.getParameter("name");
            String brief_infor = request.getParameter("brief_infor");
            String desciption = request.getParameter("desciption");
            int original_price = Integer.parseInt(request.getParameter("original_price"));
            int sale_price = Integer.parseInt(request.getParameter("sale_price"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int categoryId = Integer.parseInt(request.getParameter("categoryId"));
            int status = Integer.parseInt(request.getParameter("status"));

            p.UpdateProduct(product_id, name, desciption, brief_infor, quantity, status, original_price, sale_price, categoryId, fileUrl);
            response.sendRedirect("product-detail?product_id="+product_id);
        
           
        //String url_thumbnail = "images/product/";
        
        

// Create a new file upload handler
        //ServletFileUpload upload = new ServletFileUpload(factory);
        //upload.setHeaderEncoding("UTF-8");

//        try {
//            // Parse the request
//            List<FileItem> items = upload.parseRequest(request);
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
//                        String url_old = pd.getUrlImageById(Integer.parseInt(fields.get("productId")));
//                        url_thumbnail = url_old;
//                        break;
//                    } else {
//                        Path path = Paths.get(filename);
//                        String storePath = servletContext.getRealPath("../../web/images/product");
//                        File uploadFile = new File(storePath + "/" + path.getFileName());
//                        item.write(uploadFile);
//                        url_thumbnail += filename;
//                    }
//
//                }
//            }
//            
//            int product_id = Integer.parseInt(fields.get("productId"));
//            String name = fields.get("name");
//            String brief_infor = fields.get("brief_infor");
//            String desciption = fields.get("desciption");
//            int original_price = Integer.parseInt(fields.get("original_price"));
//            int sale_price = Integer.parseInt(fields.get("sale_price"));
//            int quantity = Integer.parseInt(fields.get("quantity"));
//            int categoryId = Integer.parseInt(fields.get("categoryId"));
//            int status = Integer.parseInt(fields.get("status"));
//
//            
//            pd.UpdateProduct(product_id, name, desciption, brief_infor, quantity, status, original_price, sale_price, categoryId,url_thumbnail);
//            TimeUnit.SECONDS.sleep(1);
//            response.sendRedirect("product-detail?product_id="+product_id);
//        } catch (FileUploadException ex) {
//
//        } catch (Exception ex) {
//
//        }
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
