package ru.springboot.ripper.demo;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Should wrap all responses for this controller with {@code result} node
 */
@Retention(RetentionPolicy.RUNTIME)
@RestController
public @interface FrontendController {
}
