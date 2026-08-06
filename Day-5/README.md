# My Greeting App

The app has an HTML form where the user enters a name. The form sends the name to a servlet, and the greeting is displayed on a JSP result page.

## Concepts Practiced

- Java web application folder structure
- Apache Tomcat deployment
- Servlet creation using `HttpServlet`
- Servlet mapping with `@WebServlet`
- Handling form data with `request.getParameter()`
- Forwarding data from a servlet to a JSP page
- Building a WAR file using Maven

## Project Structure

```text
Day-5/
`-- MyGreetingApp/
    |-- pom.xml
    `-- src/
        `-- main/
            |-- java/
            |   `-- com/
            |       `-- greetings/
            |           `-- GreetingServlet.java
            `-- webapp/
                |-- index.html
                |-- greeting.jsp
                |-- css/
                |   `-- styles.css
                `-- WEB-INF/
                    `-- web.xml
```

## Important Files

- `src/main/webapp/index.html` - form page
- `src/main/webapp/greeting.jsp` - greeting result page
- `src/main/webapp/css/styles.css` - page styling
- `src/main/java/com/greetings/GreetingServlet.java` - servlet that receives the submitted name
- `src/main/webapp/WEB-INF/web.xml` - web app configuration
- `pom.xml` - Maven build configuration

## How It Works

1. The user opens `index.html` through Tomcat.
2. The user enters a name and clicks `Greet Me`.
3. The form posts the data to `/greeting`.
4. `GreetingServlet` reads the `username` parameter.
5. The servlet stores the name in the request.
6. The servlet forwards the request to `greeting.jsp`.
7. `greeting.jsp` displays the greeting and a Back button.

## Screenshots

### Home Page

![MyGreetingApp home page](screenshots/home-page.png)

### Greeting Result

![MyGreetingApp greeting result](screenshots/old-result-page.png)

## Build

Run this from the `MyGreetingApp` folder:

```powershell
mvn clean package
```

Maven creates:

```text
target/MyGreetingApp.war
```

## Run On Tomcat

1. Copy `target/MyGreetingApp.war` into the Tomcat `webapps` folder.
2. Start Tomcat.
3. Open:

```text
http://localhost:8080/MyGreetingApp/
```

## Note

This is a normal Servlet project, not a Spring Boot project. It does not need `GreetingsApplication.java`, `MyGreetingApplication.java`, or a Spring controller.
