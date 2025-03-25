# Test Repository

## Overview
This repository contains unit and integration tests for a Spring-based Java application using Gradle as the build tool. The tests ensure the correctness and reliability of the application's core functionalities.

## Technologies Used
- **Java** (JDK 21+ recommended)
- **Spring Boot**
- **JUnit 5** for unit testing
- **Testcontainers** for integration testing
- **Gradle** for dependency management and build automation

## Project Structure
```
|-- src
|   |-- test
|       |-- java
|           |-- com.example.demo
|               |-- repository    # Unit for repository layer
|               |-- util # Utilities
|-- build.gradle.kts
|-- settings.gradle.kts
|-- README.md
```

## Running Tests

### Run all tests:
```sh
gradle test
```

## Adding New Tests
1. Place unit tests under `src/test/java/com/example/demo/` and choose layer for test
3. Use JUnit 5 (`@Test` annotation) for writing tests.
4. Use `@SpringBootTest` for integration tests requiring Spring context.

## Contributing
1. Fork the repository.
2. Create a new branch (`feature/new-test`).
3. Commit your changes.
4. Open a pull request.

## License
This project is licensed under the Apache License.

