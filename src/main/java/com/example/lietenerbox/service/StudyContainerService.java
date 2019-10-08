package com.example.lietenerbox.service;

import com.example.lietenerbox.model.WordInGroup;
import com.example.lietenerbox.repository.PersonRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInGroupRepository;
import com.example.lietenerbox.repository.WordsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StudyContainerService {
    private final PersonRepository personRepository;
    private final WordInGroupRepository wordInGroupRepository;
    private final RecordsRepository recordsRepository;

    public StudyContainerService(PersonRepository personRepository, WordsRepository wordsRepository, WordInGroupRepository wordInGroupRepository, RecordsRepository recordsRepository) {
        this.personRepository = personRepository;
        this.wordInGroupRepository = wordInGroupRepository;
        this.recordsRepository = recordsRepository;
    }

    int level1 = 0;
    int level2 = 0;
    int level3 = 0;

    List containerWordsList = new ArrayList();

    public Object containerWordLevelList(String[] todayStep) {
        if (todayStep.length == 1) {
            level1 = Integer.parseInt(todayStep[0]);
            containerWordsList = wordInGroupRepository.findByGroupWordLevel(level1);

        } else if (todayStep.length == 2) {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            containerWordsList = wordInGroupRepository.findByGroupWordLevel(level1);
            containerWordsList.add(wordInGroupRepository.findByGroupWordLevel(level2));

        } else {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            level3 = Integer.parseInt(todayStep[2]);
            containerWordsList = wordInGroupRepository.findByGroupWordLevel(level1);
            containerWordsList.add(wordInGroupRepository.findByGroupWordLevel(level2));
            containerWordsList.add(wordInGroupRepository.findByGroupWordLevel(level3));

        }
        return containerWordsList;
    }

    public void checkLevel(String right, String wrong) {
        wordInGroupRepository.save(new WordInGroup(right, wrong));
    }
}
