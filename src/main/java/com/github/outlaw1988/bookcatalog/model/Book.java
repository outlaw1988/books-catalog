package com.github.outlaw1988.bookcatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    @NotBlank
    @Size(min = 2, max = 140)
    private String title;

    @Column
    @NotNull
    @NotBlank
    private String isbn;

    @Column(length = 2000)
    @NotNull
    private String description;

    @Column
    @NotNull
    @NotBlank
    private String year;

}
