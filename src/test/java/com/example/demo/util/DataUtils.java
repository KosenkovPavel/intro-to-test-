package com.example.demo.util;

import com.example.demo.entity.DeveloperEntity;
import com.example.demo.entity.Status;

public class DataUtils {
    public static DeveloperEntity getJohnDoeTransient(){
        return DeveloperEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("email.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }

    public static DeveloperEntity getJohnDoePersistent(){
        return DeveloperEntity.builder()
                .id(1)
                .firstName("John")
                .lastName("Doe")
                .email("email.doe@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }

    public static DeveloperEntity getMikeSmithTransient(){
        return DeveloperEntity.builder()
                .firstName("Mike")
                .lastName("Smith")
                .email("email.smith@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }

    public static DeveloperEntity getMikeSmithPersistent(){
        return DeveloperEntity.builder()
                .id(2)
                .firstName("Mike")
                .lastName("Smith")
                .email("email.smith@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }

    public static DeveloperEntity getFrankJonesTransient(){
        return DeveloperEntity.builder()
                .firstName("Frank")
                .lastName("Jones")
                .email("email.jones@mail.com")
                .specialty("Java")
                .status(Status.DELETED)
                .build();
    }

    public static DeveloperEntity getFrankJonesPersistent(){
        return DeveloperEntity.builder()
                .id(3)
                .firstName("Frank")
                .lastName("Jones")
                .email("email.jones@mail.com")
                .specialty("Java")
                .status(Status.ACTIVE)
                .build();
    }
}
