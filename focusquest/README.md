# FocusQuest – Full Stack Pomodoro Productivity App

A beginner-friendly upgrade of the original console Pomodoro project into a web application using HTML, CSS, JavaScript, Spring Boot, JPA/Hibernate and MySQL.

## Features
- Register/login with BCrypt password hashing
- Pomodoro, short break and long break timer
- Start, pause, resume and reset
- Task CRUD (add, complete, delete)
- Priority for tasks
- XP and level system
- Pomodoro session history/statistics
- MySQL persistence
- Responsive dashboard UI

## Requirements
- Java 17+ (your Java 25 is also suitable if Maven/Spring Boot is configured for it)
- Maven
- MySQL

## MySQL
The application is configured for:
- database: `focusquest` (created automatically)
- username: `root`
- password: `root`

If your MySQL password is different, edit `src/main/resources/application.properties`.

## Run
1. Open this folder in IntelliJ IDEA.
2. Make sure MySQL is running.
3. Run `FocusQuestApplication.java`.
4. Open `http://localhost:8080`.

## API endpoints
- POST `/api/auth/register`
- POST `/api/auth/login`
- GET `/api/auth/{id}`
- GET `/api/tasks/user/{userId}`
- POST `/api/tasks`
- PUT `/api/tasks/{id}/complete`
- DELETE `/api/tasks/{id}`
- POST `/api/sessions`
- GET `/api/sessions/stats/{userId}`

## Next improvements for a production version
Spring Security/JWT authentication, edit-task API, settings page, daily charts, refresh-token/session security, and deployment.
