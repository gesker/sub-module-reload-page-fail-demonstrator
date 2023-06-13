Quarkus does not reload (represent??) changes in xhtml files to the browser.

To reproduce:

```
./mvnw clean compile quarkus:dev -pl other
./mvnw clean compile quarkus:dev -pl www
```
* Browse to localhost:8080
* Edit www/src/main/resources/META-INF/resources/index.xhtml
* Refresh browser


Note: "other" is present just to have a second module in the maven project. It is not used in this example.

