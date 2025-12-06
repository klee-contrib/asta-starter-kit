package kleecontrib.asta.configuration.web;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.BadRequestException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handler générique des erreurs fonctionnelles.
     *
     * @param request
     * @param exception
     * @return
     */
    @ExceptionHandler({NoSuchElementException.class, BadRequestException.class, BadRequestException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail handleBadRequest(HttpServletRequest request, RuntimeException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        var probleDetail = ProblemDetail.forStatusAndDetail(status, "Erreur lors de la validation des champs");
        var errors = new HashMap<String, Object>();

        var fieldErrors = ex.getBindingResult().getFieldErrors().stream().collect(Collectors.groupingBy(FieldError::getField, Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())));
        var globalErrors = ex.getBindingResult().getGlobalErrors().stream().collect(Collectors.groupingBy(ObjectError::getObjectName, Collectors.mapping(ObjectError::getDefaultMessage, Collectors.toList())));

        errors.putAll(fieldErrors);
        errors.putAll(globalErrors);

        probleDetail.setProperty("errors", errors);
        return new ResponseEntity<>(probleDetail, status);
    }
}
