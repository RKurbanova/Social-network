package org.example.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "photos")
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String photo;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "likes",
            joinColumns = {@JoinColumn(name = "user1_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user2_id", referencedColumnName = "id")}
    )
    private Set<User> likes;

    private String date;
}
