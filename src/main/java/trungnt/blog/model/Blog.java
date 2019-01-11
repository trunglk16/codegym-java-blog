package trungnt.blog.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "blog")
public class Blog {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotEmpty(message = "You must insert title")
    @Size(max = 250,message = "Title uoc qua 250 ky tu")
    private String tittle;

    @NotEmpty(message = "You must insert content")
    private String content;


    public Blog() {
    }

    public Blog(String tittle, String content) {
        this.tittle = tittle;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}
