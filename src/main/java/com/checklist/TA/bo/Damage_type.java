package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name="damage_types")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Damage_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull(message = "name null")
    @NotBlank(message = "saisir votre name")
    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("damage_types")
    @ManyToOne
    private Profile_group profile_group;

    @JsonIgnoreProperties("damage_types")
    @ManyToOne
    private Department department;
}
