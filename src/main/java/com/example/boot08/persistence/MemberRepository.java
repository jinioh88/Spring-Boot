package com.example.boot08.persistence;

import com.example.boot08.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member,String> {

}
