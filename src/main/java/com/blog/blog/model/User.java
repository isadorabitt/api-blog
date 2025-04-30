package com.blog.blog.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "usuario")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150, nullable = false)
    private String name;
    @Column(length = 100, unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
