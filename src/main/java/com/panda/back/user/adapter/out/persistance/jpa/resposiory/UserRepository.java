package com.panda.back.user.adapter.out.persistance.jpa.resposiory;

import com.panda.back.user.adapter.out.persistance.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
