package pl.edu.ug.tent.springmvcdemo.validator;

import pl.edu.ug.tent.springmvcdemo.validator.ISBN;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

public class ISBNValidator implements ConstraintValidator<ISBN, String> {
    public void initialize(ISBN constraint) {
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext constraintValidatorContext) {

        isbn = isbn.replace("-", "");
        int waga;
        int suma = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (i % 2 == 0) {
                waga = 1;
            } else{
                waga = 3;
            }
            suma += waga * Integer.parseInt(String.valueOf(isbn.charAt(i)));
        }
        return suma % 10 == 0;
    }


}