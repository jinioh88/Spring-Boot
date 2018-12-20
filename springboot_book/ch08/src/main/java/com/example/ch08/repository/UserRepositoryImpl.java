package com.example.ch08.repository;

import com.example.ch08.vo.UserVO;
import org.springframework.stereotype.Repository;

@Repository
public abstract class UserRepositoryImpl implements UserRepository {
    @Override
    public Iterable<? extends UserVO> findByUserName(String userName) {
        return null;
    }

    @Override
    public UserVO findOne(String userName) {
        return null;
    }
}
