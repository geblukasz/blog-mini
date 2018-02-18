package pl.akademiakodu.miniblog.model.dtos;

import pl.akademiakodu.miniblog.model.entities.Post;

import java.util.Set;

public class TagDto {

    private Long id;
    private String TagName;
    private Set<PostDto> posts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }

    public Set<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(Set<PostDto> posts) {
        this.posts = posts;
    }
}
