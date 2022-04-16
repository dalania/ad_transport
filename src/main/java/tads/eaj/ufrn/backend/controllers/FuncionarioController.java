package tads.eaj.ufrn.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.backend.dto.request.FuncionarioRequestDto;
import tads.eaj.ufrn.backend.dto.response.FuncionarioResponseDto;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.services.FuncionarioService;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, exposedHeaders = "X-Total-Count")

@RequestMapping("/funcionario")
public class FuncionarioController {

    private FuncionarioService service;

    @Autowired
    public void setService(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<FuncionarioResponseDto> getFuncionarioById(@PathVariable Long id){
       Optional<Funcionario> funcFound = service.getFuncionarioByid(id);
        if(funcFound == null){
            return ResponseEntity.notFound().build(); //caso o funcionario que esteja procurando não existir, ele retorna not found
        }else{
            FuncionarioResponseDto funcionarioResponseDto = new FuncionarioResponseDto(funcFound.get());
            funcionarioResponseDto.add(linkTo(methodOn(FuncionarioController.class).delete(id)).withRel("Deletar funcionario"));
            funcionarioResponseDto.add(linkTo(methodOn(FuncionarioController.class).delete(id)).withRel("atualizar funcionario"));
            funcionarioResponseDto.add(linkTo(methodOn(FuncionarioController.class).getAllFuncionario()).withRel("Listar de Funcionarios"));
            return ResponseEntity.ok().body(funcionarioResponseDto);
        }
    }

    @GetMapping
    public List<Funcionario> getAllFuncionario(){

        return service.getAllFuncionario();
    }
    @PostMapping
    public ResponseEntity<FuncionarioResponseDto> insert(@RequestBody FuncionarioRequestDto funcDto){
      Funcionario func = service.insertFuncionario(funcDto.build()); //converte os dados que chegaram de pessoadto para um objeto pessoa
       return ResponseEntity.created(URI.create("/funcionario/"+func.getId())).body(new FuncionarioResponseDto(func));

    }
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        return service.getFuncionarioByid(id) //verifica se o funcionário existe
                .map( record  -> {
                    if(record.getId().equals(funcionario.getId())){
                        service.update(funcionario);
                        return ResponseEntity.ok(funcionario);

                    }else{
                        return ResponseEntity.notFound().build();
                    }

                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id){
         var reponseMsg = new HashMap();

        return service.getFuncionarioByid(id)
                .map(record -> {
                    reponseMsg.put("message", "the employee was successfully deleted");
                    service.deleteFuncionario(record.getId());
                    return  ResponseEntity.ok().body(reponseMsg);
                }).orElse(ResponseEntity.notFound().build());
    }

}
