package Controller.Product;

import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet(name = "AddProductController", urlPatterns = {"/addproduct"})
public class AddProductController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String url_thumbnail = "images/product/";

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Configure a repository (to ensure a secure temp location is used)
        ServletContext servletContext = this.getServletConfig().getServletContext();
        File repository = (File) servletContext.getAttribute("jakarta.servlet.context.tempdir");
        factory.setRepository(repository);

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("UTF-8");

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
//            ProductDAO p = new ProductDAO();
//            String name = fields.get("name");
//            String desciption = fields.get("desciption");
//            String brief_infor = fields.get("brief_infor");
//            boolean status = Boolean.parseBoolean(fields.get("status"));
//            int quantity = Integer.parseInt(fields.get("quantity"));
//            int original_price = Integer.parseInt(fields.get("original_price"));
//            int sale_price = Integer.parseInt(fields.get("sale_price"));
//
//            int categoryId = Integer.parseInt(fields.get("categoryId"));
//
//            int new_id = p.addNewProduct(name, desciption, brief_infor, quantity, status, original_price, sale_price, categoryId);
//            p.AddImageProduct(new_id, url_thumbnail);
//            response.sendRedirect("marketingproductlist");
//        } catch (FileUploadException ex) {
//
//        } catch (Exception ex) {
//
//        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}