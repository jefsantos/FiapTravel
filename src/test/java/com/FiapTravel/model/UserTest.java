package com.FiapTravel.model;

import org.junit.jupiter.api.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import com.FiapTravel.model.enums.UserRole;


import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testAllArgsConstructor() {
        String id = "1";
        String login = "username";
        String password = "password";
        UserRole role = UserRole.ADMIN;

        User user = new User(id, login, password, role);

        assertEquals(id, user.getId());
        assertEquals(login, user.getLogin());
        assertEquals(password, user.getPassword());
        assertEquals(role, user.getRole());
    }

    @Test
    void testGetAuthorities() {
        User adminUser = new User("1", "admin", "password", UserRole.ADMIN);
        User regularUser = new User("2", "user", "password", UserRole.USER);

        Collection<? extends SimpleGrantedAuthority> adminAuthorities = (Collection<? extends SimpleGrantedAuthority>) adminUser.getAuthorities();
        Collection<? extends SimpleGrantedAuthority> regularAuthorities = (Collection<? extends SimpleGrantedAuthority>) regularUser.getAuthorities();

        assertEquals(2, adminAuthorities.size());
        assertTrue(adminAuthorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
        assertTrue(adminAuthorities.contains(new SimpleGrantedAuthority("ROLE_USER")));

        assertEquals(1, regularAuthorities.size());
        assertTrue(regularAuthorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
    }

    @Test
    void testGetUsername() {
        String username = "username";
        User user = new User("1", username, "password", UserRole.ADMIN);
        assertEquals(username, user.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        User user = new User("1", "username", "password", UserRole.ADMIN);
        assertTrue(user.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        User user = new User("1", "username", "password", UserRole.ADMIN);
        assertTrue(user.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        User user = new User("1", "username", "password", UserRole.ADMIN);
        assertTrue(user.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        User user = new User("1", "username", "password", UserRole.ADMIN);
        assertTrue(user.isEnabled());
    }
}