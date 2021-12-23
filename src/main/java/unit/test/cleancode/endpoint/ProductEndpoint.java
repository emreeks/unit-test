package unit.test.cleancode.endpoint;

import unit.test.cleancode.dao.CategoryDAO;
import unit.test.cleancode.dao.ProductDAO;
import unit.test.cleancode.dao.SellerDAO;
import unit.test.cleancode.dto.Category;
import unit.test.cleancode.dto.Product;
import unit.test.cleancode.dto.Seller;
import unit.test.cleancode.request.SaveProductRequest;
import unit.test.cleancode.response.SaveProductResponse;

public class ProductEndpoint {

    private ProductDAO productDAO = new ProductDAO();
    private SellerDAO sellerDAO = new SellerDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();

    public SaveProductResponse saveProduct(SaveProductRequest request){

        Product product = request.getProduct();

        Seller seller = sellerDAO.findById(product.getSellerId());
        if(seller == null){
            throw new RuntimeException("seller not found.");
        }

        Category category = categoryDAO.findById(product.getCategoryId());
        if(category == null){
            throw new RuntimeException("category not found.");
        }

        if(product.getTitle() == null){
            throw new RuntimeException("empty title.");
        }

        if(product.getPrice() == null){
            throw new RuntimeException("empty price.");
        }

        if(product.getStock() == null){
            throw new RuntimeException("empty stock.");
        }

        productDAO.saveProduct(product);
        return SaveProductResponse.builder().success(Boolean.TRUE).build();
    }

}
