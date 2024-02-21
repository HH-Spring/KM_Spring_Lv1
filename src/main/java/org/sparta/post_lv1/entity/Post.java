package org.sparta.post_lv1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.sparta.post_lv1.dto.PostRequestDto;

@Entity
@Getter
@Setter
@Table(name = "post")
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "content", nullable = false, length = 1000)
    private String content;
    @Column(name = "title", nullable = false, length = 20)
    private String title;
    @Column(name = "password", nullable = true)
    private String passeord;

    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.content = requestDto.getContent();
        this.title = requestDto.getTitle();
        this.passeord = requestDto.getPassword();
    }
}
