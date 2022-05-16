package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull(message = "username null")
    @NotBlank(message = "saisir votre username")
    @Size(min = 3, message = "username  must have at least 3 characters")
    @Column(name="username")
    private String username;

    @NotNull(message = "lastName null")
    @NotBlank(message = "saisir votre lastName")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "firstName null")
    @NotBlank(message = "saisir votre firstName")
    @Column(name = "firstName")
    private String firstName;


    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_Number")
    private String phoneNumber;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;

    @JsonIgnoreProperties("userDaos")
    @ManyToOne()
    private Function function;

    @JsonIgnoreProperties("users")
    @ManyToMany
    @JoinTable(name = "profile_group_users",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_profile_group"))
    private List<Profile_group> profile_groups;
}
