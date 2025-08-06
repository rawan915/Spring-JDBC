package com.example.spring_data_jdbc.model;

import lombok.*;

@Setter
@Getter
@ToString
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

}
