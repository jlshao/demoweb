# Spring Demo

### Prerequisite:
- Gradle: Build tool
- MongoDB: Car repository
- Spring Boot: allows minimum configurations

### Build and run:
```
gradlew.bat build
run.bat
```

When the application is running, open browser to access:
	http://localhost:8080/

Two users have been configured:
- User "User" is a standard user, password is "password".
- User "Admin" is an admin user, password is "Admin".

Enter user and password to login. After that, you will be on the welcome page which gives two methods to access our "Car Inventory" data:
- CRUD web pages
- RESTful services
  

### Security
Spring also supports OAuth2 authentication. I was able to login with Google authentication but it requires Spring SNAPSHOT build 5.1.0 which might have some dependency issues working with its RELEASE version 5.0.8.
The screenshots can be found at [./screenshot](./screenshot).

The following controller code does the OAuth2 authentication:
```
@Controller
public class OAuth2LoginController {
	@GetMapping("/")
	public String index(Model model,
						@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
						@AuthenticationPrincipal OAuth2User oauth2User) {
		model.addAttribute("userName", oauth2User.getName());
		model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
		model.addAttribute("userAttributes", oauth2User.getAttributes());
		return "index";
	}
}
```
