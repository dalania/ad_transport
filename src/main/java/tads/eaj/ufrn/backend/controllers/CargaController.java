package tads.eaj.ufrn.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.backend.dto.request.CargaRequestDto;
import tads.eaj.ufrn.backend.dto.response.CargaResponseDto;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.services.CargaService;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
@RequestMapping("/carga")
public class CargaController {
    CargaService cargaService;

    @Autowired
    public void setCargaService(CargaService cargaService) {
        this.cargaService = cargaService;
    }

    @GetMapping
    public List<Carga>getAllCarga(){
        return cargaService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CargaResponseDto> getCargaById(@PathVariable Long id){
        Optional<Carga> cargaFound = cargaService.getById(id);
        if(cargaFound == null){
            return ResponseEntity.notFound().build();
        }else{
            CargaResponseDto cargaResponseDto = new CargaResponseDto(cargaFound.get());

            cargaResponseDto.add(linkTo(methodOn(CargaController.class).delete(id)).withRel("Deletar Carga"));
            cargaResponseDto.add(linkTo(methodOn(CargaController.class).delete(id)).withRel("atualizar carga"));
            cargaResponseDto.add(linkTo(methodOn(CargaController.class).getAllCarga()).withRel("Listar carga"));
            return ResponseEntity.ok().body(cargaResponseDto);
        }


    }

    @PostMapping
    public ResponseEntity<CargaResponseDto> insert(@RequestBody CargaRequestDto cargaDto){
        Carga carga = cargaService.insertCarga(cargaDto.build());
        return ResponseEntity.created(URI.create("/carga/"+carga.getId())).body(new CargaResponseDto(carga));
    }

   @DeleteMapping(path = {"/{id}"})
    public  ResponseEntity<?> delete(@PathVariable Long id){
        var responseMsg = new HashMap();

        return cargaService.getById(id)
                .map(record ->{
                    responseMsg.put("message", "Carga deletada com sucesso");
                    cargaService.delete(record.getId());
                    return  ResponseEntity.ok().body(responseMsg);

                }).orElse(ResponseEntity.notFound().build());
   }

   @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Carga carga){
        return cargaService.getById(id)
                .map(record ->{
                    if(record.getId().equals(carga.getId())){
                        cargaService.update(carga);
                        return ResponseEntity.ok().body(carga);
                    }else{
                        return ResponseEntity.notFound().build();
                    }

        }).orElse(ResponseEntity.notFound().build());

   }
}
