package pl.akademiakodu.miniblog.model.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class PostDto {
    private Long id;
    private String title;
    private String content;

    @JsonManagedReference
    private Set<TagDto> tags;

    public Set<TagDto> getTags() {
        return tags;
    }

    public void setTags(Set<TagDto> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
