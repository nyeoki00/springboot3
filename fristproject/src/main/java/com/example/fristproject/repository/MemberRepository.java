package com.example.fristproject.repository;

import com.example.fristproject.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface MemberRepository extends CrudRepository<Member, Long> {
    ArrayList<Member> findAll();
}
