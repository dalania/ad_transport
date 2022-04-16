package tads.eaj.ufrn.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.backend.model.Estado;
import tads.eaj.ufrn.backend.model.Transportadora;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstadoResponseDto {
    String nome;
    Long id;


    public EstadoResponseDto(Estado estado){
        this.nome = estado.getNome();
        this.id = estado.getId();
    }

}
