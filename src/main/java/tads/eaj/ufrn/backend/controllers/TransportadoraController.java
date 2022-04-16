package tads.eaj.ufrn.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tads.eaj.ufrn.backend.dto.request.TransportadoraRequestDTO;
import tads.eaj.ufrn.backend.dto.response.TransportadoraResponseDto;
import tads.eaj.ufrn.backend.model.Transportadora;
import tads.eaj.ufrn.backend.services.TransportadoraService;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transportadora")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "X-Total-Count")
public class TransportadoraController {
    TransportadoraService transportadoraService;

    @Autowired
    public void setTransportadoraService(TransportadoraService transportadoraService) {
        this.transportadoraService = transportadoraService;
    }

    @GetMapping
    public List<Transportadora> getAllTransportadora(){
        return transportadoraService.getAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<TransportadoraResponseDto> getTransportadoraById(@PathVariable Long id){
        Optional<Transportadora> transportadoraFound = transportadoraService.getTransportadoraById(id);
        if(transportadoraFound.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok().body(new TransportadoraResponseDto(transportadoraFound.get()));
        }
    }

    @PostMapping
    public ResponseEntity<TransportadoraResponseDto> insert(@RequestBody TransportadoraRequestDTO transportadoraDto){
        Transportadora transportadora = transportadoraService.insert(transportadoraDto.build());
        return ResponseEntity.created(URI.create("/transportadora/"+transportadora.getId())).body(new TransportadoraResponseDto(transportadora));
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Transportadora transportadora){
        return transportadoraService.getTransportadoraById(id)
                .map( record -> {
                    if(record.getId().equals(transportadora.getId())){
                        transportadoraService.updateTransportadora(transportadora);
                        return ResponseEntity.ok().body(transportadora);
                    }else{
                        return ResponseEntity.notFound().build();
                    }
                }).orElse(ResponseEntity.notFound().build());

    }
    @DeleteMapping(path = {"/{id}"})
    public  ResponseEntity<?> delete(@PathVariable Long id){
        var responseMsg = new HashMap();

        return transportadoraService.getTransportadoraById(id)
                .map(record ->{
                    responseMsg.put("message", "transportadora deletada com sucesso");
                    transportadoraService.deleteTransportadora(record.getId());
                    return  ResponseEntity.ok().body(responseMsg);

                }).orElse(ResponseEntity.notFound().build());
    }

}
