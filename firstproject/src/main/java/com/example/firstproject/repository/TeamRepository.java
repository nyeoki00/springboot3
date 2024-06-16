package com.example.firstproject.repository;

import com.example.firstproject.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query(value =
            " SELECT id, group_id, name, image_url " +
            " FROM team " +
            " WHERE group_id = :groupId ",
            nativeQuery = true)
    public List<Team> teams(@Param("groupId") Long groupId);
}
