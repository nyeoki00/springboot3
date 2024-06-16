package com.example.firstproject.service;

import com.example.firstproject.dto.TeamDto;
import com.example.firstproject.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;


    public List<TeamDto> teams(Long groupId) {
        return teamRepository.teams(groupId)
                .stream().map(TeamDto :: createTeamDTO)
                .collect(Collectors.toList());
    }
}
