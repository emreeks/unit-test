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
import unit.test.cleancode.dao.ProductDAO;
import unit.test.cleancode.dao.SellerDAO;
import unit.test.cleancode.dto.Category;
import unit.test.cleancode.dto.Product;
import unit.test.cleancode.dto.Seller;
import unit.test.cleancode.endpoint.ProductEndpoint;
import unit.test.cleancode.request.SaveProductRequest;
import unit.test.cleancode.response.SaveProductResponse;

import java.math.BigDecimal;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductEndpointTest extends TestCase {

    @InjectMocks
    private ProductEndpoint productEndpoint;

    @Mock
    private ProductDAO productDAO;

    @Mock
    private SellerDAO sellerDAO;

    @Mock
    private CategoryDAO categoryDAO;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldNotSaveWhenSellerNotFound() {
        Product product = Product.builder().sellerId(11L).build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("seller not found.");

        when(sellerDAO.findById(product.getSellerId())).thenReturn(null);

        productEndpoint.saveProduct(saveProductRequest);
    }

    @Test
    public void shouldNotSaveWhenCategoryNotFound() {
        Product product = Product.builder().sellerId(11L).categoryId(111L).build();
        Seller seller = Seller.builder().build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("category not found.");

        when(sellerDAO.findById(product.getSellerId())).thenReturn(seller);
        when(categoryDAO.findById(product.getCategoryId())).thenReturn(null);

        productEndpoint.saveProduct(saveProductRequest);
    }

    @Test
    public void shouldNotSaveWhenProductTitleIsMissing() {
        Product product = Product.builder().sellerId(11L).categoryId(111L).build();
        Seller seller = Seller.builder().build();
        Category category = Category.builder().build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("empty title.");

        when(sellerDAO.findById(product.getSellerId())).thenReturn(seller);
        when(categoryDAO.findById(product.getCategoryId())).thenReturn(category);

        productEndpoint.saveProduct(saveProductRequest);
    }

    @Test
    public void shouldNotSaveWhenProductPriceIsMissing() {
        Product product = Product.builder().sellerId(11L).categoryId(111L).title("Iphone").build();
        Seller seller = Seller.builder().build();
        Category category = Category.builder().build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("empty price.");

        when(sellerDAO.findById(product.getSellerId())).thenReturn(seller);
        when(categoryDAO.findById(product.getCategoryId())).thenReturn(category);

        productEndpoint.saveProduct(saveProductRequest);
    }

    @Test
    public void shouldNotSaveWhenProductStockIsMissing() {
        Product product = Product.builder().sellerId(11L).categoryId(111L).title("Iphone").price(BigDecimal.TEN).build();
        Seller seller = Seller.builder().build();
        Category category = Category.builder().build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("empty stock.");

        when(sellerDAO.findById(product.getSellerId())).thenReturn(seller);
        when(categoryDAO.findById(product.getCategoryId())).thenReturn(category);

        productEndpoint.saveProduct(saveProductRequest);
    }

    @Test
    public void shouldSaveProduct() {
        Product product = Product.builder().sellerId(11L).categoryId(111L).title("Iphone").price(BigDecimal.TEN).stock(10).build();
        Seller seller = Seller.builder().build();
        Category category = Category.builder().build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        when(sellerDAO.findById(product.getSellerId())).thenReturn(seller);
        when(categoryDAO.findById(product.getCategoryId())).thenReturn(category);

        SaveProductResponse saveProductResponse = productEndpoint.saveProduct(saveProductRequest);

        verify(productDAO).saveProduct(product);

        assertTrue(saveProductResponse.getSuccess());
        assertNull(saveProductResponse.getErrorMessage());
    }
}