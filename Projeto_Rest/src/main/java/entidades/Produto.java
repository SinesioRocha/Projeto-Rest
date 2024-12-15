package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Produto {
    @Id
    @Column(length = 36)
    private String uuid;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(nullable = false)
    private Short quantidade;


    private LocalDate validade;
}
