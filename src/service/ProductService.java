package service;

import model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService implements IProductService {
    public static final String GET_PRODUCT = "select * from product";
    DAL dal;

    public ProductService() {
        dal = new DAL();
    }

    @Override
    public ArrayList<Product> getProductList() throws SQLException {
        ResultSet productList = dal.getData(GET_PRODUCT);
        ArrayList<Product> products = new ArrayList<>();
        while (productList.next()) {
            int id = productList.getInt(1);
            String name = productList.getString(2);
            float price = productList.getFloat(3);
            int amount = productList.getInt(4);
            String color = productList.getString(5);
            String category = productList.getString(6);
            String describes = productList.getString(7);
            products.add(new Product(id, name, price, amount, color, category, describes));
        }
        return products;
    }

    @Override
    public boolean addProduct(Product product) {
        return dal.updateData("insert into product (name_product, price, amount, color, category, describes) values ( '" + product.getName() + "', " + product.getPrice() + ", " + product.getAmount() + ", '" + product.getColor() + "', '" + product.getCategory() + "', '" + product.getDescribes() + "');");
    }

    @Override
    public Product getProductById(int id) throws SQLException {
        ResultSet product = dal.getData("select * from product where id = " + id + "");
        product.next();
        String name = product.getString(2);
        float price = product.getFloat(3);
        int amount = product.getInt(4);
        String color = product.getString(5);
        String cate = product.getString(6);
        String describes = product.getString(7);
        return new Product(id, name, price, amount, color, cate, describes);
    }

    @Override
    public boolean editProductById(int id, Product product) throws SQLException {
        return dal.updateData("update product set name_product = '"+ product.getName() +"' , price = "+ product.getPrice() +" , amount = "+ product.getAmount() +", color = '"+ product.getColor() +"' , category = '"+ product.getCategory() +"', describes = '"+ product.getDescribes() +"' where id = "+ id +";");
    }

    @Override
    public boolean deleteProductById(int id) {
      return   dal.updateData("delete from product where id = "+ id +"");
    }

    @Override
    public ArrayList<Product> searchProduct(String string) throws SQLException {
       ResultSet productList = dal.getData("select * from product where name_product like '%"+ string +"%'; ");
       ArrayList<Product> products = new ArrayList<>();
       while (productList.next()){
           int id = productList.getInt(1);
           String name = productList.getString(2);
           float price = productList.getFloat(3);
           int amount = productList.getInt(4);
           String color = productList.getString(5);
           String category = productList.getString(6);
           String describes = productList.getString(7);
           products.add(new Product(id, name, price, amount, color, category, describes));
       }
       return products;
    }
}
