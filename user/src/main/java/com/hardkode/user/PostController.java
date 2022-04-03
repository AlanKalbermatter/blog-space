package com.hardkode.post;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/posts")
@AllArgsConstructor
public class PostController {

    private PostService postService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            value = "/{id}]")
    public void getAllPostForAnUser(@PathVariable Long id) {
    }


}
