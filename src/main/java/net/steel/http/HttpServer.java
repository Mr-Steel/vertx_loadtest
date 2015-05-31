package net.steel.http;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.platform.Verticle;

/**
 * Created by Bjoern on 31.05.2015.
 */
public class HttpServer extends Verticle {

    public void start() {
        vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
            public void handle(final HttpServerRequest req) {
                // Just return OK
                req.response().end();
            }
        }).listen(8080, "localhost");
    }
}