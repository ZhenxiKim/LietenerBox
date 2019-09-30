package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.ItemInGroup;
import com.example.lietenerbox.model.WordInGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordInGroupRepository extends JpaRepository<WordInGroup,Long> {
    WordInGroup findByItemInGroup(ItemInGroup itemInGroup);
}
