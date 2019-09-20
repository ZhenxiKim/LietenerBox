package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long> {
    //Item findAllBymemId(Long memberSn);

    List<Item> findAllByMember(Long memberSn);
}
