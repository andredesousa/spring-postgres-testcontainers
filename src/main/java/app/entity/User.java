package app.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "app.entities.User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    @NotNull
    @Column(name = "username", nullable = false)
    public String username;

    @NotNull
    @Column(name = "email", nullable = false)
    public String email;
}
