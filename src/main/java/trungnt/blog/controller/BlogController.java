package trungnt.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import trungnt.blog.service.BlogService;
import trungnt.blog.model.Blog;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/create-news")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create-news")
    public ModelAndView saveNews(@Validated @ModelAttribute("blog") Blog blog, BindingResult bindingResult) {
        if (!bindingResult.hasFieldErrors()) {
            blogService.save(blog);
            ModelAndView modelAndView = new ModelAndView("/blog/create");
            modelAndView.addObject("blog", new Blog());
            modelAndView.addObject("message", "News created successfully");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/blog/create");
            return modelAndView;
        }
    }

    @GetMapping("/view-blog/{id}")
    public ModelAndView viewNews(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/view");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }


    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/blog/view");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog edited");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public String showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            blogService.remove(blog.getId());
            return "redirect:/";

        } else {
            return "redirect:/error404";
        }
    }

    @GetMapping("/error404")
    public String error404() {
        return "error.404";
    }

}
