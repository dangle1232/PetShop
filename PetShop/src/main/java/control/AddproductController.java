/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Category;
//import entity.Product;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
//import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AddproductController extends HttpServlet {

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
        DAO dao = new DAO();
        List<Category> listC = dao.getAllCategory();
        request.setAttribute("listC", listC);
        String proName = request.getParameter("proName");
        String proCategory = request.getParameter("proCategory");
        String proPrice = request.getParameter("proPrice");
        String proAmount = request.getParameter("proAmount");

        if (proName != null && proCategory != null && proPrice != null && proAmount != null) {
            if (Integer.parseInt(proAmount) < 0 || Integer.parseInt(proAmount) > 50) {
                request.setAttribute("error", "Số lượng không được bé hơn 0 và lớn hơn 50");
                request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
            } else {
                Part filePart = request.getPart("proImg");
                String proImg = filePart.getSubmittedFileName();
                InputStream imageInputStream = filePart.getInputStream();
                File imageFile = new File("C:/Users/Admin/OneDrive/Documents/GitHub/TDK_PetShop_Java/PetShop/src/main/webapp/assets/img/product/" + proImg);
                try ( FileOutputStream outputStream = new FileOutputStream(imageFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = imageInputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                dao.insertProduct(proName, proCategory, proPrice, proAmount, proImg);
                try {
                    // Wait for 5 seconds
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // Handle the exception
//                e.printStackTrace();
                }
                response.sendRedirect("product");
            }
        } else {
            request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
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
//        Part filePart = request.getPart("proImg");
//        // Get the name of the uploaded file
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//        // Get the input stream for the uploaded file
//        InputStream fileContent = filePart.getInputStream();
//        // Save the file to disk
//        File file = new File(getServletContext().getRealPath("C:/Users/Admin/OneDrive/Documents/GitHub/TDK_PetShop_Java/PetShop/src/main/webapp/assets/img/product"), fileName);
//        Files.copy(fileContent, file.toPath());
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
