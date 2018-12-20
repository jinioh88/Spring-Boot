package com.example.ch08.repository;

import com.example.ch08.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserVO, Long> {
    public Iterable<? extends UserVO> findByUserName(String userName);
    public UserVO findOne(String userName);
}
