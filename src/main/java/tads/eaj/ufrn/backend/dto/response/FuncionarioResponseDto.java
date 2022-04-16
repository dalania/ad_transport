package tads.eaj.ufrn.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import tads.eaj.ufrn.backend.model.Funcionario;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class FuncionarioResponseDto extends RepresentationModel<FuncionarioResponseDto> {
    String nome;
    String email;
    String telefone;
    String username;
    String password;
    Long id;

    public FuncionarioResponseDto(Funcionario func){
        this.nome = func.getNome();
        this.username = func.getUsername();
        this.password = func.getPassword();
        this.telefone = func.getTelefone();
        this.email = func.getEmail();
        this.id = func.getId();
    }

}
