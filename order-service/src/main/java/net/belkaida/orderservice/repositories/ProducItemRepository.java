package net.belkaida.orderservice.repositories;

import net.belkaida.orderservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducItemRepository extends JpaRepository<ProductItem, Long > {
}
