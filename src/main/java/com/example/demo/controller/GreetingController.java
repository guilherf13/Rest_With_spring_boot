package com.example.demo.controller;

import com.example.demo.convert.number.ConvertNumber;
import com.example.demo.exception.UnsupportedOperationMathException;
import com.example.demo.math.CalcMathBase;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static com.example.demo.convert.number.ConvertNumber.convertDouble;

@RestController
public class GreetingController {

    CalcMathBase math = new CalcMathBase();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!ConvertNumber.isNumber(numberOne) || !ConvertNumber.isNumber(numberTwo)){
            throw new UnsupportedOperationMathException("Invalido numero informado");
        }
        return math.sum(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!ConvertNumber.isNumber(numberOne) || !ConvertNumber.isNumber(numberTwo)){
            throw new UnsupportedOperationMathException("Invalido numero informado");
        }
        return math.sub(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mult(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!ConvertNumber.isNumber(numberOne) || !ConvertNumber.isNumber(numberTwo)){
            throw new UnsupportedOperationMathException("Invalido numero informado");
        }
        return math.mult(ConvertNumber.convertDouble(numberOne), ConvertNumber.convertDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws Exception {
        if(!ConvertNumber.isNumber(numberOne) || !ConvertNumber.isNumber(numberTwo)){
            throw new UnsupportedOperationMathException("Invalido numero informado");
        }
        return math.div(convertDouble(numberOne), convertDouble(numberTwo));
    }



}
