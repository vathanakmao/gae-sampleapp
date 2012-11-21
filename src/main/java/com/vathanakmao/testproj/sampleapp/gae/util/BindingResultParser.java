package com.vathanakmao.testproj.sampleapp.gae.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class BindingResultParser {

    private static final String ERROR_TYPE_MISMATCH_LONG = "must be an integer";

    public static ArrayList<String> toListOfStrings(BindingResult bindingResult) {
        ArrayList<String> errors = new ArrayList<String>();

        List<ObjectError> bindingErrors = bindingResult.getAllErrors();

        if (!bindingErrors.isEmpty()) {
            for(ObjectError error : bindingErrors) {

                StringBuffer msg = new StringBuffer();

                if (error instanceof FieldError) {
                    FieldError fieldError = ((FieldError) error);

                    if (error.getCode().startsWith("typeMismatch")
                            && (bindingResult.getFieldType(fieldError.getField()).equals(Long.class) || bindingResult
                                    .getFieldType(fieldError.getField()).equals(Integer.class))) {

                        msg.append(ERROR_TYPE_MISMATCH_LONG);
                        errors.add(msg.toString());
                        continue;
                    }
                }

                msg.append(error.getDefaultMessage());
                errors.add(msg.toString());
            }
        }

        return errors;
    }
}
