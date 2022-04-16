package tads.eaj.ufrn.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.backend.model.Estado;
import tads.eaj.ufrn.backend.model.Transportadora;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EstadoRequestDTO {
    String nome;



    public Estado build(){
        return new Estado()
                .setNome(this.nome);

    }
}
