package com.siamese.demo.repository;

import com.siamese.demo.domain.Mascota;
import com.siamese.demo.domain.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByUsuario(Usuario usuario);
}
