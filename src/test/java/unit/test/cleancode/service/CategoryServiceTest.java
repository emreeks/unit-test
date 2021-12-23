package unit.test.cleancode.service;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import unit.test.cleancode.dao.CategoryDAO;
import unit.test.cleancode.dto.Category;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest extends TestCase {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryDAO categoryDAO;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldValidateCategory() {
        Category category = Category.builder().id(11L).build();

        when(categoryDAO.findById(category.getId())).thenReturn(category);

        categoryService.validateCategory(category.getId());

        verify(categoryDAO).findById(category.getId());
    }

    @Test
    public void shouldValidateNotCategoryWhenCategoryNotFound() {
        Category category = Category.builder().id(11L).build();

        when(categoryDAO.findById(category.getId())).thenReturn(null);

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("category not found.");

        categoryService.validateCategory(category.getId());
    }

}