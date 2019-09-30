package com.example.lietenerbox.repository;

import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items,Long> {

    List<Items> findAllByPersonOrderByItemCreatedAtDesc(Person person);

}
