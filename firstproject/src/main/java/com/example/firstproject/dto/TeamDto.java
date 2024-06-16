package com.example.firstproject.dto;

import com.example.firstproject.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TeamDto {
    private Long id;
    private Long groupId;
    private String name;
    private String imageUrl;

    public static TeamDto createTeamDTO(Team team) {
        return new TeamDto(
                team.getId(),
                team.getGroup().getId(),
                team.getName(),
                team.getImageUrl()
        );
    }
}
