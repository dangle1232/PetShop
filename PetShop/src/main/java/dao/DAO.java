/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.Category;
import entity.Item;
import entity.Order;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    //PRODUCT
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByID(String proId) {
        String query = "select * from petshop.product\n"
                + "where ProId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, proId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<Product> getProductByCategoryID(String proCategory) {
        List<Product> list = new ArrayList<>();
        String query = "select * from petshop.product\n"
                + "where ProCategory = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, proCategory);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {}
        return list;
    }

    public void insertProduct(String ProName, String ProCategory, String ProPrice, String ProAmount, String ProImg) {
        String query = "insert into petshop.product(ProName, ProCategory, ProPrice, ProAmount, ProImg) values (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ProName);
            ps.setString(2, ProCategory);
            ps.setString(3, ProPrice);
            ps.setString(4, ProAmount);
            ps.setString(5, ProImg);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteProduct(String ProId) {
        String query = "delete from petshop.product\n"
                + "where ProId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, ProId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(String proId, String proName, String proCategory, String proPrice, String proAmount, String proImg) {
        String query = "UPDATE petshop.product\n"
                + "set ProName = ?, "
                + "ProCategory = ?, "
                + "ProPrice = ?, "
                + "ProAmount = ?, "
                + "ProImg = ?\n"
                + "where ProId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(6, proId);
            ps.setString(1, proName);
            ps.setString(2, proCategory);
            ps.setString(3, proPrice);
            ps.setString(4, proAmount);
            ps.setString(5, proImg);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    //
    //Account
    //
    
    public void deleteAccount(String userId) {
        String query = "delete from petshop.account\n"
                + "where UserId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.account";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account getUserByID(String userId) {
        String query = "select * from petshop.account\n"
                + "where UserId = ?";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql
            ps = conn.prepareStatement(query);
            ps.setString(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Account> getUser() {
        List<Account> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.account WHERE RoleId = '2'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    //User Dang ky tai khoan
    public void signupUser(String userName, String pass, String accountName) {
        String query = "insert into petshop.account(UserName, Pass, AccountName) values (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, pass);
            ps.setString(3, accountName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account loginUser(String userName, String pass) {
        String query = "SELECT * FROM petshop.account WHERE UserName = ?  AND Pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account checkAccountExist(String userName) {
        String query = "SELECT * FROM petshop.account\n"
                + "where UserName = ?\n";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertEmploy(String UserName, String Pass, String AccountName, Integer RoleId) {
        String query = "insert into petshop.account(UserName, Pass, AccountName, RoleId) values (?, ?, ?, 2)";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            System.out.print("Enter Username: ");
            UserName = scanner.nextLine();
            System.out.print("Enter Pass: ");
            Pass = scanner.nextLine();
            System.out.print("Enter Name: ");
            AccountName = scanner.nextLine();
            ps = conn.prepareStatement(query);
            ps.setString(1, UserName);
            ps.setString(2, Pass);
            ps.setString(3, AccountName);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProfile(String userId, String pass, String accountName, String userImg) {
        String query = "update petshop.account\n"
                + "set Pass = ?, "
                + "AccountName = ?, "
                + "UserImg = ?\n"
                + "where UserId = ?";
        Scanner scanner = new Scanner(System.in);
        try {
            conn = new DBContext().getConnection();//mo ket noi voi sql

            ps = conn.prepareStatement(query);
            ps.setString(4, userId);
            ps.setString(1, pass);
            ps.setString(2, accountName);
            ps.setString(3, userImg);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "SELECT * FROM petshop.category";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select * from petshop.product\n"
                            + "where ProId = ?";
                    conn = new DBContext().getConnection();
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, item.getProId());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setProId(rs.getInt("proId"));
                        row.setProName(rs.getString("proName"));
                        row.setProCategory(rs.getString("proCategory"));
                        row.setProPrice(rs.getDouble("proPrice"));
                        row.setTotal_quantity(rs.getDouble("proPrice") * item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public double getTotal(ArrayList<Cart> cartList) {
        double sum = 0;
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {
                    String query = "select ProPrice from petshop.product where ProId = ?";
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, item.getProId());
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("proPrice") * item.getQuantity();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }

    public boolean insertOrder(Order model) {
        boolean result = false;

        try {
            String query = "insert into petshop.order(productId, userId, orderQuantity, orderDate) values(?,?,?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, model.getProId());
            ps.setInt(2, model.getUid());
            ps.setInt(3, model.getQuantity());
            ps.setString(4, model.getDate());
            ps.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM petshop.order where userId=? order by petshop.order.orderId desc";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                DAO dao = new DAO();
                String pId = rs.getString("productId");
                Product product = dao.getProductByID(pId);
                order.setOrderId(rs.getInt("orderId"));
                order.setProId(Integer.parseInt(pId));
                order.setProName(product.getProName());
                order.setProCategory(product.getProCategory());
                order.setProPrice(product.getProPrice() * rs.getInt("orderQuantity"));
                order.setQuantity(rs.getInt("orderQuantity"));
                order.setDate(rs.getString("orderDate"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cancelOrder(int id) {
        try {
            String query = "delete from petshop.order where orderid=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
//        List<Product> listP = dao.getAllProduct();
//        for(Product o : listP){
//            System.out.println(o);
//        } //Work
//        dao.loginUser("", "");
//        List<Category> listC = dao.getAllCategory();
//        for(Category c : listC){
//            System.out.println(c);
//        } //Work
//        List<Account> listA = dao.getUser();
//        for(Account a : listA){
//            System.out.println(a);
//        }
//        List<Account> listE = dao.getEmploy();
//        for(Account e : listE){
//            System.out.println(e);
//        }
//        dao.updateProfile("", "", Integer.SIZE); //Work
//        dao.insertProduct("", Integer.BYTES, Double.NaN, Integer.MIN_VALUE, ""); //Work 
//        dao.deleteProduct(""); //Work
//        dao.updateProduct(Integer.SIZE, "", Integer.BYTES, Double.NaN, Integer.MIN_VALUE, "");
//          dao.updateProduct("", "", "", "", "", "");
    }
}
