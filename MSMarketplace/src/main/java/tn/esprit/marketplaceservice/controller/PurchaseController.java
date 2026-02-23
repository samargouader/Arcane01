package tn.esprit.marketplaceservice.controller;

import lombok.*;
import org.springframework.web.bind.annotation.*;
import tn.esprit.marketplaceservice.entities.Purchase;
import tn.esprit.marketplaceservice.service.MarketplaceService;
import java.util.List;
@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
public class PurchaseController {

    private final MarketplaceService service;

    @PostMapping("/buy")
    public Purchase buy(@RequestParam String userId,
                        @RequestParam Long productId,
                        @RequestParam Integer quantity) {
        return service.buyProduct(userId, productId, quantity);
    }

    @GetMapping("/user/{userId}")
    public List<Purchase> getMyPurchases(@PathVariable String userId) {
        return service.getPurchasesByUser(userId);
    }
}