package tads.eaj.ufrn.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Accessors(chain = true)

public class Transportadora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    Date deleted = null;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "transportadora_estado",
            joinColumns = @JoinColumn(name = "transportadora_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "estado_id")
    )
    List<Estado> estados;
}
