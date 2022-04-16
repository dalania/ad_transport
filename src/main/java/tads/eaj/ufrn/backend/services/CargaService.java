package tads.eaj.ufrn.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.backend.repositories.CargaRepository;
import tads.eaj.ufrn.backend.repositories.FuncionarioRepository;

import java.util.Date;
import java.util.Optional;
import java.util.List;

@Service
public class CargaService {
    CargaRepository cargaRepository;
    FuncionarioRepository funcionarioRepository;

    @Autowired
    public void setCargaRepository(CargaRepository cargaRepository) {
        this.cargaRepository = cargaRepository;
    }
    //terminei
    public tads.eaj.ufrn.backend.model.Carga insertCarga(tads.eaj.ufrn.backend.model.Carga carga){
        return cargaRepository.saveAndFlush(carga);
    }

    //terminei
    public Optional<tads.eaj.ufrn.backend.model.Carga> getById(Long id){
        return cargaRepository.findCargaByIdAndDeletedIsNull(id);
    }

    //terminei
    public List<tads.eaj.ufrn.backend.model.Carga> getAll(){
        return cargaRepository.findAllByDeletedIsNull();
    }

    //terminei
    public tads.eaj.ufrn.backend.model.Carga delete(Long id){
        tads.eaj.ufrn.backend.model.Carga carga = cargaRepository.getById(id);
        carga.setDeleted(new Date());
        return cargaRepository.saveAndFlush(carga);
    }

    //terminei
    public tads.eaj.ufrn.backend.model.Carga update(tads.eaj.ufrn.backend.model.Carga carga){
        return cargaRepository.saveAndFlush(carga);
    }
}
