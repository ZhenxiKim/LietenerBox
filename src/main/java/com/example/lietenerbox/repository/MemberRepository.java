package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository  extends JpaRepository<Member,Long> {
}
