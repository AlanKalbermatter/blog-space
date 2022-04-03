package com.hardkode.post;

import org.springframework.stereotype.Service;

@Service
public record PostService(PostRepository postRepository) {

    public void sendPost(PostingRequest request) {
        Post post = Post.builder()
                .userName(request.userName())
                .content(request.content())
                .build();

        // todo: check if user exists
        postRepository.save(post);
    }
}
