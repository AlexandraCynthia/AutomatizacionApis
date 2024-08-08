package com.nttdata.glue;

import com.nttdata.steps.OrderStep;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderStepDef {

    @Steps
    OrderStep order;

    @When("creo una orden con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string} y complete {boolean}")
    public void creoUnaOrdenConDatos(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        order.crearOrden(id, petId, quantity, shipDate, status, complete);
    }

    @Then("el codigo de respuesta es {int}")
    public void elCodigoDeRespuestaEs(int statusCode) {
        order.verificarCodigoRespuesta(statusCode);
    }

    @Then("la orden creada tiene id {int}, petId {int}, quantity {int}, shipDate {string}, status {string} y complete {boolean}")
    public void laOrdenCreadaTieneDatos(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        order.verificarDatosOrden(id, petId, quantity, shipDate, status, complete);
    }
}
