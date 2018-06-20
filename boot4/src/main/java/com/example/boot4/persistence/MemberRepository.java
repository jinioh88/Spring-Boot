package com.example.boot4.persistence;

import com.example.boot4.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemberRepository extends CrudRepository<Member,String> {
    @Query("select m.uid, count(p) from Member m left outer join Profile p on m.id=p.member where m.uid = ?1 group by m")
    public List<Object[]> getMemberWirthProfileCount(String uid);
}
