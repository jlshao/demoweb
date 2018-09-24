Build:
	gradlew.bat build

Run:
	run.bat

Open browser:
	http://localhost:8080/public
		This is a page anyone can access.
	http://localhost:8080/hello
		This page is a restricted page and will be redirected to a login page. After entering "user" and "password".
	http://localhost:8080/greeting
		This is a restricted RESTful API call which returns JSON data.
		