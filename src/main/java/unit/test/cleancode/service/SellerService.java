package unit.test.cleancode.service;

import unit.test.cleancode.dao.SellerDAO;
import unit.test.cleancode.dto.Seller;

public class SellerService {

    private SellerDAO sellerDAO = new SellerDAO();

    public void validateSeller(Long sellerId) {
        Seller seller = sellerDAO.findById(sellerId);
        if (seller == null) {
            throw new RuntimeException("seller not found.");
        }
    }
}
