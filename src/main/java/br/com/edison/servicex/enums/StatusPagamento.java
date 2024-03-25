package br.com.edison.servicex.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;


@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusPagamento {

    PENDENTE ("P", "Pendente"),
    QUITADO("Q", "Quitado"),
    CANCELADO("C", "Cancelado");

    @Setter
    @Getter
    @JsonValue
    private String  codigo;

    @Setter
    @Getter
    private String descricao;


    private StatusPagamento(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    @JsonCreator
    public static StatusPagamento doValor(String codigo){
        if(codigo.equals("Q")){
            return QUITADO;
        } else if (codigo.equals("P")) {
            return PENDENTE;
        } else if (codigo.equals("C")) {
            return CANCELADO;
        }else{
            return null;
        }
    }

}
