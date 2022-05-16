package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="profile_groups")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Profile_group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("profile_groups")
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "profile_group_users",joinColumns = @JoinColumn(name = "id_profile_group"),inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    @JsonIgnoreProperties("profile_group")
    @OneToMany(mappedBy = "profile_group",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage_type> damage_types;

}
