package com.siamese.demo.service;

import com.siamese.demo.domain.Cita;
import com.siamese.demo.repository.CitaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CitaService {

    private final CitaRepository citaRepository;
    
    public CitaService(CitaRepository citaRepository){
        this.citaRepository = citaRepository;
    }
    public void guardar(Cita cita){
        citaRepository.save(cita);
    }
    public Cita buscarPorId(Long id){
        return citaRepository.findById(id).orElse(null);
    }
    
    public List<Cita> listar(){
        return citaRepository.findAll();
    }
    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
    public List<Cita> buscarPorMascota(Long id) {
    return citaRepository.findByMascotaId(id);
}
}
