package com.example.securityex.security;

import com.example.securityex.domain.Member;
import com.example.securityex.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExSecurityUser extends User {
    private static final String ROLE_PREFIX = "ROLE_";
    private Member member;

    public ExSecurityUser(Member member) {
        super(member.getUid(),"{noop}"+member.getUpw(),makeGrantedAutority(member.getRoles()));
        this.member = member;
    }

    private static List<GrantedAuthority> makeGrantedAutority(List<MemberRole> roles) {
        List<GrantedAuthority> list = new ArrayList<>();

        roles.forEach(role->list.add(
                new SimpleGrantedAuthority(ROLE_PREFIX+role.getRoleName())
        ));
        return list;
    }

}
