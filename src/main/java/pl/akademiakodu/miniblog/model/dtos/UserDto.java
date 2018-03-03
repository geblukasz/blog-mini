package pl.akademiakodu.miniblog.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String userName;
    private String email;
}
