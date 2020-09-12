package com.ayblisting.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


/**
 * Model representing a Category.
 *
 * @author nekokatt
 */
@EqualsAndHashCode(of = {"id"}, callSuper = false)
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public final class Category extends Response {
    /**
     * Category ID.
     */
    @JsonProperty("id")
    private String id;

    /**
     * Category name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * Category slug.
     */
    @JsonProperty("slug")
    private String slug;

    // Internal response details.
    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("success")
    private boolean success;

    @Getter(AccessLevel.PACKAGE)
    @JsonProperty("note")
    private String note;
}
