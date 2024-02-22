package org.sparta.post_lv1.service;

import org.sparta.post_lv1.dto.PostRequestDto;
import org.sparta.post_lv1.dto.PostResponseDto;
import org.sparta.post_lv1.entity.Post;
import org.sparta.post_lv1.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {

        Post post = new Post(requestDto);

        Post savePost = postRepository.save(post);

        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }
}
