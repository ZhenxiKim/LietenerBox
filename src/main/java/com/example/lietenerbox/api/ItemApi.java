package com.example.lietenerbox.api;

import com.example.lietenerbox.api.exception.DataNotFoundException;
import com.example.lietenerbox.model.Items;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.dto.request.ItemsRequestDto;
import com.example.lietenerbox.repository.ItemsRepository;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.service.ItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemApi {

    private final ItemsRepository itemsRepository;
    private final ItemsService itemsService;
    private final PersonRepository personRepository;

    public ItemApi(ItemsRepository itemsRepository,
                   ItemsService itemsService,
                   PersonRepository personRepository) {
        this.itemsRepository = itemsRepository;
        this.itemsService = itemsService;
        this.personRepository = personRepository;
    }

    @PostMapping("/items/{PersonSn}/create")
    public HttpStatus createItems(@RequestBody ItemsRequestDto itemsRequestDto, HttpSession session, @PathVariable Long PersonSn) {
        //현재 로그인 정보
        Person loginPerson = (Person) session.getAttribute("Person");

        //로그인한 회원의 정보와 url로 넘어오는 회원의 정보가 같은지 비교
        if (loginPerson.getPersonSn() != PersonSn) {
            return HttpStatus.BAD_REQUEST;
        }
        itemsService.createItems(itemsRequestDto, loginPerson);
        return HttpStatus.OK;
    }

    @GetMapping("/items/{PersonSn}")
    public ResponseEntity<?> itemsAll(@PathVariable Long PersonSn, HttpSession httpSession) {
        //현재 로그인 정보
        Person loginPerson = (Person) httpSession.getAttribute("Person");
        if(loginPerson == null){

        }
        //로그인한 회원정보를 가지고 저장된 회원 정보 가져오기
        Person savedPerson = personRepository.findById(PersonSn).orElseThrow(DataNotFoundException::new);

        List<Items> itemsList = itemsService.itemsList(savedPerson);

        return ResponseEntity.ok(itemsList);

    }

}
