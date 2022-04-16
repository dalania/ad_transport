package tads.eaj.ufrn.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import tads.eaj.ufrn.backend.model.Carga;
import tads.eaj.ufrn.backend.model.EnderecoCarga;
import tads.eaj.ufrn.backend.model.Funcionario;
import tads.eaj.ufrn.backend.model.Transportadora;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargaResponseDto  extends RepresentationModel<CargaResponseDto> {
    String status;
    String description;
    Date dataCadastro;
    EnderecoCarga enderecoDestino;
    EnderecoCarga enderecoOrigem;
    Funcionario funcionario;
    Transportadora transportadora;
    Long id;

    public CargaResponseDto(Carga carga){
        this.status = carga.getStatus();
        this.description = carga.getDescription();
        this.dataCadastro = carga.getDataCadastro();
        this.enderecoOrigem = carga.getEnderecoOrigem();
        this.enderecoDestino = carga.getEnderecoDestino();
        this.funcionario = carga.getFuncionario();
        this.transportadora = carga.getTransportadora();
        this.id = carga.getId();

    }

}
