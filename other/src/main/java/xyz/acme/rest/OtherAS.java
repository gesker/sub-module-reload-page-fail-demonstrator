package xyz.acme.rest;

import io.smallrye.mutiny.Uni;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.time.Instant;

import org.jboss.logging.Logger;

@Path("/other")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class OtherAS {
  private static final Logger LOGGER = Logger.getLogger(OtherAS.class.getName());

  @PostConstruct
  public void initialize() {
    LOGGER.debug(this.getClass().getName() + " initialized.");
  }

  @PreDestroy
  public void terminate() {
    LOGGER.debug(this.getClass().getName() + " terminated.");
  }

  @GET
  @Path("unix-time")
  public Uni<Long> getUnixTime() {
    return Uni.createFrom().item(Instant.now().getEpochSecond());
  }
}
