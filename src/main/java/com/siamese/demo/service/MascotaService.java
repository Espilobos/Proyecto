package com.siamese.demo.service;

import com.siamese.demo.domain.Mascota;
import com.siamese.demo.repository.MascotaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MascotaService {
    private final MascotaRepository mascotaRepository;

    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }
    
    public void guardar(Mascota mascota){
        mascotaRepository.save(mascota);
    }
    public Mascota buscarPorId(Long id){
        return mascotaRepository.findById(id).orElse(null);
    }
    
    public List<Mascota> listar(){
        return mascotaRepository.findAll();
    }
    public void eliminar(Long id) {
        mascotaRepository.deleteById(id);
    }
}
