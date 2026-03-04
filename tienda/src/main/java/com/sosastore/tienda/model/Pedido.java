package com.sosastore.tienda.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime fecha;

    private Double total;

    private String estado;
    // PENDIENTE, PAGADO, ENVIADO, CANCELADO

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<DetallePedido> detalles = new ArrayList<>();
}