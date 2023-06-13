package xyz.acme.config;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Named;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.jboss.logging.Logger;

@Startup
@QuarkusMain
@ApplicationPath("/")
@Named
@ApplicationScoped
public class ApplicationActivatorAS extends Application {
  private static final Logger LOGGER = Logger.getLogger(ApplicationActivatorAS.class.getName());

  public static void main(String[] args) {
    System.out.println("Running Quarkus main method");
    Quarkus.run(args);
  }

  void onStart(@Observes StartupEvent ev) {
    LOGGER.info("The application is starting...");
    LOGGER.info("Quarkus Launch Mode: " + io.quarkus.runtime.LaunchMode.current());
    System.setProperty("user.timezone", "UTC");
    LOGGER.info("Quarkus Account.timezone set to UTC");
  }

  void onStop(@Observes ShutdownEvent ev) {
    LOGGER.info("The application is stopping...");
  }

  @PostConstruct
  public void initialize() {
    LOGGER.debug(this.getClass().getName() + " initialized.");
  }

  @PreDestroy
  public void terminate() {
    LOGGER.debug(this.getClass().getName() + " terminated.");
  }
}
