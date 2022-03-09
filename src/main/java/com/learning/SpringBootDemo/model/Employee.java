package com.learning.SpringBootDemo.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private int age;


}
