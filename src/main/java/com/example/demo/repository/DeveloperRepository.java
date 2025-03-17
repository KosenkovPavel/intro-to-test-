package com.example.demo.repository;

import com.example.demo.entity.DeveloperEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Integer> {
    DeveloperEntity findByEmail(String email);

    @Query("select d from DeveloperEntity d where d.status = 'ACTIVE' and d.specialty = :specialty")
    List<DeveloperEntity> findAllActiveBySpecialty(String specialty);
}
