package com.ayblisting.api;

import lombok.AccessLevel;
import lombok.Getter;


/**
 * Response wrapper.
 *
 * @author nekokatt
 */
@Getter(AccessLevel.PACKAGE)
public abstract class Response {
    abstract boolean isSuccess();
    abstract String getNote();
}
