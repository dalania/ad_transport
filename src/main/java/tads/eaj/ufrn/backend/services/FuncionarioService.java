package tads.eaj.ufrn.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.repositories.FuncionarioRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    @Autowired
    public void setRepository(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Optional<Funcionario> getFuncionarioByid(Long id){
        return repository.findByDeletedIsNullAndId(id);
        //option faz com que uma busca num banco de dados nunca retorne null,
    }

    public List<Funcionario> getAllFuncionario(){
        return  repository.findAllByDeletedIsNull();
    }

    public Funcionario insertFuncionario (Funcionario func){
       return repository.save(func);

    }

    public Funcionario update(Funcionario func){
        return repository.saveAndFlush(func); //salva e atualiza o objeto de funcionário com os novos dados
    }

    public Funcionario deleteFuncionario(Long id){
        Funcionario funcFound = repository.getById(id);
        funcFound.setDeleted(new Date());
        return repository.saveAndFlush(funcFound);

    }


}
