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

@WebServlet(name = "ProductAdminServlet", urlPatterns = "/product")
public class ProductAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add" :
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/add_product.jsp");
                requestDispatcher.forward(request, response);
            break;
            case "edit" :
                try {
                    moveEditProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete" :
                try {
                    deleteProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "search" :
                try {
                    searchProduct(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            default:
                try {
                    showProductList(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String string = request.getParameter("string");
        ProductService productService = new ProductService();
       ArrayList<Product> productList =  productService.searchProduct(string);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/product.jsp");
        request.setAttribute("productList", productList);
        requestDispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id =request.getParameter("id");
        ProductService productService = new ProductService();
        int newId = Integer.valueOf(id);
       boolean deleted = productService.deleteProductById(newId);
       if (deleted){
           request.setAttribute("message", "delete successfully");
           ArrayList<Product> productList = productService.getProductList();
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/product.jsp");
           request.setAttribute("productList", productList);
           requestDispatcher.forward(request, response);
       }
    }

    private void moveEditProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ProductService productService = new ProductService();
        String id = request.getParameter("id");
        int newID = Integer.valueOf(id);
        Product product = productService.getProductById(newID);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/add_product.jsp");
        request.setAttribute("product", product);
        requestDispatcher.forward(request, response);
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        ProductService productService = new ProductService();
        ArrayList<Product> productList = productService.getProductList();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin/product.jsp");
        request.setAttribute("productList", productList);
        requestDispatcher.forward(request, response);
    }


}
