package com.cgi.dentistapp.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by jantr_000 on 16.04.2017.
 */
public class DentistDTO {

    @Size(min = 1, max = 50)
    String dentistName;

    @NotNull
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    Date visitTime;

    public DentistDTO() {
    }
}
