package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Words;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import com.example.lietenerbox.repository.WordsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudyWordsService {
    private final PersonRepository personRepository;
    private final WordsRepository wordsRepository;
    private final RecordsRepository recordsRepository;

    public StudyWordsService(PersonRepository personRepository, WordsRepository wordsRepository, WordInContainerRepository wordInContainerRepository, RecordsRepository recordsRepository) {
        this.personRepository = personRepository;
        this.wordsRepository = wordsRepository;
        this.recordsRepository = recordsRepository;
    }

    int level1 = 0;
    int level2 = 0;
    int level3 = 0;

    List wordsList = new ArrayList();

    //차수에 맞는 단어 리스트 가져오기
    public List wordLevelList(String[] todayStep) {

        if (todayStep.length == 1) {
            level1 = Integer.parseInt(todayStep[0]);
            wordsList = wordsRepository.findBywordLevel(level1);

        } else if (todayStep.length == 2) {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            wordsList = wordsRepository.findBywordLevel(level1);
            wordsList.add(wordsRepository.findBywordLevel(level2));

        } else {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            level3 = Integer.parseInt(todayStep[2]);
            wordsList = wordsRepository.findBywordLevel(level1);
            wordsList.add(wordsRepository.findBywordLevel(level2));
            wordsList.add(wordsRepository.findBywordLevel(level3));

        }
        return wordsList;

    }


    public void checkLevel(String right, String wrong) {
        wordsRepository.save(new Words(right, wrong));
    }
}
