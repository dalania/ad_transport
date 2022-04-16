package tads.eaj.ufrn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Carga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String status;
    String description;
    Date dataCadastro = new Date();
    Date deleted = null;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idEnderecoOrigem")
    EnderecoCarga enderecoOrigem;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idEnderecoDestino")
    EnderecoCarga enderecoDestino;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "funcionario_id")
    Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "transportadora_id")
    Transportadora transportadora;
}