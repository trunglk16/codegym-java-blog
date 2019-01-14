package trungnt.blog.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import trungnt.blog.model.Counter;

@Controller
@SessionAttributes("mycounter")

public class CounterController {

    @ModelAttribute("mycounter")
    public Counter setUpCounter() {
        return new Counter();
    }

}
