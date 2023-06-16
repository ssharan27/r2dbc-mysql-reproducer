package com.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("test")
@Data
public class Test {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
}
