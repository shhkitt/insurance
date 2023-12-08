package shhkitt.rschir.kr.insurance.models.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shhkitt.rschir.kr.insurance.models.InsuranceType;

import java.math.BigInteger;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private InsuranceType type;
    @Column(name = "name")
    private String name;

    @Column(name = "length")
    private BigInteger length;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private BigInteger price;

}
