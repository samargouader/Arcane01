package tn.esprit.marketplaceservice.service;

import tn.esprit.marketplaceservice.entities.Product;
import tn.esprit.marketplaceservice.entities.Purchase;

import java.util.List;

public interface IMarketplaceService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByCategory(Long categoryId);

    Purchase buyProduct(String userId, Long productId, Integer quantity);
    List<Purchase> getPurchasesByUser(String userId);
}