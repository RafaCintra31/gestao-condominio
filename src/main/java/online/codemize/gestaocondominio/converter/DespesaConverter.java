package online.codemize.gestaocondominio.converter;

import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class DespesaConverter {

    private final static String FORMATO_DATA_PADRAO = "dd/MM/yy";

    public Despesa convert(DespesaRequest request){
        Despesa despesa = new Despesa();
        BeanUtils.copyProperties(request, despesa);

        despesa.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        despesa.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        despesa.setDataCriacao(LocalDateTime.now());
        despesa.setStatus(obterStatusDespesa(despesa));
        return despesa;
    }

    private LocalDate stringToLocalDate(String date){
        if (StringUtils.isBlank(date)) return null;
        var dateFormatter = DateTimeFormatter.ofPattern(FORMATO_DATA_PADRAO);
        return LocalDate.parse(date, dateFormatter);
    }

    private StatusDespesa obterStatusDespesa(Despesa despesa){
        if(Objects.nonNull(despesa.getDataPagamento()))
            return StatusDespesa.PAGO;

        if(despesa.getDataVencimento().isBefore(LocalDate.now()))
            return StatusDespesa.ATRASADA;

        return StatusDespesa.NAO_PAGO;
    }

}
