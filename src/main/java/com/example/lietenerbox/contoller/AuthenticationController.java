package com.example.lietenerbox.contoller;

import com.example.lietenerbox.contoller.requestDto.MembersSignInRequestDto;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.service.AuthenticationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/authentications",consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
public class AuthenticationController {

    private final MembersRepository membersRepository;
    private final AuthenticationService authenticationService;

    public AuthenticationController(MembersRepository membersRepository,AuthenticationService authenticationService){
        this.membersRepository = membersRepository;
        this.authenticationService = authenticationService;
    }

    @ApiOperation("로그인")
    @GetMapping
    public ResponseEntity<?> signIn(@RequestBody MembersSignInRequestDto membersSignInRequestDto){
        authenticationService.signIn(membersSignInRequestDto);
        return ResponseEntity.ok().build();
    }
}
