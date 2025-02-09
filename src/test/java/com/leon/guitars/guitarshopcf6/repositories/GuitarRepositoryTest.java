package com.leon.guitars.guitarshopcf6.repositories;

import com.leon.guitars.guitarshopcf6.entities.Guitar;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none"
})
@Testcontainers
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GuitarRepositoryTest {

    @Container
    static PostgreSQLContainer<?> postgres =
            new PostgreSQLContainer<>("postgres:16-alpine");
//                    .withCopyFileToContainer(
//                            MountableFile.forClasspathResource("sql/init-db.sql"),
//                            "/docker-entrypoint-initdb.d/init-db.sql");

    @Autowired
    private GuitarRepository guitarRepository;

    @Test
    @DisplayName("Test 1:Save Employee Test")
    @Order(1)
    @Rollback(value = false)
    public void save() {

        //Action
        Guitar guitar = new Guitar("Fender", 22L, "Stratocaster", 1000.0);

        guitarRepository.save(guitar);

        //Verify
        System.out.println(guitar);
        assertThat(guitar.getId()).isGreaterThan(0);
    }
}
