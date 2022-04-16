package tads.eaj.ufrn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnderecoCarga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String bairro;
    String municipio;
    String estado;
    Integer numero;
    String logradouro;
}
