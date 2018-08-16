package brauls.sandbox.springbootsandbox.repository;

import brauls.sandbox.springbootsandbox.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

