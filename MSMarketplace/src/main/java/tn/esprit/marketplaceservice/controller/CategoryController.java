package tn.esprit.marketplaceservice.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplaceservice.entities.Category;
import tn.esprit.marketplaceservice.service.MarketplaceService;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final MarketplaceService marketplaceService;

    @PostMapping
    public Category create(@RequestBody Category category) {
        return marketplaceService.createCategory(category);
    }

    @GetMapping
    public List<Category> getAll() {
        return marketplaceService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) {
        return marketplaceService.getCategoryById(id);
    }
}