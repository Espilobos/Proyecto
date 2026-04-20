package com.siamese.demo.repository;
import com.siamese.demo.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    public List<Producto> findByActivoTrue();
}
