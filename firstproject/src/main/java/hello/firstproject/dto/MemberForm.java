package hello.firstproject.dto;

import hello.firstproject.entity.Article;
import hello.firstproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberForm {
    private String email;
    private String password;

    public Member toEntity(){
        return new Member(null, email, password);
    }
}
