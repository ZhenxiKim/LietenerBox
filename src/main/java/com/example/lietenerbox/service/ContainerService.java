package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.ContainerChangeReqDto;
import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.contoller.requestDto.ContainerRequestDto;
import com.example.lietenerbox.model.dto.response.ContainerResponseDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContainerService {

    private final ContainerRepository containerRepository;
    private final MembersRepository membersRepository;

    public ContainerService(ContainerRepository containerRepository, MembersRepository membersRepository) {
        this.containerRepository = containerRepository;
        this.membersRepository = membersRepository;
    }

    public ContainerResponseDto createContainers(@NotNull ContainerRequestDto reqDto) {
        Long memSn = reqDto.getMemSn();
        String containerName = reqDto.getContainerName();
        String containerContents = reqDto.getContainerContents();

        Members members = membersRepository.findByMembersSn(memSn);


        Container container = containerRepository.save(new Container(members, containerName, containerContents));
        //responseBody
        ContainerResponseDto resDto = new ContainerResponseDto();

        resDto.setMemSn(memSn);
        resDto.setContainerName(container.getContainerName());
        resDto.setContainerContents(container.getContainerContents());
        resDto.setContainerStatus(true);
        resDto.setCreatedAt(LocalDateTime.now());
        return resDto;
    }


    //api read
    public List<Container> ContainersList(Members members) {
        return containerRepository.findBymembersOrderByCreatedAtDesc(members);
    }


    public Container changeContainers(ContainerChangeReqDto reqDto) {

        Long memSn = reqDto.getMemSn();
        Long containerSn = reqDto.getContainerSn();
        Optional<Container> container = containerRepository.findById(containerSn);

        String containerName = reqDto.getContainerName();
        String containerContents = reqDto.getContainerContents();

        Members members = membersRepository.findByMembersSn(memSn);
        Members creator = container.get().getMembers();

        //컨테이너 생성자와 현재로그인한 유저 확인 필요
        if(!creator.equals(members)){
            //TODO 오류발생 처리하기
        }

        Container changeContainer = containerRepository.save(new Container(members, containerName, containerContents));
        return changeContainer;
    }

    public List<Container> getContainerList(Long memSn) {
        Members members = membersRepository.findByMembersSn(memSn);
        List<Container> containerList = containerRepository.findAllByMembersOrderByCreatedAtDesc(members);
        return containerList;
    }
}
