package com.db.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Signal ID Not Configured")
public class SignalNotFoundException extends RuntimeException{
}
