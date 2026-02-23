package tn.esprit.marketplaceservice.service;

import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.stereotype.Service;
import tn.esprit.marketplaceservice.entities.Category;
import tn.esprit.marketplaceservice.entities.Product;
import tn.esprit.marketplaceservice.entities.Purchase;
import tn.esprit.marketplaceservice.entities.PurchaseStatus;
import tn.esprit.marketplaceservice.repository.CategoryRepository;
import tn.esprit.marketplaceservice.repository.ProductRepository;
import tn.esprit.marketplaceservice.repository.PurchaseRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketplaceService implements IMarketplaceService {

    private final ProductRepository productRepository;
    private final PurchaseRepository purchaseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product updateProduct(Long id, Product newProduct) {
        Product product = getProductById(id);
        product.setName(newProduct.getName());
        product.setDescription(newProduct.getDescription());
        product.setPrice(newProduct.getPrice());
        product.setStock(newProduct.getStock());
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    @Transactional
    public Purchase buyProduct(String userId, Long productId, Integer quantity) {
        Product product = getProductById(productId);

        if (product.getStock() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        Purchase purchase = Purchase.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .totalPrice(product.getPrice() * quantity)
                .status(PurchaseStatus.COMPLETED)
                .build();

        return purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> getPurchasesByUser(String userId) {
        return purchaseRepository.findByUserId(userId);
    }
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}