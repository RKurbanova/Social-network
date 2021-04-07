package com.example.socialnetwork.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Photo> photos;

    private String text;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "likes",
            joinColumns = {@JoinColumn(name = "user1_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user2_id", referencedColumnName = "id")}
    )
    private Set<User> likes;

    private String date;

    @ManyToOne
    @JoinColumn(name="author_id", nullable=false)
    private User author;
}