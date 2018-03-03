package pl.akademiakodu.miniblog.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akademiakodu.miniblog.model.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
}
