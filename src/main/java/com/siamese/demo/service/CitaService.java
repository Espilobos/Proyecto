package com.siamese.demo.service;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.repository.CitaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    private List<Cita> citas = new ArrayList<>();
    private Long contadorId = 1L;

    // Guardar
    public void guardar(Cita cita) {
        cita.setId(contadorId++);
        citas.add(cita);
    }

    // Listar
    public List<Cita> listar() {
        return citas;
    }

    // Eliminar
    public void eliminar(Long id) {
        citas.removeIf(c -> c.getId().equals(id));
    }
//    private CitaRepository citaRepository;
//    
//    public void guardar(Cita cita){
//        citaRepository.save(cita);
//    }
//    
//    public List<Cita> listar(){
//        return citaRepository.findAll();
//    }
//    public void eliminar(Long id) {
//        citaRepository.deleteById(id);
//    }
}
