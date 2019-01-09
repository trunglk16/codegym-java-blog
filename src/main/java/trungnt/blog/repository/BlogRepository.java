package trungnt.blog.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import trungnt.blog.model.Blog;

public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {

}
