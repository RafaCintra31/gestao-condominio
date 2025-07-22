package online.codemize.gestaocondominio.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario extends Domain{

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String senha;

    private Boolean admin;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Unidade> unidades;

}
