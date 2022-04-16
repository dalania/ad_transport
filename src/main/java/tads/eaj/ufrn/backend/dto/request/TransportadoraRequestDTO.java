package tads.eaj.ufrn.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.backend.model.Estado;
import tads.eaj.ufrn.backend.model.Transportadora;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransportadoraRequestDTO {
    String nome;
    List<Estado> estados;


    public Transportadora build(){
        return new Transportadora()
                .setNome(this.nome)
                .setEstados(this.estados);

    }

}
