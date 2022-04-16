package tads.eaj.ufrn.backend.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.backend.model.Funcionario;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequestDto {
    String nome;
    String email;
    String telefone;
    String username;
    String password;


    public Funcionario build(){ //instância de funcionario
        
        return new Funcionario()
                .setNome(this.nome)
                . setTelefone(this.telefone)
                .setUsername(this.username)
                .setPassword(this.password)
                .setUsername(this.username)
                .setEmail(this.email);
    }
}
