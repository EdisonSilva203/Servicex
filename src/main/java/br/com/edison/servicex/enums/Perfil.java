package br.com.edison.servicex.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Perfil {

    CLIENTE("C" , "Cliente"),
    ADMIN("A", "Admin");

    @Getter
    @Setter
    @JsonValue
    private String codigo;

    @Getter
    @Setter
    private String descricao;

    private Perfil(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @JsonCreator
    public static Perfil doValor(String codigo){
        if(codigo.equals("C")){
            return CLIENTE;
        } else if (codigo.equals("A")) {
            return ADMIN;
        }else{
            return null;
        }
    }
}
