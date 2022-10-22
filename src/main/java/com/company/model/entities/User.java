package com.company.model.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {
    private final String userName;
    private final String password;
    private final Role role;
}