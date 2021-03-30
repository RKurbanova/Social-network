package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String role;

    private String gender;

    private String birthday;

    private String currentCity;

    private String Relationship;

    private String statusMessage;

    private String about;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Photo> photos;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "friends",
            joinColumns = {@JoinColumn(name = "user1_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user2_id", referencedColumnName = "id")}
    )
    private Set<User> friends;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Post> posts;

    private String status;

    private String profileVisibilityType;

    private String postVisibilityType;

    private String creationDate;

    private String password;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id")
    private Photo avatar;
}
