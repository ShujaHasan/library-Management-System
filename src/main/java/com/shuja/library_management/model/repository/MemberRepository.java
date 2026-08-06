package com.shuja.library_management.model.repository;

import com.shuja.library_management.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
