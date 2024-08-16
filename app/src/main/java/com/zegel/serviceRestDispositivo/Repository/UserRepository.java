package com.zegel.serviceRestDispositivo.Repository;

import com.zegel.serviceRestDispositivo.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
