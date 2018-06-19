package com.example.boot4.persistence;

import com.example.boot4.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String> {
}
