package com.example.MonetaExercise.controller;

import com.example.MonetaExercise.utils.NumberModifierUtil;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/modifyNumber"})
public class NumberModifierController {

    @PutMapping()
    public Long modifyNumber(@RequestBody Long number) {
        return NumberModifierUtil.modifyNumber(number);
    }
}
