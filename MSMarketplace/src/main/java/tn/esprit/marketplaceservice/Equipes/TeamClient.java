package tn.esprit.marketplaceservice.Equipes;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "team-service")
public interface TeamClient {

    @RequestMapping("/Arcane/teams")
    public List<Team> getAllProducts();

    @RequestMapping("/Arcane/teams/{id}")
    public Team getProductById(@PathVariable("id") Long id);
}
