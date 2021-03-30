package org.example.entities;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "photo_id")
    private Photo photos;

    private String text;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "likes",
            joinColumns = {@JoinColumn(name = "user1_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user2_id", referencedColumnName = "id")}
    )
    private Set<User> likes;

    private String date;
}
