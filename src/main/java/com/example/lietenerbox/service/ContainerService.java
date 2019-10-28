package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.contoller.requestDto.ContainerRequestDto;
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

    public void createContainer(String ContainerName, String ContainerContents, Members sessionMembers) {
        containerRepository.save(new Container(ContainerName, ContainerContents, sessionMembers));
    }

    //api용 createContainers메서드
    public void createContainers(ContainerRequestDto requestDto, Members sessionMembers) {
        Container container = new Container(requestDto, sessionMembers);
        containerRepository.save(container);
    }

    //api read
    public List<Container> ContainersList(Members members) {
        return containerRepository.findBymembersOrderByCreatedAtDesc(members);
    }

}
