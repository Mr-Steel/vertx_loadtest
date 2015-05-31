package net.steel.http;

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.EventBus;
import org.vertx.java.core.http.HttpClient;
import org.vertx.java.core.http.HttpClientResponse;
import org.vertx.java.platform.Verticle;

/**
 * Created by Bjoern on 31.05.2015.
 */
public class SpecificLoadClient extends Verticle {

    private static final int MAX_CONNS = 100;
    private HttpClient httpClient;
    EventBus eventbus;


    @Override
    public void start() {
        eventbus = vertx.eventBus();
        httpClient = vertx.createHttpClient().setPort(8080).setHost("localhost").setMaxPoolSize(MAX_CONNS);
        makeRequest();
    }

    private void loadGenerator() {
        //100 per second
        vertx.setPeriodic(10, event -> makeRequest());
    }

    private void makeRequest() {
        httpClient.getNow("/", new Handler<HttpClientResponse>() {
            @Override
            public void handle(HttpClientResponse event) {

            }
        });
    }
}
