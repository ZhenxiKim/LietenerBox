package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ChangeNameRequestDto;
import com.example.lietenerbox.contoller.requestDto.FoldersRequestDto;
import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.repository.WordsRepository;
import com.example.lietenerbox.service.FoldersService;
import com.example.lietenerbox.service.WordsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/folders",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class FoldersController {


    @Autowired
    private MembersRepository membersRepository;
    @Autowired
    private FoldersService foldersService;

    @Autowired
    private WordsRepository wordsRepository;
    @Autowired
    private WordsService wordsService;

    @ApiOperation("폴더생성")
    @PostMapping()//TODO @RESPONSEBODY @RESPONSEeNTITY차이
    public ResponseEntity<?> createFolders(@RequestBody FoldersRequestDto foldersRequestDto){
        foldersService.createFolders(foldersRequestDto);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("폴더명 변경")
    @PatchMapping()
    public ResponseEntity<?> changeFolderName(@RequestBody ChangeNameRequestDto reqDto){
        return ResponseEntity.ok(foldersService.changeFolderName(reqDto));
    }

    @ApiOperation("폴더 삭제")
    @DeleteMapping("/{folderSn}")
    public ResponseEntity<?> deleteFolders(@PathVariable Long folderSn){
        //TODO 형식체크
        HttpStatus result = foldersService.deleteFolders(folderSn);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("폴더 리스트 출력")
    @GetMapping("/{memSn}")
    public ResponseEntity<?> getFolderList(@PathVariable Long memSn){
        //TODo 회원정보만 가지고 리스트 뽑아오기
        Members members = membersRepository.findByMembersSn(memSn);
        List<Folders> foldersList = foldersService.getFoldersList(members);
        return ResponseEntity.ok(foldersList);
    }




//    @PostMapping("/createItem")
//    public String createFolder(String itemName, String wordName,String wordMean, HttpSession session){
//        //폴더정보와 폴더에 속한 단어 함께 입력
//        //비로그인 멤버는 로그인 페이지로 이동
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
//
//        //현재 로그인한 회원의 정보 db에서 찾아오기
//        Members loginMembers = membersRepository.findBymembersSn(sessionMembers.getmembersSn());
//        if(loginMembers == null){
//            System.out.println("예외처리");
//        }
//
//        //아이템 생성하기
//        itemsService.createItems(itemName, loginMembers);
//        Items items = itemsService.getItems(itemName);
//        wordsService.createWords(wordName,wordMean,items);
//        return "redirect:/items";
//
//    }
//    @GetMapping("/itemsForm")
//    private String itemsForm(HttpSession session){
//        //그룹 생성 시 로그인 유저 확인
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//        //로그인 회원일 경우 그룹 생성 페이지로 이동
//        return "/items/itemsForm";
//    }
//
//    @GetMapping("")
//    private String itemsList(HttpSession session, Model model){
//        //그룹 생성 시 로그인 유저 확인
//        if (!HttpSessionUtils.isLoginmembers(session)) {
//            return "/memberss/loginForm";
//        }
//        Members sessionMembers = HttpSessionUtils.getmembersFromSession(session);
//
//        //현재 로그인한 회원의 정보 db에서 찾아오기
//        Members loginMembers = membersRepository.findBymembersSn(sessionMembers.getmembersSn());
//
//        //회원이 생성한 아이템 찾아오기
//        model.addAttribute("items",itemsRepository.findAllBymembersOrderByItemCreatedAtDesc(loginMembers));
//        //로그인 회원일 경우 그룹 생성 페이지로 이동
//        return "/items/itemsList";
//    }
}
