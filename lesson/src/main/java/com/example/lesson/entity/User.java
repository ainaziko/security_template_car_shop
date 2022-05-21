package com.example.lesson.entity;

import com.example.lesson.Enums.ERole;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="first_name")
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(name ="b_date")
    private Date bDate;

    @Column(name ="phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private ERole role;

    private long bonus;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "is_completed")
    private boolean isCompleted;

    private Long rating;

    @Column(name = "firebase_token")
    private String firebaseToken;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }



    @Override
    public String getPassword() {
        return getActivationCode();
    }

    @Override
    public String getUsername() {
        return getPhoneNumber();
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
}
