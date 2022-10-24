package ru.netology.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.service.PostService;

import java.io.IOException;
import java.util.List;

@RestController  //используем вместо @ResponseBody, ответ метода автоматически трансформировался
                // в тело ответа и спринг не пытался отдать "Вьюху"

@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    public List<Post> all() {
        return  service.all();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id) throws IOException{
        return service.getById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        return service.save(post);

    }

    @DeleteMapping("/{id}")
    public void removeById(@PathVariable long id) throws IOException{
        service.removeById(id);
    }
}
