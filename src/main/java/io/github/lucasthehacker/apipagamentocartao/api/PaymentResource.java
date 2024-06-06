package io.github.lucasthehacker.apipagamentocartao.api;

import io.github.lucasthehacker.apipagamentocartao.domain.model.entities.CardPayment;
//import io.github.lucasthehacker.apipagamentocartao.domain.model.exceptions.DomainException;
import io.github.lucasthehacker.apipagamentocartao.domain.model.services.Validation;
import io.github.lucasthehacker.apipagamentocartao.api.dto.CardPaymentDto;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
//import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
//import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pagamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class PaymentResource {

    @POST
    @Transactional
    public Response createPaymentAPI(CardPaymentDto cardPaymentDto) {

            CardPayment cardPayment = new CardPayment();

            cardPayment.setTipoPessoa(cardPaymentDto.getTipoPessoa());
            
            cardPayment.setNumeroCartao(cardPaymentDto.getNumeroCartao());
                    
            cardPayment.setcPFCNPJCliente(cardPaymentDto.getcPFCNPJCliente());
            
            cardPayment.setMesVencimentoCartao(cardPaymentDto.getMesVencimentoCartao());

            cardPayment.setAnoVencimentoCartao(cardPaymentDto.getAnoVencimentoCartao());
            
            cardPayment.setcVV(cardPaymentDto.getcVV());

            cardPayment.setValorPagamento(cardPaymentDto.getValorPagamento());

            Validation.personTypeValidation(cardPayment);

            Validation.cardValidationPadronization(cardPayment);

            Validation.cPFCNPJValidationPadronization(cardPayment);

            Validation.cardDateValidation(cardPayment);

            Validation.cVVValidationPadronization(cardPayment);

            Validation.valorPagamentoValidation(cardPayment);

            cardPayment.persist(); 

            return Response.ok(cardPayment).build();

    }

    @GET
    public Response requestPaymentDataAPI() {

        PanacheQuery<CardPayment> query = CardPayment.findAll();;

        return Response.ok(query.list()).build();
    }

    /*@PUT
    @Transactional
    public Response updatePaymentDataAPI() {
        return Response.ok().build();
    }

    @DELETE
    public Response deletePaymentDataAPI() {
        return Response.ok().build();
    }*/
}
