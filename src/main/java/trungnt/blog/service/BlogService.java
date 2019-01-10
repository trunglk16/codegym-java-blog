package trungnt.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import trungnt.blog.model.Blog;

public interface BlogService {
    Iterable<Blog> findAll();

    Page<Blog> findAll(Pageable pageable);
    void save(Blog blog);

    void remove(Long id);

    Blog findById(Long id);

}
