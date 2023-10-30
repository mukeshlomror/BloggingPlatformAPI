package com.Mukesh.BloggingPlatformAPI.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    @NotEmpty
    @Column(nullable = false, length = 150)
    @Size(min = 10, message = "post title must have minimum 10 characters")
    private String postTitle;

    @NotEmpty
    @Size(min = 100, message = "post must have content of minimum 100 characters")
    private String postContent;

    @NotEmpty
    private String postImage;

    private Date postCreationTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference(value = "category_post")
    @JoinColumn(name = "category_id")
    private Category category;


    @ManyToOne
    @JsonBackReference(value = "user_post")
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

}
