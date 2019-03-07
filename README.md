# spring-todos-rest-api

This is a CRUD REST api for a todo model with two fields: a Long id and a String text (text of the todo).

It uses Spring, including Spring Boot and Spring Data for the JPA implementation. It uses zero xml files for configuration (apart from the pom.xml file, of course, because it's a maven project).

## Setup

Run

```bash
  mvn clean install
```

To download all dependencies and such, then start the API with

```bash
  mvn spring-boot:run
```

Alternatively, you can import to Intellij IDEA (via the Import maven project option) and then use the commands from the IDE to run.