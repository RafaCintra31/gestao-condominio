package online.codemize.gestaocondominio.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private final static String FORMATO_DATA_PADRAO = "dd/MM/yy";

    public static LocalDate stringToLocalDate(String date){
        if (StringUtils.isBlank(date)) return null;
        var dateFormatter = DateTimeFormatter.ofPattern(FORMATO_DATA_PADRAO);
        return LocalDate.parse(date, dateFormatter);
    }

}
