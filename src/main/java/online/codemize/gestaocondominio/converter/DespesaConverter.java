package online.codemize.gestaocondominio.converter;

import lombok.RequiredArgsConstructor;
import online.codemize.gestaocondominio.domain.Despesa;
import online.codemize.gestaocondominio.domain.enums.StatusDespesa;
import online.codemize.gestaocondominio.dto.DespesaRequest;
import online.codemize.gestaocondominio.oauth.UsuarioAppContext;
import online.codemize.gestaocondominio.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import static online.codemize.gestaocondominio.utils.DateUtils.stringToLocalDate;

@Component
@RequiredArgsConstructor
public class DespesaConverter {

    private final UsuarioAppContext usuarioAppContext;

    public Despesa convert(DespesaRequest request){
        Despesa despesa = new Despesa();
        BeanUtils.copyProperties(request, despesa);

        despesa.setUsuario(usuarioAppContext.getUsuario());
        despesa.setDataVencimento(stringToLocalDate(request.dataVencimento()));
        despesa.setDataPagamento(stringToLocalDate(request.dataPagamento()));
        despesa.setDataCriacao(LocalDateTime.now());
        despesa.setStatus(obterStatusDespesa(despesa));
        return despesa;
    }

    private StatusDespesa obterStatusDespesa(Despesa despesa){
        if(Objects.nonNull(despesa.getDataPagamento()))
            return StatusDespesa.PAGO;

        if(despesa.getDataVencimento().isBefore(LocalDate.now()))
            return StatusDespesa.ATRASADA;

        return StatusDespesa.NAO_PAGO;
    }

}
