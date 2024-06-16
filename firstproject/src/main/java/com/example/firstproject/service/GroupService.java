package com.example.firstproject.service;

import com.example.firstproject.dto.GroupDto22;
import com.example.firstproject.repository.Group22Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService {
    @Autowired
    private Group22Repository groupRepository;


    public GroupDto22 show(Long id) {
        return groupRepository.findById(id).map(GroupDto22:: createGroupDto).orElse(null);
    }
}
