package com.adobinbackend.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="PRODUIT")
@Getter
@Setter
@NoArgsConstructor
public class AppUser {
    @Id
    @SequenceGenerator(allocationSize = 1, name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(nullable = false,
            unique = true,length = 60)
    private String username;

    @Column(nullable = false, length = 50,
            unique = true)
    private String email;

    private Sexe sexe;
    private String passWord;
    private String photo;
    private boolean enabled=false;

    private Status_value status;
}
