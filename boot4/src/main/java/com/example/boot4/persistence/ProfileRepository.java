package com.example.boot4.persistence;

import com.example.boot4.domain.Member;
import com.example.boot4.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile,String> {
}
