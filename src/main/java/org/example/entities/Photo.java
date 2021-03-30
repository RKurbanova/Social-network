package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "photos")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(mappedBy = "avatar")
    private User avatar_user;
}
