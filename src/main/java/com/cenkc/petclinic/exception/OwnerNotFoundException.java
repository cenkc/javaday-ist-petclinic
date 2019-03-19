package com.cenkc.petclinic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * created by cenkc on 3/15/2019
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends RuntimeException {
}
