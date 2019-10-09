package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Enrollment;
import com.example.lietenerbox.model.Groups;
import com.example.lietenerbox.model.Person;
import com.example.lietenerbox.repository.EnrollmentRepository;
import com.example.lietenerbox.repository.GroupsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrollmentService {

    private final GroupsRepository groupsRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(GroupsRepository groupsRepository,EnrollmentRepository enrollmentRepository) {
        this.groupsRepository = groupsRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void apply(Person sessionPerson, Long groupId) {

        Groups groups = groupsRepository.findByGroupId(groupId);
        enrollmentRepository.save(new Enrollment(sessionPerson,groups));



    }
}
