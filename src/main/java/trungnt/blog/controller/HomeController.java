package trungnt.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import trungnt.blog.model.Blog;
import trungnt.blog.service.BlogService;

@Controller
public class HomeController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/")
    public ModelAndView listCustomers(Pageable pageable) {

        Page<Blog> blog = blogService.findAll(pageable);
        for (Blog b:blog ) {
            if (b.getDate() == null) {
                b.setDate("Empty");
            }

        }
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

}
