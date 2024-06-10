package com.example.firstproject.dto;


import com.example.firstproject.entity.Member;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class MemberForm {
    private Long id;
    private String email;
    private String password;

//    public MemberForm(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

//    @Override
//    public String toString() {
//        return "MemberForm{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }

    public Member toEntity() {
        return new Member(id, email, password);
    }
}
