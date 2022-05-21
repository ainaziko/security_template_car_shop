package com.example.lesson.Enums;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
    ROLE_ADMIN("ADMIN",1),//1
    ROLE_SELLER("WAITER",2),//2
    ROLE_CLIENT("CLIENT",3);

    public final String name;

    private int getId() {
        return id;
    }

    private int id;

    ERole(String name, int id){
        this.name = name;
        this.id = id;
    }

    public static ERole getRole(int id ){
        for(ERole role : ERole.values())
            if(role.getId() == id)
                return role;
        return null;
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
