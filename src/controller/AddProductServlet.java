package controller;

import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "AddProductServlet", urlPatterns = "/add_product")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "edit" :
                try {
                    editProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "back":
                try {
                    moveProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");
        String color = request.getParameter("color");
        String describes = request.getParameter("describes");
        String category = request.getParameter("category");
        int newId = Integer.valueOf(id);
        float newPrice = Float.parseFloat(price);
        int newAmount = Integer.valueOf(amount);
        Product product = new Product(newId, name, newPrice , newAmount, color, describes, category);
        ProductService productService = new ProductService();
        productService.editProductById(newId, product);
       request.setAttribute("message", "edit successfully!!");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/add_product.jsp");
        requestDispatcher.forward(request, response);


    }

    private void moveProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ProductService productService = new ProductService();
        ArrayList<Product> productList = productService.getProductList();
        request.setAttribute("productList", productList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/product.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductService productService = new ProductService();
        String name = request.getParameter("name");
        String priceString = request.getParameter("price");
        String amountString = request.getParameter("amount");
        String color = request.getParameter("color");
        String category = request.getParameter("category");
        String describes = request.getParameter("describes");
        float price = Float.parseFloat(priceString);
        int amount = Integer.valueOf(amountString);
        Product product = new Product(name, price, amount, color, category, describes);
        boolean isSaved = productService.addProduct(product);
        if (isSaved) {
            request.setAttribute("message", "create successfully!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/add_product.jsp");
            requestDispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "create fail!!");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/add_product.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
