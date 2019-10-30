package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.ContainerChangeReqDto;
import com.example.lietenerbox.contoller.requestDto.ContainerRequestDto;
import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.dto.response.ContainerResponseDto;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.service.ContainerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;


@RestController
@RequestMapping(value = "/containers", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class ContainerController {

    @Autowired
    private ContainerRepository containerRepository;

    @Autowired
    private ContainerService containerService;


    @ApiOperation("클래스 생성")
    @PostMapping()
    public ResponseEntity<?> createContainers(@RequestBody ContainerRequestDto reqDto) {
        ContainerResponseDto resDto =  containerService.createContainers(reqDto);
        return ResponseEntity.ok(resDto);
    }

    @ApiOperation("클래스 내용 수정")//생성자가 로그인 했을때만 수정 버튼 보이기
    @PutMapping()
    public ResponseEntity<?> changeContainers(@RequestBody ContainerChangeReqDto reqDto) {
        Container changedContainer = containerService.changeContainers(reqDto);
        return ResponseEntity.ok(changedContainer);
    }

    //Todo 비활성화버튼 클릭 시 구독 멤버에게 알림 보내기
    //@ApiOperation("그룹 비활성화")

    @ApiOperation("클래스 목록 출력")
    @GetMapping("/{memSn}")
    public ResponseEntity<?> getContainerList(@PathVariable @NotBlank Long memSn) {
        List<Container> containerList = containerService.getContainerList(memSn);
        return ResponseEntity.ok(containerList);
    }


}
