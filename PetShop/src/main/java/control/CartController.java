/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dao.DAO;
import entity.Cart;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class CartController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        ArrayList<Cart> cartList = new ArrayList<>();
        int pid = Integer.parseInt(request.getParameter("id"));
        Cart cart = new Cart();
        cart.setProId(pid);
        cart.setQuantity(1);

        HttpSession session = request.getSession();
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

        if (cart_list == null) {
            cartList.add(cart);
            session.setAttribute("cart-list", cartList);
            response.sendRedirect("home");
        } else {
            cartList = cart_list;
            boolean exist = false;
            for (Cart c : cart_list) {
                if (c.getProId() == pid) {
                    exist = true;
                    out.println("<h3>exist<a href='Cart.jsp'>Go to cart</a></h3>");
                }
            }
            if (!exist) {
                cartList.add(cart);
                response.sendRedirect("home");
            }
        }
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CartController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CartController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
//        DAO dao = new DAO();
//        String pid = request.getParameter("pid");
//        Product product = dao.getProductByID(pid);
//
//        HttpSession session = request.getSession();
//        Object obj = session.getAttribute("cart");// luu tam vao session
//        if (obj == null) {// tao moi
//            // Tao mat hang
//            BillProduct billProduct = new BillProduct();
//            billProduct.setProduct(product);
//            billProduct.setQuantity(1);
//            billProduct.setUnitPrice(product.getPrice());
//            // gio hang co nhieu mat hang
//            Map<String, BillProduct> map = new HashMap<>();
//            map.put(pid, billProduct);// them mat hang vao ds
//
//            session.setAttribute("cart", map);// luu tam vao session
//        } else {
//            Map<String, BillProduct> map = (Map<String, BillProduct>) obj;
//
//            BillProduct billProduct = map.get(pid);
//
//            if (billProduct == null) {
//                billProduct = new BillProduct();
//                billProduct.setProduct(product);
//                billProduct.setQuantity(1);
//                billProduct.setUnitPrice(product.getPrice());
//
//                map.put(pid, billProduct);
//            } else {
//
//                billProduct.setQuantity(billProduct.getQuantity() + 1);
//            }
//
//            session.setAttribute("cart", map);// luu tam vao session
//        }
//
//        response.sendRedirect(request.getContextPath() + "/cart");
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
//        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//    private void saveCartToCookie(HttpServletRequest req, HttpServletResponse resp) {
//        Cookie cookie = new Cookie("cart", encodeCart(cart));
//        cookie.setMaxAge(60 * 60 * 24 * 7); // 1 week
//        cookie.setPath(req.getContextPath());
//        resp.addCookie(cookie);
//    }
//
//    private String encodeCart(Cart cart) {
//        Gson gson = new Gson();
//        return gson.toJson(cart.getItems());
//    }
//
//    private Cart decodeCart(String encodedCart) {
//        Gson gson = new Gson();
//        Map<String, Integer> items = gson.fromJson(encodedCart, new TypeToken<Map<String, Integer>>() {
//        }.getType());
//        Cart cart = new Cart();
//        cart.getItems().putAll(items);
//        return cart;
//    }
//
//    @Override
//    public void destroy() {
//        super.destroy();
//        cart = null;
//    }
}
