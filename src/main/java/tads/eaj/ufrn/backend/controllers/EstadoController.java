package tads.eaj.ufrn.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.backend.dto.request.EstadoRequestDTO;
import tads.eaj.ufrn.backend.dto.request.TransportadoraRequestDTO;
import tads.eaj.ufrn.backend.dto.response.EstadoResponseDto;
import tads.eaj.ufrn.backend.dto.response.FuncionarioResponseDto;
import tads.eaj.ufrn.backend.dto.response.TransportadoraResponseDto;
import tads.eaj.ufrn.backend.model.Estado;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.model.Transportadora;
import tads.eaj.ufrn.backend.services.EstadoService;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/estado")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")

public class EstadoController {
    EstadoService estadoService;

    @Autowired
    public void setEstadoService(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping
    public List<Estado> getAllEstado(){

        return estadoService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<EstadoResponseDto> getFuncionarioById(@PathVariable Long id){
        Optional<Estado> estadoFound = estadoService.getById(id);
        if(estadoFound.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            EstadoResponseDto estadoResponseDto = new EstadoResponseDto(estadoFound.get());
            return ResponseEntity.ok().body(estadoResponseDto);
        }
    }


    @PostMapping
    public ResponseEntity<EstadoResponseDto> insert(@RequestBody EstadoRequestDTO estadoDto){
        Estado estado= estadoService.insert(estadoDto.build());
        return ResponseEntity.created(URI.create("/estado/"+estado.getId())).body(new EstadoResponseDto(estado));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Estado estado){
        return estadoService.getById(id)
                .map( record -> {
                    if(record.getId().equals(estado.getId())){
                        estadoService.update(estado);
                        return ResponseEntity.ok(estado);
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }).orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping(path = {"/{id}"})
    public  ResponseEntity<?> delete(@PathVariable Long id){
        var responseMsg = new HashMap();

        return estadoService.getById(id)
                .map(record ->{
                    responseMsg.put("message", "Carga deletada com sucesso");
                    estadoService.delete(record.getId());
                    return  ResponseEntity.ok().body(responseMsg);

                }).orElse(ResponseEntity.notFound().build());
    }
}
