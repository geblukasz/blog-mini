package pl.akademiakodu.miniblog.model.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    //@Column(name = "contentString")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date added = new Date();

    @OneToMany(mappedBy = "post", cascade = CascadeType.MERGE)
    //@JoinColumn(name = "postId")
    List<PostComment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "mapPostTag",
        joinColumns = {@JoinColumn(name="postId")},
        inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private Set<Tag> tags = new HashSet<>();

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }



    public void addComment(PostComment postComment){
        comments.add(postComment);
        postComment.setPost(this);
    }

    public void removeComment(PostComment postComment){
        comments.remove(postComment);
        postComment.setPost(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", added=" + added +
                '}';
    }

    public Post() {
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public List<PostComment> getComments() {
        return comments;
    }

    public void setComments(List<PostComment> comments) {
        this.comments = comments;
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

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }
}
