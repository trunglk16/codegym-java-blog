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
    @Size(max = 250, message = "Title uoc qua 250 ky tu")
    private String tittle;

    @NotEmpty(message = "You must insert content")
    private String content;

    @Size(min = 8, max = 8, message = "yyyy/mm/dd")
    private String date;

    public Blog() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Blog(@NotEmpty(message = "You must insert title") @Size(max = 250, message = "Title uoc qua 250 ky tu") String tittle, @NotEmpty(message = "You must insert content") String content, @Size(min = 8, max = 8, message = "yyyy/mm/dd") String date) {
        this.tittle = tittle;
        this.content = content;
        this.date = date;
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
