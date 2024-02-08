# -POO-Project
Object Oriented Programming

## Project Overview

This project aims to develop a Java application for managing the publications of CISUC researchers. The main goal is to support various queries and reports that are essential for an international evaluation of the CISUC.

## Key Features

**User Interface**: Implemented through a console-based interface for executing queries and generating reports.
- **Data Management**:
  - **Input Data**: Initial data is loaded from text files, including details on researchers, research groups, and publications. After the first launch, data is stored in object files, which are loaded at startup.
  - **Research Groups**: Comprise a responsible researcher (full member) and a list of group members, characterized by their name, email, and category (full member or student).
  - **Publications**: Characterized by authors, title, keywords, publication year, type (conference paper, journal article, book), and audience size.
    - **Impact Factor Calculation**: Critical for evaluating research groups, based on publication type and audience size:
      - **Conference Paper**: Impact factor A for audience >=500, B for audience <500 and >=200, C for audience <200.
      - **Journal Article**: A for audience >=1,000, B for audience <1,000 and >=500, C for audience <500.
      - **Book**: A for audience >=10,000, B for audience <10,000 and >=5,000, C for audience <5,000.
      - **Book Chapter**: Same as Book.
      - **Conference Article Book**: A for audience >=7,500, B for audience <7,500 and >=2,500, C for audience <2,500.
        
## Implementation Details

- Written in Java, following Object-Oriented Programming (OOP) principles.
- Emphasizes encapsulation, with classes managing their data and methods.
- Adheres to Java naming conventions and avoids redundancy in data organization.
- Utilizes UML for planning the project structure.

## Environment

Apache NetBeans

## Run
```
javac -Xlint *.java
java -cp . MainCISUC

```
