package com.example.lietenerbox.contoller;

import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.service.StudyContainerService;
import com.example.lietenerbox.util.DateUtils;
import com.example.lietenerbox.util.StudyLevelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;

@Controller
@RequestMapping("/containerWords")
public class StudyContainerController {
    private final PersonRepository personRepository;
    private final RecordsRepository recordsRepository;
    private final StudyContainerService studyContainerService;
    private final WordInGroupRepository wordInGroupRepository;

    public StudyContainerController(PersonRepository personRepository,RecordsRepository recordsRepository,
                                 WordInGroupRepository wordInGroupRepository,
                                 StudyContainerService studyContainerService){

        this.personRepository = personRepository;
        this.recordsRepository = recordsRepository;
        this.studyContainerService = studyContainerService;
        this.wordInGroupRepository = wordInGroupRepository;
    }

    //회원의 학습 단계와 학습해야할 단어 출력
    @GetMapping("/studyMain")
    public String gettingDate(Person loginPerson, Model model) throws ParseException {

        //로그인한 회원 정보를 토대로 회원이 셋팅한 학습 시작 날짜 가져오기
        Records records = recordsRepository.findAllByPerson(loginPerson);

        //오늘 학습 차수 = 오늘 날짜 - 회원가입 날짜
        Long stepDay = DateUtils.calDate(records);

        //오늘 공부해야할 단계 string[]로 반환
        String[] todayStep = StudyLevelUtils.wordLevel(stepDay);

        model.addAttribute("studyContainer", studyContainerService.containerWordLevelList(todayStep));

        return "study/containerStudy";

    }
//학습한 단어 학습 확인
    @PostMapping()
    public void levelTest(String right, String wrong) {
        studyContainerService.checkLevel(right,wrong);
    }


}