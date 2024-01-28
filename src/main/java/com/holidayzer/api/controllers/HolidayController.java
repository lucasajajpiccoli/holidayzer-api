package com.holidayzer.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.holidayzer.api.Holiday;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    List<Holiday> holidays = new ArrayList<>();

    HolidayController() {
        fillHolidaysList();
    }

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidays;
    }

    @GetMapping("/{date}")
    public String getHolidayByDate(@PathVariable String date) {
        for(Holiday h: holidays) {
            if(h.getDate().equals(date)) {
                return "Dia " + h.getDate() + " é " + h.getName() + "! 🎉";
            }
        }
        return "Dia " + date + " não é feriado 🥲";
    }

    public void fillHolidaysList() {
    holidays.clear();
    holidays.add(new Holiday("01-01-2024", "Confraternização Mundial"));
    holidays.add(new Holiday("12-02-2024", "Carnaval"));
    holidays.add(new Holiday("13-02-2024", "Carnaval"));
    holidays.add(new Holiday("29-03-2024", "Sexta-feira Santa"));
    holidays.add(new Holiday("21-04-2024", "Tiradentes"));
    holidays.add(new Holiday("01-05-2024", "Dia do Trabalho"));
    holidays.add(new Holiday("30-05-2024", "Corpus Christi"));
    holidays.add(new Holiday("07-09-2024", "Independência do Brasil"));
    holidays.add(new Holiday("12-10-2024", "Nossa Senhora Aparecida"));
    holidays.add(new Holiday("02-11-2024", "Finados"));
    holidays.add(new Holiday("15-11-2024", "Proclamação da República"));
    holidays.add(new Holiday("20-11-2024", "Dia Nacional de Zumbi e da Consciência Negra"));
    holidays.add(new Holiday("25-12-2024", "Natal"));
    }
}
