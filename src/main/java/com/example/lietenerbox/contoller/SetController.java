package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Member;
import com.example.lietenerbox.model.Set;
import com.example.lietenerbox.model.Word;
import com.example.lietenerbox.repository.MemberRepository;
import com.example.lietenerbox.repository.SetRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sets")
public class SetController {

//    @Autowired
//    private MemberRepository memberRepository;
//    @Autowired
//    private SetRepository setRepository;
//    @Autowired
//    private WordRepository wordRepository;
//
//    //회원이 만든 세트리스트
//    @GetMapping("/{id}")
//    public Set setAll(@PathVariable Long id){
//        return setRepository.findAllBymemId(id);
//    }

//    @GetMapping("/{id}/{
//
//
//
//
//
//    setId}")
//    public Iterable<Word> WordListAll(){
//        return wordRepository.findAll();
//    }
}
