package com.example.myapp.common;

import com.example.myapp.userservice.model.Role;
import com.example.myapp.userservice.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

//@Component
//@Transactional
//@DependsOn("entityManagerFactory")
//@Profile("!test") // Only run outside "test" profile
//public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
//
//    private final RoleRepository roleRepository;
//
//    public DataInitializer(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
//
//    @PostConstruct
//    public void init() {
//        // Check if global roles exist already to avoid duplicates
//        if (roleRepository.findByNameAndOrganizationIsNull("ROLE_ADMIN").isEmpty()) {
//            List<Role> defaultRoles = List.of(
//                    Role.builder().id(UUID.randomUUID()).name("ROLE_ADMIN").organization(null).build(),
//                    Role.builder().id(UUID.randomUUID()).name("ROLE_USER").organization(null).build(),
//                    Role.builder().id(UUID.randomUUID()).name("ROLE_GUEST").organization(null).build()
//            );
//            roleRepository.saveAll(defaultRoles);
//            System.out.println("Default global roles created");
//        }
//    }
//
//    /**
//     * Handle an application event.
//     *
//     * @param event the event to respond to
//     */
//    @Override
//    public void onApplicationEvent(ApplicationReadyEvent event) {
//
//    }
//}

