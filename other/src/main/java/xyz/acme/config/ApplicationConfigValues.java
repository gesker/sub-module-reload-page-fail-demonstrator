package xyz.acme.config;

import io.quarkus.runtime.StartupEvent;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.jboss.logging.Logger;

@Named
@Singleton
public class ApplicationConfigValues {

  private static final Logger LOGGER = Logger.getLogger(ApplicationConfigValues.class.getName());

  void startup(@Observes StartupEvent event) {
    LOGGER.info("Eager Load @Singleton " + this.getClass().getName());
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
