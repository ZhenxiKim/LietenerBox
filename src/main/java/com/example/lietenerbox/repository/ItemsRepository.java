package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Long> {
    //Item findAllBymemId(Long memberSn);

    List<Items> findAllByMember(Long memberSn);
}
