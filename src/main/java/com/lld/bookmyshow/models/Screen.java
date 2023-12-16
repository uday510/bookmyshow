package com.lld.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;
@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    // 1 : M
    // 1 : 1
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection // Mapping table for enums screen_features
    private List<Feature> features;
}

