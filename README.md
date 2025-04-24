🛠️ #Agile Software Development Project – JUnit Test Suite for bankingApp.java
As part of an Agile development process, I designed and implemented a JUnit 5 automated test suite for a Java application named bankingApp.java. The primary focus was to enhance the testability, maintainability, and modularity of the application by applying refactoring techniques and thorough unit testing.

📌 Key Contributions
✅ Refactored the Java application to support structured and modular testing using JUnit 5.

✅ Created a comprehensive test suite capable of handling:

Functional tests

Exception handling tests

Parameterized tests

✅ Ensured the code is easily maintainable:

Methods can be added/removed with minimal test changes.

The code is structured in a way that allows future conversion into class-based architecture.

🧪 JUnit 5 Features Implemented
The test suite includes the following annotations:

@BeforeAll – Setup executed once before all tests

@BeforeEach – Setup executed before each test

@Test – Standard unit tests

@ParameterizedTest – For testing multiple input cases

@Timeout – To verify performance under time constraints

@AfterEach – Cleanup after each test

@AfterAll – Final cleanup after all tests
⚠️ Exception Handling
The test suite is also capable of testing:

Custom exceptions

Java standard exceptions, with proper assertions and edge case validation

