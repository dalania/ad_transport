package tads.eaj.ufrn.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.model.Estado;
import tads.eaj.ufrn.backend.repositories.EstadoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    EstadoRepository estadoRepository;

    @Autowired
    public void setEstadoRepository(EstadoRepository estadoRepository) {
        this.estadoRepository = estadoRepository;
    }

    public Estado insert(Estado estado){
        return estadoRepository.save(estado);
    }

    public List<Estado> getAll(){
        return estadoRepository.findAllByDeletedIsNull();
    }

    public Optional<Estado> getById(Long id){
        return estadoRepository.findByIdAndDeletedIsNull(id);

    }

    public Estado update(Estado estado){
        return estadoRepository.saveAndFlush(estado);
    }

    public Estado delete(Long id){
        Estado estadoFound = estadoRepository.getByIdAndDeletedIsNull(id);
        estadoFound.setDeleted(new Date());
        return estadoRepository.saveAndFlush(estadoFound);


    }
}
