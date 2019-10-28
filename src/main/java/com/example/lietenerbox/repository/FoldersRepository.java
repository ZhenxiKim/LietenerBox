package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoldersRepository extends JpaRepository<Folders,Long> {

    List<Folders> findAllBymembersOrderByItemCreatedAtDesc(Members members);
    Folders findByItemName(String itemName);

}
