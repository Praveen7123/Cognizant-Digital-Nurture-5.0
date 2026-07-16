# SonarQube — Code Quality Analysis (Week 4)

SonarQube scans your code (without running it) and reports bugs, code smells,
security vulnerabilities, duplication, and test coverage. Here is how to run it
against one of the Week 4 microservices (e.g. the `account` service).

## Step 1 — Start a SonarQube server (Docker)
```powershell
docker run -d --name sonarqube -p 9000:9000 sonarqube:lts-community
```
Wait ~1 minute, then open http://localhost:9000
- Default login:  username `admin` , password `admin`
- It will ask you to set a new password on first login.

## Step 2 — Create a project token
In the SonarQube dashboard:
- Click your avatar (top-right) -> **My Account** -> **Security**
- Under **Generate Tokens**, type a name (e.g. `account`) -> **Generate**
- Copy the token (looks like `sqp_xxxxxxxx`). You only see it once.

## Step 3 — Run the analysis from the project folder
```powershell
cd C:\cts\Cognizant-Digital-Nurture-5.0\Week4\01-Microservices\account

mvn clean verify sonar:sonar `
  -Dsonar.host.url=http://localhost:9000 `
  -Dsonar.token=YOUR_TOKEN_HERE `
  -Dsonar.projectKey=account
```
(Replace `YOUR_TOKEN_HERE` with the token from Step 2.)

> Note: `sonar:sonar` works without adding a plugin to pom.xml — Maven resolves
> the SonarScanner goal automatically. Optionally you can pin it in pom.xml:
>
> ```xml
> <plugin>
>   <groupId>org.sonarsource.scanner.maven</groupId>
>   <artifactId>sonar-maven-plugin</artifactId>
>   <version>4.0.0.4121</version>
> </plugin>
> ```

## Step 4 — Read the report
Go back to http://localhost:9000 and open your project. Look at:
- **Bugs** — likely runtime errors
- **Code Smells** — maintainability issues
- **Vulnerabilities / Security Hotspots** — security risks
- **Coverage** — how much code is covered by tests
- **Duplications** — repeated code
- **Quality Gate** — overall Passed / Failed status

## Step 5 — Stop the server when done
```powershell
docker stop sonarqube
```
