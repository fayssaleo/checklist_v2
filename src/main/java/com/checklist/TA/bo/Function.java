package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@javax.persistence.Entity
@Table(name="functions")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("function")
    @OneToMany(mappedBy = "function",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<User> user;

    @JsonIgnoreProperties("functions")
    @ManyToOne
    private Department department;
}
