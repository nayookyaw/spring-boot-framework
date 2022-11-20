    Author
    Nay Oo Kyaw
    nayookyaw.nok@gmail.com

# requirement installation
- java version >= 17
- vscode
- install necessary extension in vscode
    1. Install the Extension Pack for Java <br>
    [vscode:extension/vscjava.vscode-java-pack]
    2. Install the Spring Boot Extension Pack <br>
    [vscode:extension/pivotal.vscode-boot-dev-pack]

# run the application
- look for the "Run" menu on the top
- Start Debugging or F5

<b>OR</b><br>
    $ mvnw spring-boot:run 

<br>

<i>clean the dependency</i> <br>
    $ mvnw clean install spring-boot:repackage

# Note
* after you added depenency in pom.xml, <br>
make sure to run this below command in project folder <br>
    $ <b>mvnw dependency:resolve</b>

* if you want to do auto-refresh use <br>
    <b>spring-boot-devtools</b>

# references
how to config hikaricp for jdbc <br>
https://howtodoinjava.com/spring-boot2/jpa-hibernate-hikaricp-config/
https://www.javadevjournal.com/spring-boot/spring-boot-hikari/

* error handling reference <br>
https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/




