package com.siamese.demo.repository;


import com.siamese.demo.domain.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {

    public Optional<Rol> findByRol(String rol);

}

    