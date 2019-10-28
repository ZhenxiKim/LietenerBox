package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.ChangeNameRequestDto;
import com.example.lietenerbox.contoller.requestDto.FoldersRequestDto;
import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.contoller.requestDto.ItemsRequestDto;
import com.example.lietenerbox.repository.FoldersRepository;
import com.example.lietenerbox.repository.MembersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoldersService {
    private final FoldersRepository foldersRepository;
    private final MembersRepository membersRepository;

    public FoldersService(FoldersRepository foldersRepository, MembersRepository membersRepository){
        this.foldersRepository = foldersRepository;
        this.membersRepository = membersRepository;
    }



    //회원이 생성한 아이템 리스트 출력
    public List<Folders> getFoldersList(Members savedMembers) {
        return foldersRepository.findAllBymembersOrderByItemCreatedAtDesc(savedMembers);
    }


    public Folders getItems(String itemName) {
        return foldersRepository.findByItemName(itemName);
    }

    public Folders createFolders(FoldersRequestDto foldersRequestDto) {
        Long memSn = foldersRequestDto.getMemSn();
        Members members = membersRepository.findByMembersSn(memSn);

        String folderName = foldersRequestDto.getFolderName();

        return foldersRepository.save(new Folders(folderName,members));
    }

    public HttpStatus changeFolderName(ChangeNameRequestDto reqDto) {
        //TODo 어떠한 방법이 맞는지
        Long folderSn = reqDto.getFolderSn();
        String folderName = reqDto.getNewFolderName();

        Optional<Folders> folders = foldersRepository.findById(folderSn);
        folders.get().setItemName(folderName);
        return HttpStatus.OK;
    }

    public HttpStatus deleteFolders(Long folderSn) {
        Optional<Folders> folders = foldersRepository.findById(folderSn);
        folders.get().setActiveFlag(false);
        return HttpStatus.OK;
    }
}
