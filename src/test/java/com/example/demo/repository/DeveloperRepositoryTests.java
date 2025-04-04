package com.example.demo.repository;

import com.example.demo.entity.DeveloperEntity;
import com.example.demo.entity.Status;
import com.example.demo.util.DataUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

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
        DeveloperEntity developerToSave = DataUtils.getJohnDoeTransient();
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
        DeveloperEntity developerToCreate = DataUtils.getJohnDoeTransient();
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

    @Test
    @DisplayName("Test get developer by id functionality")
    public void givenDeveloperCreated_whenGetById_thenReturnDeveloper(){
        //given
        DeveloperEntity developerToCreate = DataUtils.getJohnDoeTransient();
        developerRepository.save(developerToCreate);
        //when
        DeveloperEntity obtainedDeveloper = developerRepository.findById(developerToCreate.getId()).orElse(null);
        //then
        assertThat(obtainedDeveloper).isNotNull();
        assertThat(obtainedDeveloper.getEmail()).isEqualTo(developerToCreate.getEmail());
    }

    @Test
    @DisplayName("Test developer not found functionality")
    public void givenDeveloperIsNotCreated_whenGetById_thenOptionalIsEmpty(){
        //given
        //when
        DeveloperEntity obtainedDeveloper = developerRepository.findById(1).orElse(null);
        //than
        assertThat(obtainedDeveloper).isNull();
    }

    @Test
    @DisplayName("Test get all developers functionality")
    public void getThreeDevelopersAreStored_whenFindAll_thenAllDevelopersAreReturned(){
        //given
        DeveloperEntity developer1 = DataUtils.getJohnDoeTransient();
        DeveloperEntity developer2 = DataUtils.getFrankJonesTransient();
        DeveloperEntity developer3 = DataUtils.getMikeSmithTransient();

        developerRepository.saveAll(List.of(developer1, developer2, developer3));
        //when
        List<DeveloperEntity> obtainedDevelopers = developerRepository.findAll();
        //than
        assertThat(CollectionUtils.isEmpty(obtainedDevelopers)).isFalse();
    }

    @Test
    @DisplayName("Test get developer by email functionality")
    public void givenDeveloperSaved_whenGetByEmail_thenReturnDeveloper(){
        //given
        DeveloperEntity developer = DataUtils.getJohnDoeTransient();
        developerRepository.save(developer);
        //when
        DeveloperEntity obtainedDeveloper = developerRepository.findByEmail(developer.getEmail());
        //than
        assertThat(obtainedDeveloper).isNotNull();
        assertThat(obtainedDeveloper.getEmail()).isEqualTo(developer.getEmail());
    }

    @Test
    @DisplayName("Test get all active developers by specialty functionality")
    public void givenThreeDevelopersAndTwoDevelopersAreActive_whenFindAllActiveBySpecialty_thenReturnedOnlyTwoDevelopers(){
        //given
        DeveloperEntity developer1 = DataUtils.getJohnDoeTransient();
        DeveloperEntity developer2 = DataUtils.getFrankJonesTransient();
        DeveloperEntity developer3 = DataUtils.getMikeSmithTransient();
        developerRepository.saveAll(List.of(developer1, developer2, developer3));
        //when
        List<DeveloperEntity> obtainedDevelopers = developerRepository.findAllActiveBySpecialty("Java");
        //than
        assertThat(CollectionUtils.isEmpty(obtainedDevelopers)).isFalse();
        assertThat(obtainedDevelopers.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test delete developer by id functionality")
    public void givenDeveloperIsSaved_whenDeleteById_thenDeveloperIsRemovedFromDB(){
        //given
        DeveloperEntity developer = DataUtils.getJohnDoeTransient();
        developerRepository.save(developer);
        //when
        developerRepository.deleteById(developer.getId());
        //than
        DeveloperEntity obtainedDeveloper = developerRepository.findById(developer.getId()).orElse(null);
        assertThat(obtainedDeveloper).isNull();
    }
}
