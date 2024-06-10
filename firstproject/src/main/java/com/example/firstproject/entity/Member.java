package com.example.firstproject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

//    public Member(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
//
//    public Member() {
//
//    }
//
//    @Override
//    public String toString() {
//        return "Member{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
