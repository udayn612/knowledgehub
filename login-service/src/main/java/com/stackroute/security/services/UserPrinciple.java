package com.stackroute.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stackroute.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Objects;
//class implements user details which is a interface of security module
public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;



    private String username;


    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;
    public UserPrinciple(
            String username, String password
    ) {

        this.username = username;

        this.password = password;

    }
    public static UserPrinciple build(User user) {


        return new UserPrinciple(

                user.getUsername(),

                user.getPassword()

        );
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }

}
