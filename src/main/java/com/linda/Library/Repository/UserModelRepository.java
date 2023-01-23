package com.linda.Library.Repository;

import com.linda.Library.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelRepository extends JpaRepository<UserModel, Long> {

    // TODO - Queries

    UserModel findByUsername(String userName);

}
