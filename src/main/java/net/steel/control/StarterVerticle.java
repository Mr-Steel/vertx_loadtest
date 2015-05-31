package net.steel.control;

import net.steel.http.HttpServer;
import net.steel.http.SpecificLoadClient;
import org.vertx.java.platform.Verticle;

/**
 * Created by Bjoern on 31.05.2015.
 */


public class StarterVerticle extends Verticle {

    public void start() {
        container.logger().info("Start deploying verticles...");
        container.deployVerticle(SpecificLoadClient.class.getName(), 1);
        container.deployVerticle(HttpServer.class.getName(), 1);
    }
}
