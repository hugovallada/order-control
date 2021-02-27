package com.github.hugovallada.orderscontrol.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

}
