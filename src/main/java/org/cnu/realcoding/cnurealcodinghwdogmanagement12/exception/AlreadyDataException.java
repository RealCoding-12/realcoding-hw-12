package org.cnu.realcoding.cnurealcodinghwdogmanagement12.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyDataException extends RuntimeException {
}

