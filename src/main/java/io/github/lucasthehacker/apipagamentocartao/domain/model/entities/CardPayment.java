//Mapeamento JPA da entidade PagamentoCartao --> Tabela no Banco de Dados

package io.github.lucasthehacker.apipagamentocartao.domain.model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class CardPayment extends PanacheEntityBase implements AutoCloseable {  //Provedor de opera��es e queries

    @Id //indica��o de PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroPagamento; 

    @Column(name = "NumeroCartao")
    private String numeroCartao;

    @Column(name = "TipoPessoa")
    private Integer tipoPessoa;

    @Column(name = "CPFCNPJCliente")
    private String cPFCNPJCliente;

    @Column(name = "MesVencimentoCartao")
    private Integer mesVencimentoCartao;

    @Column(name = "AnoVencimentoCartao")
    private Integer anoVencimentoCartao;

    @Column(name = "CVV")
    private String cVV;

    @Column(name = "ValorPagamento")
    private String valorPagamento;

    @Column(name = "DataPagamento")
    private String dataPagamento;

    
    public CardPayment() {
        LocalDateTime horaPagamento = LocalDateTime.now();
        DateTimeFormatter formatadorPagamento = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        setDataPagamento(horaPagamento.format(formatadorPagamento));
    }
    
    public String getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(String valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(Integer numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Integer getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Integer tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getcPFCNPJCliente() {
        return cPFCNPJCliente;
    }

    public void setcPFCNPJCliente(String cPFCNPJCliente) {
        this.cPFCNPJCliente = cPFCNPJCliente;
    }

    public Integer getMesVencimentoCartao() {
        return mesVencimentoCartao;
    }

    public void setMesVencimentoCartao(Integer mesVencimentoCartao) {
        this.mesVencimentoCartao = mesVencimentoCartao;
    }

    public Integer getAnoVencimentoCartao() {
        return anoVencimentoCartao;
    }

    public void setAnoVencimentoCartao(Integer anoVencimentoCartao) {
        this.anoVencimentoCartao = anoVencimentoCartao;
    }

    public String getcVV() {
        return cVV;
    }

    public void setcVV(String cVV) {
        this.cVV = cVV;
    }

    
    
    /*public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void cPFCNPJValidationPadronization(CardPayment cardPayment) {
        if (cardPayment.getTipoPessoa() == 1) {
            if (cardPayment.getcPFCNPJCliente().length() > 17) {  //Aceita com espaço no final
                throw new DomainException("CPF is longer than expected");
            }
            String cPFCNPJ = cardPayment.getcPFCNPJCliente().trim().replace(".", "").replace("-", "").replace("/", "").replace(" ", "");
            if (CardPayment.isLong(cPFCNPJ)) {
                cardPayment.setcPFCNPJCliente(cPFCNPJ);
            }
            else {
            throw new DomainException("CPF must be numeric");
            }
            
        }
        else {
            if (cardPayment.getcPFCNPJCliente().length() > 20) {  //Aceita com espaço no final
                throw new DomainException("CNPJ is longer than expected");
            }
            String cPFCNPJ = cardPayment.getcPFCNPJCliente().trim().replace(".", "").replace("-", "").replace("/", "").replace(" ", "");
            if (CardPayment.isLong(cPFCNPJ)) {
                cardPayment.setcPFCNPJCliente(cPFCNPJ);
            }
            else {
                throw new DomainException("CNPJ must be numeric");
            }
        }  
    }

    public static void cardValidationPadronization(CardPayment cardPayment) {
        if (cardPayment.getNumeroCartao().length() > 21) {
            throw new DomainException("Card number is longer than expected");
        }
        String cardNumber = cardPayment.getNumeroCartao().trim().replace(".", "").replace("-", "");
        if (CardPayment.isLong(cardNumber)) {
            cardPayment.setNumeroCartao(cardNumber);
        }
        else {
            throw new DomainException("Card number must be numeric");
        }
        
    }

    public static Integer personTypeValidation(CardPayment cardPayment) {
        if (cardPayment.getTipoPessoa() == 1 || cardPayment.getTipoPessoa() == 2) {
            return cardPayment.getTipoPessoa();
        }
        else {
            throw new DomainException("Person Type must be '1' for PF or '2' for PJ");
        }
    }

    public static void cardDateValidation(CardPayment cardPayment) {
        Integer mes = cardPayment.getMesVencimentoCartao();
        Integer ano = cardPayment.getAnoVencimentoCartao();

        if (ano == 2024) {
            if (mes < LocalDate.now().getMonthValue()) {
                throw new DomainException("Card is expired");
            }
        }
        else if (ano < 2024) {
            throw new DomainException("Card is expired");
        }
    }

    public static String cVVValidationPadronization (CardPayment cardPayment) {
        if (cardPayment.getcVV().length() > 6) {
            throw new DomainException("CVV is longer than expected");
        }
        else {
            String cVV = cardPayment.getcVV().trim();
            if (isLong(cVV)) {
                return cVV;
            }
        }
        throw new DomainException("Unexpected error in CVV");
    }*/


    @Override
    public String toString() {
        return "CardPayment [numeroPagamento=" + numeroPagamento + ", numeroCartao=" + numeroCartao + ", tipoPessoa="
                + tipoPessoa + ", cPFCNPJCliente=" + cPFCNPJCliente + ", mesVencimentoCartao=" + mesVencimentoCartao
                + ", anoVencimentoCartao=" + anoVencimentoCartao + ", cVV=" + cVV + ", valorPagamento=" + valorPagamento
                + ", dataPagamento=" + dataPagamento + ", getValorPagamento()=" + getValorPagamento()
                + ", getDataPagamento()=" + getDataPagamento() + ", getNumeroPagamento()=" + getNumeroPagamento()
                + ", getNumeroCartao()=" + getNumeroCartao() + ", getTipoPessoa()=" + getTipoPessoa()
                + ", getcPFCNPJCliente()=" + getcPFCNPJCliente() + ", getClass()=" + getClass()
                + ", getMesVencimentoCartao()=" + getMesVencimentoCartao() + ", getAnoVencimentoCartao()="
                + getAnoVencimentoCartao() + ", isPersistent()=" + isPersistent() + ", getcVV()=" + getcVV()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroPagamento == null) ? 0 : numeroPagamento.hashCode());
        result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
        result = prime * result + ((tipoPessoa == null) ? 0 : tipoPessoa.hashCode());
        result = prime * result + ((cPFCNPJCliente == null) ? 0 : cPFCNPJCliente.hashCode());
        result = prime * result + ((mesVencimentoCartao == null) ? 0 : mesVencimentoCartao.hashCode());
        result = prime * result + ((anoVencimentoCartao == null) ? 0 : anoVencimentoCartao.hashCode());
        result = prime * result + ((cVV == null) ? 0 : cVV.hashCode());
        result = prime * result + ((valorPagamento == null) ? 0 : valorPagamento.hashCode());
        result = prime * result + ((dataPagamento == null) ? 0 : dataPagamento.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardPayment other = (CardPayment) obj;
        if (numeroPagamento == null) {
            if (other.numeroPagamento != null)
                return false;
        } else if (!numeroPagamento.equals(other.numeroPagamento))
            return false;
        if (numeroCartao == null) {
            if (other.numeroCartao != null)
                return false;
        } else if (!numeroCartao.equals(other.numeroCartao))
            return false;
        if (tipoPessoa == null) {
            if (other.tipoPessoa != null)
                return false;
        } else if (!tipoPessoa.equals(other.tipoPessoa))
            return false;
        if (cPFCNPJCliente == null) {
            if (other.cPFCNPJCliente != null)
                return false;
        } else if (!cPFCNPJCliente.equals(other.cPFCNPJCliente))
            return false;
        if (mesVencimentoCartao == null) {
            if (other.mesVencimentoCartao != null)
                return false;
        } else if (!mesVencimentoCartao.equals(other.mesVencimentoCartao))
            return false;
        if (anoVencimentoCartao == null) {
            if (other.anoVencimentoCartao != null)
                return false;
        } else if (!anoVencimentoCartao.equals(other.anoVencimentoCartao))
            return false;
        if (cVV == null) {
            if (other.cVV != null)
                return false;
        } else if (!cVV.equals(other.cVV))
            return false;
        if (valorPagamento == null) {
            if (other.valorPagamento != null)
                return false;
        } else if (!valorPagamento.equals(other.valorPagamento))
            return false;
        if (dataPagamento == null) {
            if (other.dataPagamento != null)
                return false;
        } else if (!dataPagamento.equals(other.dataPagamento))
            return false;
        return true;
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'close'");
    }
    
}