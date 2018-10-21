package pl.akademiakodu.miniblog.model.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Long idOfUser;
    private Date created;

/*
    @JsonManagedReference
    private Set<TagDto> tags;
*/


}
