package shhkitt.rschir.kr.insurance.models.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shhkitt.rschir.kr.insurance.models.InsurerType;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "start")
    private LocalDate start;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insured_id")
    private Insured insured;

    @Column(name = "insurer_type")
    private InsurerType insurerType;

    @Column(name = "insurer")
    private String insurer;

}
