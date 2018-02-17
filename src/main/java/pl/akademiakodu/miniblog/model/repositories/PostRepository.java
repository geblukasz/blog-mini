package pl.akademiakodu.miniblog.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.miniblog.model.entities.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
}
