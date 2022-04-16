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
public class TransportadoraResponseDto {
    String nome;
    List<Estado> estados;
    Long id;

    public TransportadoraResponseDto(Transportadora transpor){
        this.id = transpor.getId();
        this.nome = transpor.getNome();
        this.estados = transpor.getEstados();
    }


}
