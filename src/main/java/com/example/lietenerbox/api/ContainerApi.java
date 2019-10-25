package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.ContainerRequestDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.ContainerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ContainerApi {
    //내가 생성한 그룹 리스트 Api

    private final PersonRepository personRepository;
    private final ContainerRepository containerRepository;
    private final ContainerService containerService;


    public ContainerApi(PersonRepository personRepository,
                        ContainerRepository containerRepository,
                        ContainerService containerService) {
        this.personRepository = personRepository;
        this.containerRepository = containerRepository;
        this.containerService = containerService;
    }

    @ApiOperation("클래스 생성")
    @PostMapping("/containers/{personSn}")
    public HttpStatus createGroups(@RequestBody ContainerRequestDto requestDto, HttpSession session, @PathVariable Long personSn) {
        //현재 로그인 정보
        Person loginPerson = (Person) session.getAttribute("person");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
        if (loginPerson.getPersonSn() != personSn) {
            return HttpStatus.BAD_REQUEST;
        }

        containerService.createContainers(requestDto, loginPerson);
        return HttpStatus.OK;
    }


    @ApiOperation("회원생성 클래스 리스트")
    @GetMapping("/containers/{personSn}")
    public ResponseEntity<?> groupsAll(@PathVariable Long personSn, HttpSession httpSession) {
        //1. 로그인한 회원 정보 가져오기
        //2. 로그인한 회원에대한 그룹리스트 가져오기

        //url에 담긴 회원sn로 기존 저정된 회원 정보 찾아오기
        Person savedPerson = personRepository.findById(personSn).orElseThrow(DataNotFoundException::new);

        List<Container> containerList = containerService.ContainersList(savedPerson);

        return ResponseEntity.ok(containerList);
    }

    //회원의 정보를 전제로 가져와야하나?
//    @PutMapping("/container/{groupId}")
//    public HttpStatus updateGroup(@PathVariable Long GroupId,@PathVariable Long PersonSn,HttpSession httpSession,@RequestBody ContainerRequestDto requestDto){
//        //현재 로그인 정보
//        Person loginPerson = (Person) httpSession.getAttribute("Person");
//
//        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
//        if (loginPerson.getPersonSn() != PersonSn) {
//            return HttpStatus.BAD_REQUEST;
//        }
//        groupsService.updateGroup(requestDto, GroupId);
//        return HttpStatus.OK;
//    }

}
