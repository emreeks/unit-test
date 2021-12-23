package unit.test.cleancode.endpoint;

import unit.test.cleancode.dto.Product;
import unit.test.cleancode.request.SaveProductRequest;
import unit.test.cleancode.response.SaveProductResponse;
import unit.test.cleancode.service.CategoryService;
import unit.test.cleancode.service.ProductService;
import unit.test.cleancode.service.SellerService;

public class ProductEndpointV2 {

    private ProductService productService = new ProductService();
    private SellerService sellerService = new SellerService();
    private CategoryService categoryService = new CategoryService();

    public SaveProductResponse saveProduct(SaveProductRequest request) {

        Product product = request.getProduct();

        sellerService.validateSeller(product.getSellerId());

        categoryService.validateCategory(product.getCategoryId());

        productService.validateProduct(product);

        productService.saveProduct(product);

        return SaveProductResponse.builder().success(Boolean.TRUE).build();
    }

}
