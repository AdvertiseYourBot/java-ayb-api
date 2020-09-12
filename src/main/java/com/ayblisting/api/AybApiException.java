package com.ayblisting.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception thrown when the API responds with an error.
 *
 * @author nekokatt
 */
@AllArgsConstructor
@Getter
public class AybApiException extends Exception {
    /**
     * Descriptive error reason.
     */
    private final String reason;

    /**
     * The status code of the response.
     */
    private final int statusCode;

    /**
     * Body of the erroneous response.
     */
    private final Object body;

    @Override
    public String getMessage() {
        return String.format("%s (status: %s, body: %s)", reason, statusCode, body);
    }
}
