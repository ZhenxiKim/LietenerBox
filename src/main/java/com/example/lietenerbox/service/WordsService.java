package com.example.lietenerbox.service;

import com.example.lietenerbox.contoller.requestDto.ChangeWordsListForm;
import com.example.lietenerbox.contoller.requestDto.ChangeWordsListReqDto;
import com.example.lietenerbox.contoller.requestDto.WordsListForm;
import com.example.lietenerbox.contoller.requestDto.WordsRequestDto;
import com.example.lietenerbox.exception.DataNotFoundException;
import com.example.lietenerbox.model.Folders;
import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.repository.FoldersRepository;
import com.example.lietenerbox.repository.WordsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordsService {
    private final WordsRepository wordsRepository;
    private final FoldersRepository foldersRepository;

    public WordsService(WordsRepository wordsRepository,
                        FoldersRepository foldersRepository) {
        this.wordsRepository = wordsRepository;
        this.foldersRepository = foldersRepository;
    }

    public void createWords(WordsRequestDto reqDto) {
        Long folderSn = reqDto.getFolderSn();
        Folders folders = foldersRepository.findById(folderSn).orElseThrow(DataNotFoundException::new);

        List<WordsListForm> wordsList = reqDto.getWordsList();
        for (WordsListForm newWords : wordsList) {
            wordsRepository.save(new Words(folders, newWords));
        }
    }

    public List<Words> changeWordsList(ChangeWordsListReqDto reqDto) {
        Long folderSn = reqDto.getFolderSn();
        Folders folders = foldersRepository.findById(folderSn).orElseThrow(DataNotFoundException::new);

        List<ChangeWordsListForm> wordsList = reqDto.getWordsList();

        for (ChangeWordsListForm words : wordsList) {
            wordsRepository.save(new Words(folders, words));
        }
        List<Words> result = wordsRepository.findAllByFolders(folders);
        return result;
    }


    public List<Words> getWordsList(Long folderSn) {
        Optional<Folders> folders = foldersRepository.findById(folderSn);
        List<Words> wordsList = wordsRepository.findAllByFolders(folders);
        return wordsList;
    }

}
