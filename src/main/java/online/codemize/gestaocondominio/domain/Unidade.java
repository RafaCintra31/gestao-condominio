package online.codemize.gestaocondominio.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "unidades")
public class Unidade extends Domain{

    private String tipo;

    private String registro;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

}
