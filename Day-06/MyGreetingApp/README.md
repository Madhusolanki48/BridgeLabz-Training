# MyGreetingApp

A simple Spring MVC CRUD app to add, view, edit, and delete greeting messages.

## Features

- Add a new greeting
- View all greetings
- Open one greeting detail page
- Edit an existing greeting
- Delete a greeting

### Home Page

Add a greeting and see all saved greetings in one place.

![Home page](screenshots/home.png)

### Greeting Details

View one greeting in a clean detail page.

![Greeting details page](screenshots/greeting.png)

### Edit Greeting

Update the name or message for an existing greeting.

![Edit greeting page](screenshots/edit%20greeting.png)


## Run The App

Open a terminal inside this project:

```powershell
cd Day-6\MyGreetingApp
```

Start the Spring Boot app:

```powershell
mvn spring-boot:run
```

Open:

```text
http://localhost:8081/MyGreetingApp/
```

<details>
<summary>Build WAR for Tomcat</summary>

```powershell
mvn clean package
```

The WAR file is created at:

```text
target/MyGreetingApp.war
```

Copy it into the Tomcat `webapps` folder and open:

```text
http://localhost:8080/MyGreetingApp/
```

Use Tomcat 10 or newer because this app uses Spring Boot 3.

</details>

## Project Flow

```text
Browser
  -> GreetingController
  -> GreetingRepository
  -> Greeting model
  -> Thymeleaf template
```

## CRUD Routes

| Action | Method | URL |
| --- | --- | --- |
| Home page | GET | `/MyGreetingApp/` |
| Save greeting | POST | `/MyGreetingApp/greetings` |
| View greeting | GET | `/MyGreetingApp/greetings/{id}` |
| Edit form | GET | `/MyGreetingApp/greetings/{id}/edit` |
| Update greeting | POST | `/MyGreetingApp/greetings/{id}` |
| Delete greeting | POST | `/MyGreetingApp/greetings/{id}/delete` |

<details>
<summary>Important files</summary>

| File | Use |
| --- | --- |
| `GreetingsApplication.java` | Starts the Spring Boot app |
| `Greeting.java` | Greeting model |
| `GreetingRepository.java` | In-memory data storage |
| `GreetingController.java` | Handles CRUD routes |
| `index.html` | Home page and list |
| `greeting.html` | Detail page |
| `edit.html` | Edit form |
| `style.css` | App styling |
| `application.properties` | Port and context path |

</details>

<details>
<summary>Common error</summary>

If port `8081` is already in use, stop the old app or change this line in `src/main/resources/application.properties`:

```properties
server.port=8081
```

</details>
