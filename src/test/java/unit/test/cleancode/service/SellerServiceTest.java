package unit.test.cleancode.service;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import unit.test.cleancode.dao.SellerDAO;
import unit.test.cleancode.dto.Seller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SellerServiceTest extends TestCase {

    @InjectMocks
    private SellerService sellerService;

    @Mock
    private SellerDAO sellerDAO;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldValidateSeller() {
        // stub
        Seller seller = Seller.builder().id(111L).build();

        // mock
        Seller seller1 = mock(Seller.class);
        when(seller1.getId()).thenReturn(111L);

        when(sellerDAO.findById(seller.getId())).thenReturn(seller);

        sellerService.validateSeller(seller.getId());

    }

    @Test
    public void shouldNotValidateSellerWhenSellerIsNotFound() {

        Seller seller = Seller.builder().id(111L).build();
        when(sellerDAO.findById(seller.getId())).thenReturn(null);

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("seller not found.");

        sellerService.validateSeller(seller.getId());

    }

}