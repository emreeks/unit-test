package unit.test.cleancode.service;

import unit.test.cleancode.dao.CategoryDAO;
import unit.test.cleancode.dto.Category;

public class CategoryService {

    private CategoryDAO categoryDAO;

    public void validateCategory(Long categoryId) {
        Category category = categoryDAO.findById(categoryId);
        if (category == null) {
            throw new RuntimeException("category not found.");
        }
    }

}
