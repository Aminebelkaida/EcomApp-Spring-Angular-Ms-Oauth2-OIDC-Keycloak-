package net.belkaida.inventoryservice.web;

import net.belkaida.inventoryservice.entities.Product;
import net.belkaida.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping("/api")
//@CrossOrigin("*")
public class ProductRestController {
    //Injeceter ProductRepository
    private ProductRepository productRepository;

    //Injection via le constructeur (bonnes pratiques)
    public ProductRestController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //Méhtode pour lister les produits
    @GetMapping("/products")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public List<Product> productList(){
        return productRepository.findAll();
    }
    //Méthode pour consulter un produit
    @GetMapping("/products/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public Product producById(@PathVariable String id){
        return productRepository.findById(id).get();
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
