package org.sparta.post_lv1.service;

import org.sparta.post_lv1.dto.PostRequestDto;
import org.sparta.post_lv1.dto.PostResponseDto;
import org.sparta.post_lv1.entity.Post;
import org.sparta.post_lv1.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PostResponseDto getPost(Long id) {

        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    public List<PostResponseDto> getFindAllPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {

        Post post = findPost(id);

        // 비밀번호 일치 여부 확인
        if (post.getPassword().equals(requestDto.getPassword())) {
            post.update(requestDto);
        } else {
            return new PostResponseDto("비밀번호 틀림니다.");
        }

        return new PostResponseDto(post);
    }

    public PostResponseDto deletePost(Long id, PostRequestDto requestDto) {

        Post post = findPost(id);

        // 비밀번호 일치 여부 확인
        if (post.getPassword().equals(requestDto.getPassword())) {
            postRepository.delete(post);
        } else {
            return new PostResponseDto("비밀번호 틀립니다.");
        }
        return new PostResponseDto("삭제되었습니다.");
    }

    private Post findPost(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("메모가 존재하지 않습니다."));
    }
}
