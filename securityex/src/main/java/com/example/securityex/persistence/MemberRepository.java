package com.example.securityex.persistence;

import com.example.securityex.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String> {

}
