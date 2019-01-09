package trungnt.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import trungnt.blog.model.Blog;
import trungnt.blog.repository.BlogRepository;
import trungnt.blog.service.BlogService;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}
