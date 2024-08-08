package com.nttdata.steps;

import com.nttdata.model.Order;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;

public class OrderStep {

    private static String URL = null;
    Response response;

    @Step
    public void definirUrl(String url) {
        URL = url;
    }

    @Step
    public void crearOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        String requestBody = String.format("{\n" +
                "  \"id\": %d,\n" +
                "  \"petId\": %d,\n" +
                "  \"quantity\": %d,\n" +
                "  \"shipDate\": \"%s\",\n" +
                "  \"status\": \"%s\",\n" +
                "  \"complete\": %b\n" +
                "}", id, petId, quantity, shipDate, status, complete);

        response =
                given()
                        .contentType("application/json")
                        .body(requestBody)
                        .post(URL + "/store/order");
    }

    @Step
    public void verificarCodigoRespuesta(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Step
    public void verificarDatosOrden(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        Order order = response.jsonPath().getObject("", Order.class);
        assert order.getId() == id;
        assert order.getPetId() == petId;
        assert order.getQuantity() == quantity;
        assert order.getShipDate().equals(shipDate);
        assert order.getStatus().equals(status);
        assert order.isComplete() == complete;
    }
}
