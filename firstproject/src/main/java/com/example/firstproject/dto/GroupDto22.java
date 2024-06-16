package com.example.firstproject.dto;

import com.example.firstproject.entity.Group22;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class GroupDto22 {
    private Long id;
    private String name;

    public static GroupDto22 createGroupDto(Group22 group) {
        return new GroupDto22(
                group.getId(),
                group.getName()
        );
    }
}
