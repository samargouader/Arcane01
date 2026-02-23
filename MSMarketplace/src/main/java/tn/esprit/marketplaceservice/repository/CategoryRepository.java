package tn.esprit.marketplaceservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.marketplaceservice.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
