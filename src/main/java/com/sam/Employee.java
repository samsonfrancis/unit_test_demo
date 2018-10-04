package com.sam;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Getter@Setter
    private Integer id;
    @Getter@Setter
    private String firstName;
    @Getter@Setter
    private String lastName;
    @Getter@Setter
    private Integer experience;
}
