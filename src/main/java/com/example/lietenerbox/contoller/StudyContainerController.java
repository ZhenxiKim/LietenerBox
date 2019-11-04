package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ResultContainerRequestDto;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.service.StudyContainerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.zip.DataFormatException;

@RestController
public class StudyContainerController {
    private final MembersRepository membersRepository;
    private final RecordsRepository recordsRepository;
    private final StudyContainerService studyContainerService;
    private final WordInContainerRepository wordInContainerRepository;

    public StudyContainerController(MembersRepository membersRepository, RecordsRepository recordsRepository,
                                    WordInContainerRepository wordInContainerRepository,
                                    StudyContainerService studyContainerService) {

        this.membersRepository = membersRepository;
        this.recordsRepository = recordsRepository;
        this.studyContainerService = studyContainerService;
        this.wordInContainerRepository = wordInContainerRepository;
    }

    //회원의 학습 단계와 학습해야할 단어 출력
    @ApiOperation("날짜별 학습 단어 가져오기")
    @RequestMapping(method = RequestMethod.GET, value = "/study/containers")
    public ResponseEntity<?> getStudyWordsInContainers(HttpSession session) throws ParseException {

        return ResponseEntity.ok(studyContainerService.getStudyWordsInContainers(session));

    }

    @ApiOperation("학습한 단어 학습 체크")
    @RequestMapping(method = RequestMethod.POST, value="/study/containers")
    public ResponseEntity.BodyBuilder levelTestResult(@RequestBody ResultContainerRequestDto reqDto) throws DataFormatException {
        //TODO 리턴값 확인
        studyContainerService.checkLevel(reqDto);
        return ResponseEntity.ok();
    }


}
