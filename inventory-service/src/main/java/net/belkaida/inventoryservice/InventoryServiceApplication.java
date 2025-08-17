package net.belkaida.inventoryservice;

import lombok.Builder;
import net.belkaida.inventoryservice.entities.Product;
import net.belkaida.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder().id("P01").name("Pc").price(2500).quantity(15)
                    .build());
            productRepository.save(Product.builder().id("P02").name("Printer").price(1900).quantity(9)
                    .build());
            productRepository.save(Product.builder().id("P03").name("Smart phone").price(8500).quantity(7)
                    .build());

        };
    }

}
