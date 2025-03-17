package com.example.demo.repository;

import com.example.demo.entity.DeveloperEntity;
import com.example.demo.entity.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class DeveloperRepositoryTests {
    @Autowired
    private DeveloperRepository developerRepository;

    @BeforeEach
    public void setUp(){
        developerRepository.deleteAll();
    }

    @Test
    @DisplayName("Test save developer functionality")
    public void givenDeveloperObject_whenSave_thanDeveloperIsCreated(){
        //given
        DeveloperEntity developerToSave = DeveloperEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("email.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
        //when
        DeveloperEntity savedDeveloper = developerRepository.save(developerToSave);
        //then
        assertThat(savedDeveloper).isNotNull();
        assertThat(savedDeveloper.getId()).isNotNull();
    }

    @Test
    @DisplayName("Test update developer functionality")
    public void givenDeveloperToUpdate_whenSave_thenEmailIsChanged(){
        //given
        String updatedEmail = "updated@mail.com";
        DeveloperEntity developerToCreate = DeveloperEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("email.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
        developerRepository.save(developerToCreate);
        //when
        DeveloperEntity developerToUpdate = developerRepository.findById(developerToCreate.getId())
                .orElse(null);
        developerToUpdate.setEmail(updatedEmail);
        DeveloperEntity updatedDeveloper = developerRepository.save(developerToUpdate);
        //then
        assertThat(updatedDeveloper).isNotNull();
        assertThat(updatedDeveloper.getEmail()).isEqualTo(updatedEmail);
    }
}
