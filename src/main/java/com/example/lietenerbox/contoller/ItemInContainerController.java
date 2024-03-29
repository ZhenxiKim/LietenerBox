package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ItemsInContainerReqDto;
import com.example.lietenerbox.model.ItemInContainer;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.ItemInContainerRepository;
import com.example.lietenerbox.service.ItemInContainerService;
import com.example.lietenerbox.service.WordInContainerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemsInContainer")
public class ItemInContainerController {

    @Autowired
    private ItemInContainerRepository itemInContainerRepository;

    @Autowired
    private ItemInContainerService itemInContainerService;

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private WordInContainerService wordInContainerService;

    @ApiOperation("클래스 소속 세트 생성")
    @PostMapping()
    public ResponseEntity<?> createItemsInContainer(@RequestBody ItemsInContainerReqDto reqDto){
        ItemInContainer itemInContainer = itemInContainerService.createItemInContainer(reqDto);
        return ResponseEntity.ok(itemInContainer);
    }

    @ApiOperation("클래스 소속 세트 수정")
    @PatchMapping()
    public ResponseEntity<?> changeItemsInContainer(@RequestBody ItemsInContainerReqDto reqDto){
        ItemInContainer itemInContainer = itemInContainerService.changeItemsInContainer(reqDto);
        return ResponseEntity.ok(itemInContainer);
    }

    @ApiOperation("클래스 소속 세트 리스트 출력")
    @GetMapping("/{itemsInContainerSn}")
    public ResponseEntity<?> getItemsInContainerList(@PathVariable Long itemsInContainerSn){
        List<ItemInContainer> itemInContainerList = itemInContainerService.getItemInContainerList(itemsInContainerSn);
        return ResponseEntity.ok(itemInContainerList);
    }












//    //item 생성
//    @PostMapping("/{containerId}/createItem")
//    public String createItemInContainer(@PathVariable Long containerId, String itemName, HttpSession session, String wordName, String wordMean) {
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
//
//        //아이템이 속한 그룹정보 가져오기
//        Container container = containerRepository.findByContainerId(containerId);
//
//        //아이템 생성 후 생성된 아이템 객체 가져오기
//        itemInContainerService.createItemInContainer(containerId, itemName, sessionMembers, container);
//        ItemInContainer itemInContainer = itemInContainerService.getItemInContainer(itemName);
//        //아이템 객체와 함께 단어 생성하기
//        wordInContainerService.createWordInContainer(itemInContainer, wordName, wordMean);
//        return "redirect:/itemsInContainer";
//    }
//
//    //그룹에 속해진 item 리스트 출력
//    @GetMapping("/{containerId}")
//    public String itemList(@PathVariable Long containerId, Model model) {
//        //그룹에 속한 아이템을 가져오기위해 groupId로 그룹객체 정보 가져오기
//        Container container = containerRepository.findById(containerId)
//                .orElseThrow(DataNotFoundException::new);
//
//        model.addAttribute("itemInContainer", itemInContainerRepository.findAllByContainer(container));
//        return "/itemInContainer/itemList";
//        // .orElseThrow(() -> new IllegalArgumentException());
//
//    }
//
//    //item 생성 form
//    @GetMapping("/{containerId}/itemForm")
//    private String itemForm(@PathVariable Long containerId, HttpSession session, Model model) {
//        //그룹 생성 시 로그인 유저 확인
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//
//        //현재 로그인 정보 가져오기
//        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
//        Long loginmembers = sessionMembers.getmembersSn();
//
//        model.addAttribute("containers", containerRepository.findById(containerId));
//        //로그인 회원일 경우 아이템 생성 페이지로 이동
//        return "/itemInContainer/itemForm";
//    }
//
//
//    //아이템 생성 후 전체 리스트 페이지로 이동
//    @GetMapping("")
//    public String itemList() {
//        //단어가 속한
//
//        return "/itemInContainer/itemList";
//    }
//
//    //아이템 생성 후 전체 리스트 페이지로 이동
//    @GetMapping("/{containerId}/itemList")
//    public String itemContainerIdList(@PathVariable Long containerId, HttpSession session, Model model) {
//        //단어가 속한
//        Container container = containerRepository.findByContainerId(containerId);
//        model.addAttribute("itemInContainer", itemInContainerRepository.findByContainer(container));
//        return "/itemInContainer/itemList";
//    }
}
