package com.linda.Library.Repository;

import com.linda.Library.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
