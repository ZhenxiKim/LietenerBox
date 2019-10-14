package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.ContainerRequestDto;
import com.example.lietenerbox.repository.ContainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ContainerService {

    private final ContainerRepository containerRepository;

    public ContainerService(ContainerRepository containerRepository) {
        this.containerRepository = containerRepository;
    }

    public void createContainer(String ContainerName, String ContainerContents, Person sessionPerson) {
        containerRepository.save(new Container(ContainerName, ContainerContents, sessionPerson));
    }

    //api용 createContainers메서드
    public void createContainers(ContainerRequestDto requestDto, Person sessionPerson) {
        Container container = new Container(requestDto, sessionPerson);
        containerRepository.save(container);
    }

    //api read
    public List<Container> ContainersList(Person person) {
        return containerRepository.findByPersonOrderByCreatedAtDesc(person);
    }

}
