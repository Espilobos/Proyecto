package com.siamese.demo.repository;

import com.siamese.demo.domain.Cita;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByMascotaId(Long Id);
}
