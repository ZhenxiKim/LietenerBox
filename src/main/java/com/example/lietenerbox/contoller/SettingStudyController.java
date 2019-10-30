package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.SettingDateReqDto;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.model.Records;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.service.SettingStudyService;
import com.example.lietenerbox.service.StudyWordsService;
import com.example.lietenerbox.util.HttpSessionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;

@RestController
@RequestMapping("/settings")
public class SettingStudyController {
    private final MembersRepository membersRepository;
    private final StudyWordsService studyService;
    private final SettingStudyService settingStudyService;

    public SettingStudyController(MembersRepository membersRepository, StudyWordsService studyService, SettingStudyService settingStudyService) {
        this.membersRepository = membersRepository;
        this.studyService = studyService;
        this.settingStudyService = settingStudyService;
    }


    //studySetting 페이지에서 회원이설정한 학습모드일자 입력
    @PostMapping("")
    public ResponseEntity<?> setStudyDate(@RequestBody SettingDateReqDto reqDto) {

        //사용자가 입력한 날짜 설정
        Records records = settingStudyService.setStudyDate(reqDto);
        return ResponseEntity.ok(records);
    }

 }
