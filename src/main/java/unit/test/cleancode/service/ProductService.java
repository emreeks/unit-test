package unit.test.cleancode.service;

import unit.test.cleancode.dto.Product;

public class ProductService {

    public void validateProduct(Product product) {

        if (product.getTitle() == null) {
            throw new RuntimeException("empty title.");
        }

        if (product.getPrice() == null) {
            throw new RuntimeException("empty price.");
        }

        if (product.getStock() == null) {
            throw new RuntimeException("empty stock.");
        }

    }

    public void saveProduct(Product product){
        // save product
    }

}
