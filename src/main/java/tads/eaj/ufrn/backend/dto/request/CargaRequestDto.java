package tads.eaj.ufrn.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.model.EnderecoCarga;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.model.Transportadora;

import javax.persistence.Entity;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CargaRequestDto {

    String status;
    String description;
    EnderecoCarga enderecoOrigem;
    EnderecoCarga enderecoDestino;
    Funcionario funcionario;
    Transportadora transportadora;

    public Carga build(){
        return new Carga()
                .setStatus(this.status)
                .setDescription(this.description)
                .setEnderecoOrigem(this.enderecoOrigem)
                .setEnderecoDestino(this.enderecoDestino)
                .setFuncionario(this.funcionario)
                .setTransportadora(this.transportadora);


    }
}
