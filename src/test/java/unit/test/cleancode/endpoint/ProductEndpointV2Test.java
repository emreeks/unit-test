package unit.test.cleancode.endpoint;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import unit.test.cleancode.dto.Product;
import unit.test.cleancode.request.SaveProductRequest;
import unit.test.cleancode.response.SaveProductResponse;
import unit.test.cleancode.service.CategoryService;
import unit.test.cleancode.service.ProductService;
import unit.test.cleancode.service.SellerService;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductEndpointV2Test extends TestCase {

    @InjectMocks
    private ProductEndpointV2 productEndpointV2;

    @Mock
    private ProductService productService;

    @Mock
    private SellerService sellerService;

    @Mock
    private CategoryService categoryService;

    @Test
    public void shouldSaveProduct() {
        Product product = Product.builder().categoryId(11L).sellerId(111L).build();
        SaveProductRequest saveProductRequest = SaveProductRequest.builder().product(product).build();

        SaveProductResponse saveProductResponse = productEndpointV2.saveProduct(saveProductRequest);

        verify(sellerService).validateSeller(product.getSellerId());
        verify(categoryService).validateCategory(product.getCategoryId());
        verify(productService).validateProduct(product);
        verify(productService).saveProduct(product);

        assertTrue(saveProductResponse.getSuccess());
    }

}