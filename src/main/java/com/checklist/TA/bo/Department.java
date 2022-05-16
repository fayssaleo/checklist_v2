package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@javax.persistence.Entity
@Table(name="departments")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("department")
    // @JoinColumn(name = "id_departement")
    private List<Function> functions;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("department")
    // @JoinColumn(name = "id_departement")
    private List<Damage_type> damage_types;
}
