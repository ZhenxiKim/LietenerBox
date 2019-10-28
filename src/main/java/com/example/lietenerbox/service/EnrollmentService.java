package com.example.lietenerbox.service;

import com.example.lietenerbox.model.Container;
import com.example.lietenerbox.model.Enrollment;
import com.example.lietenerbox.model.Members;
import com.example.lietenerbox.repository.ContainerRepository;
import com.example.lietenerbox.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnrollmentService {

    private final ContainerRepository containerRepository;
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(ContainerRepository containerRepository, EnrollmentRepository enrollmentRepository) {
        this.containerRepository = containerRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public void apply(Members sessionMembers, Long groupId) {

        Container container = containerRepository.findByContainerId(groupId);
        enrollmentRepository.save(new Enrollment(sessionMembers, container));



    }
}
