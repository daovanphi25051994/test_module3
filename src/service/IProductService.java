package service;

import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProductService {
    ArrayList<Product> getProductList() throws SQLException;
    boolean addProduct(Product product);
    Product getProductById(int id) throws SQLException;
    boolean editProductById(int id , Product product) throws SQLException;
    boolean deleteProductById(int id);
    ArrayList<Product> searchProduct(String string) throws SQLException;
}
