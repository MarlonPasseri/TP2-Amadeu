package br.com.exemplo.crud.controller;

import br.com.exemplo.crud.exception.RecursoNaoEncontradoException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public String tratarRecursoNaoEncontrado(RecursoNaoEncontradoException ex, Model model) {
        model.addAttribute("mensagemErro", ex.getMessage());
        return "erro";
    }

    @ExceptionHandler(Exception.class)
    public String tratarErroGenerico(Exception ex, Model model) {
        model.addAttribute("mensagemErro", "Ocorreu um erro inesperado. Tente novamente.");
        return "erro";
    }
}
