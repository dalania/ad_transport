package tads.eaj.ufrn.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.model.Transportadora;
import tads.eaj.ufrn.backend.repositories.TransportadoraRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransportadoraService {
    TransportadoraRepository transportadoraRepository;

    @Autowired
    public void setTransportadoraRepository(TransportadoraRepository transportadoraRepository) {
        this.transportadoraRepository = transportadoraRepository;
    }

    public List<Transportadora> getAll(){
        return  transportadoraRepository.findAllByDeletedIsNull();

    }

    public Optional<Transportadora> getTransportadoraById(Long id){
        return  transportadoraRepository.findByIdAndDeletedIsNull(id);
    }

    public Transportadora insert(Transportadora transportadora){
        return transportadoraRepository.save(transportadora);
    }

    public Transportadora updateTransportadora(Transportadora transportadora){
        return transportadoraRepository.saveAndFlush(transportadora);
    }

    public Transportadora deleteTransportadora(Long id){
        Transportadora foundTransportadora = transportadoraRepository.getTransportadoraByIdAndDeletedIsNull(id);
        foundTransportadora.setDeleted(new Date());
        return transportadoraRepository.save(foundTransportadora);
    }


}
