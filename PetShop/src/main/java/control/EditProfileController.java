/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
        maxFileSize = 1024 * 1024 * 50, // 50 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EditProfileController extends HttpServlet {

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
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        String userId = request.getParameter("userId");
        String pass = request.getParameter("pass");
        account.setPass(pass);
        String accountName = request.getParameter("accountName");
        account.setAccountName(accountName);
        String userImg = request.getParameter("userImg");
        Part filePart = request.getPart("imageProfile");
        String fileName = filePart.getSubmittedFileName();

        if (!fileName.isEmpty()) {
            InputStream imageInputStream = filePart.getInputStream();
            File imageFile = new File("C:/Users/Admin/OneDrive/Documents/GitHub/TDK_PetShop_Java/PetShop/src/main/webapp/assets/img/account/" + fileName);
            File imageRemove = new File("C:/Users/Admin/OneDrive/Documents/GitHub/TDK_PetShop_Java/PetShop/src/main/webapp/assets/img/account/" + userImg);
            Path path = Paths.get(imageRemove.getAbsolutePath());
            Files.delete(path);
            try ( FileOutputStream outputStream = new FileOutputStream(imageFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = imageInputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
            account.setUserImg(fileName);
            dao.updateProfile(userId, pass, accountName, fileName);
            session.setAttribute("account", account);
            try {
                // Wait for 5 seconds
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                // Handle the exception
//                e.printStackTrace();
            }
            response.sendRedirect("home");
        } else {
            account.setUserImg(userImg);
            dao.updateProfile(userId, pass, accountName, userImg);
            session.setAttribute("account", account);
            try {
                // Wait for 5 seconds
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Handle the exception
//                e.printStackTrace();
            }
            response.sendRedirect("home");
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
