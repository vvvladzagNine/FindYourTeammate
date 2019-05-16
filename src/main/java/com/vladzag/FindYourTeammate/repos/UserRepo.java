package com.vladzag.FindYourTeammate.repos;

import com.vladzag.FindYourTeammate.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);

    List<User> findAllByOldGreaterThanAndOldLessThan(Integer from, Integer to);
    List<User> findAllByOldGreaterThan(Integer from);
    List<User> findAllByOldLessThan(Integer to);




}
