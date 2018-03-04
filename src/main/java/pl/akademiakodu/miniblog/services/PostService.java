package pl.akademiakodu.miniblog.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.miniblog.model.dtos.PostDto;
import pl.akademiakodu.miniblog.model.entities.Post;
import pl.akademiakodu.miniblog.model.entities.User;
import pl.akademiakodu.miniblog.model.repositories.PostRepository;
import pl.akademiakodu.miniblog.model.repositories.UserRepository;

import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    UserRepository userRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public PostDto createPost(String title, String content, Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        Post post = new Post(title, content);
        optionalUser.ifPresent(u -> post.setUser(u));

        postRepository.save(post);

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Post.class, PostDto.class)
                .addMapping(pst -> pst.getUser().getId(), PostDto::setIdOfUser)
                .addMapping(p -> p.getAudit().getAdded(), PostDto::setCreated);
        return modelMapper.map(post, PostDto.class);

    }
}
