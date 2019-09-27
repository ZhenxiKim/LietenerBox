package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Long> {
    //Item findAllBymemId(Long memberSn);

    List<Items> findAllByMemberOrderByCreatedAtDesc(Member member);

    List<Items> findAll();
}
