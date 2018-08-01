package com.example.securityex;

import com.example.securityex.domain.Member;
import com.example.securityex.domain.MemberRole;
import com.example.securityex.persistence.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTest {
    @Autowired
    private MemberRepository repository;

    @Test
    public void testInsert() {
        for(int i=0; i<=10;i++) {
            Member member = new Member();
            member.setUid("user"+i);
            member.setUpw("pw"+i);
            member.setUname("홍길동"+i);

            MemberRole role = new MemberRole();
            if(i<7) {
                role.setRoleName("BASIC");
            }else if(i<=9){
                role.setRoleName("MANAGER");
            }else {
                role.setRoleName("ADMIN");
            }
            member.setRoles(Arrays.asList(role));
            repository.save(member);
        }
    }

    @Test
    public void testRead() {
        Optional<Member> result = repository.findById("user8");
        result.ifPresent(member->log.info("member"+member));
    }
}
