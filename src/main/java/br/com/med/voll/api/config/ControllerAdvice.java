package br.com.med.voll.api.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> NotFoundException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity BadRequestException(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(erros.stream().map(CampoErroValidacao::new).toList());
    }

    private record CampoErroValidacao(String campo, String erro) {
        public CampoErroValidacao(FieldError erros) {
            this(erros.getField(), erros.getDefaultMessage());
        }
    }
}

