package com.ayblisting.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * Basic RESTful client for interacting with the AYB API synchronously.
 *
 * @author nekokatt
 */
@Slf4j
public final class RestClient {
    private static final String API_HOST = "api.ayblisting.com";
    private static final String ACCEPT = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final long TIMEOUT = 5_000;

    private final OkHttpClient okHttpClient;
    private final ObjectMapper objectMapper;

    /**
     * Create a default client.
     */
    public RestClient() {
        this(new OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS));
    }

    /**
     * Create a client from a given {@link OkHttpClient.Builder} instance.
     *
     * @param clientBuilder the client builder to use.
     */
    public RestClient(final OkHttpClient.Builder clientBuilder) {
        okHttpClient = clientBuilder.build();
        objectMapper = new ObjectMapper();
    }

    /**
     * Fetch a bot by it's given ID.
     *
     * @return the overall site statistics.
     * @throws IOException     if the request fails.
     * @throws AybApiException if the API returns an erroneous response.
     */
    public OverallSiteStats fetchStats() throws IOException, AybApiException {
        return makeRequest(
            urlBuilder()
                .addPathSegment("stats")
                .build(),
            OverallSiteStats.class
        );
    }

    /**
     * Fetch a category by it's given ID.
     *
     * @param categoryId the ID of the category to get.
     * @return the category object.
     * @throws IOException     if the request fails.
     * @throws AybApiException if the API returns an erroneous response.
     */
    public Category fetchCategory(final long categoryId) throws IOException, AybApiException {
        return makeRequest(
            urlBuilder()
                .addPathSegment("category")
                .addQueryParameter("id", String.valueOf(categoryId))
                .build(),
            Category.class
        );
    }

    /**
     * Fetch a bot by it's given ID.
     *
     * @param botId the ID of the bot to get.
     * @return the bot object.
     * @throws IOException     if the request fails.
     * @throws AybApiException if the API returns an erroneous response.
     */
    public Bot fetchBot(final String botId) throws IOException, AybApiException {
        return makeRequest(
            urlBuilder()
                .addPathSegment("bot")
                .addQueryParameter("id", botId)
                .build(),
            Bot.class
        );
    }

    private HttpUrl.Builder urlBuilder() {
        return new HttpUrl.Builder().scheme("https").host(API_HOST);
    }

    private <T extends Response> T makeRequest(final HttpUrl httpUrl, final Class<T> type) throws IOException, AybApiException {
        log.info("GET {}", httpUrl);

        val request = new Request.Builder()
            .get().url(httpUrl)
            .addHeader(ACCEPT, APPLICATION_JSON)
            .build();

        try (val response = okHttpClient.newCall(request).execute()) {
            log.info("{} {} response for {}", response.protocol(), response.code(), httpUrl);

            val body = response.body();
            if (body == null) {
                throw new AybApiException("Got an empty response", response.code(), null);
            }

            if (!response.isSuccessful()) {
                throw new AybApiException(response.toString(), response.code(), body.string());
            }

            val responseEntity = objectMapper.readValue(body.byteStream(), type);
            if (!responseEntity.isSuccess()) {
                throw new AybApiException(responseEntity.getNote(), response.code(), responseEntity);
            }

            return responseEntity;
        }
    }
}
