package spring.openshift.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.openshift.exceptions.NullUserException;
import spring.openshift.exceptions.UpdateUserException;
import spring.openshift.exceptions.UsernameNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UsernameNotFoundException.class})
    protected ResponseEntity<Object> handleUserNotFoundException(UsernameNotFoundException ex) {
        System.err.print("User " + ex.getMessage() + " does not exist in the database!");
        return new ResponseEntity<Object>("User " + ex.getMessage() + " does not exist in the database!",
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = { NullUserException.class})
    protected ResponseEntity<Object> handleNullUserSavingException(NullUserException ex) {
        System.err.print("Null user can not be saved in the database!");
        return new ResponseEntity<Object>("Null user can not be saved in the database!",
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { UpdateUserException.class})
    protected ResponseEntity<Object> handleUpdateUserException(UpdateUserException ex) {
        System.err.print("The user can not be updated with null values!");
        return new ResponseEntity<Object>("The user can not be updated with null values!",
                HttpStatus.BAD_REQUEST);
    }
}
