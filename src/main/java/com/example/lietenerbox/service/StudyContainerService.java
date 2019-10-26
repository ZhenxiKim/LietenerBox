package com.example.lietenerbox.service;

import com.example.lietenerbox.model.WordInContainer;
import com.example.lietenerbox.repository.MembersRepository;
import com.example.lietenerbox.repository.RecordsRepository;
import com.example.lietenerbox.repository.WordInContainerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class StudyContainerService {
    private final MembersRepository membersRepository;
    private final WordInContainerRepository wordInContainerRepository;
    private final RecordsRepository recordsRepository;

    public StudyContainerService(MembersRepository membersRepository, WordInContainerRepository wordInContainerRepository, RecordsRepository recordsRepository) {
        this.membersRepository = membersRepository;
        this.wordInContainerRepository = wordInContainerRepository;
        this.recordsRepository = recordsRepository;
    }

    int level1 = 0;
    int level2 = 0;
    int level3 = 0;

    List containerWordsList = new ArrayList();

    public Object containerWordLevelList(String[] todayStep) {
        if (todayStep.length == 1) {
            level1 = Integer.parseInt(todayStep[0]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);

        } else if (todayStep.length == 2) {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level2));

        } else {
            level1 = Integer.parseInt(todayStep[0]);
            level2 = Integer.parseInt(todayStep[1]);
            level3 = Integer.parseInt(todayStep[2]);
            containerWordsList = wordInContainerRepository.findByContainerWordLevel(level1);
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level2));
            containerWordsList.add(wordInContainerRepository.findByContainerWordLevel(level3));

        }
        return containerWordsList;
    }

    public void checkLevel(String right, String wrong) {
        wordInContainerRepository.save(new WordInContainer(right, wrong));
    }
}
