package tads.eaj.ufrn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.hateoas.Link;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true) //permite que os sets retornem um objeto do tipo funcionario
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    //@NotBlank(message = "Campo nome não pode ser vazio")
    String nome;
    String email;
    //@NotBlank(message = "Campo nome não pode ser vazio")
    String telefone;
    Date deleted = null;
    String username;
    String password;
    Boolean admin = false;


    //sinaliza para o JPA que um funcionario possui varias cargas atraves dessa lista de objeto

//  @OneToMany(mappedBy="funcionario", fetch = FetchType.LAZY, orphanRemoval=true, cascade = CascadeType.ALL)
//  List<Carga> cargas = new ArrayList<>();


}
