package com.example.security;

import com.example.security.domain.Member;
import com.example.security.domain.MemberRole;
import com.example.security.persistence.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTest {
    @Autowired
    MemberRepository repository;

    @Test
    public void testInsert() {
        for(int i=0;i<101;i++) {
            Member member = new Member();
            member.setUid("user"+i);
            member.setUpw("1111");
            member.setUname("사용자"+i);

            MemberRole role = new MemberRole();
            if(i<=80) {
                role.setRoleName("BASIC");
            } else if(i<=90) {
                role.setRoleName("MANAGER");
            } else {
                role.setRoleName("ADMIN");
            }
            member.setRoles(Arrays.asList(role));

            repository.save(member);
        }
    }

    @Test
    public void testRead() {
        Optional<Member> result = repository.findById("user88");
        result.ifPresent(member->log.info("member"+member));
    }
}
