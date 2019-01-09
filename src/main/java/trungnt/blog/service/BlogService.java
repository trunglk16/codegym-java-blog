package trungnt.blog.service;

import org.springframework.data.domain.Page;
import trungnt.blog.model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();

    //    Page<Blog>
    void save(Blog blog);

    void remove(Long id);

    Blog findById(Long id);

}
