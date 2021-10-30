package br.com.caelum.estoque.servico;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

    private Date dataErro;
    private String mensagem;

    public antesInfoFault(String mensagem, Date dataErro) {
        this.mensagem = mensagem;
        this.dataErro = dataErro;
    }

    public InfoFault(String mensagem, Date dataErro) {
        this.mensagem = mensagem;
        this.dataErro = dataErro;
    }

    //JAX-B precisa
    InfoFault() {
    }

}
