package co.com.pragma.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity(name = "registro")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "vista_identificador")
    private String viewIdentifier;
    @Column(name = "usuario_id")
    private String userId;
    @Column(name = "ip")
    private String ip;
}
