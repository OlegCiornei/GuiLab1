package com.company.model.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Hotel {
    private Long id;
    private final String name;
    private final Double rating;
}
