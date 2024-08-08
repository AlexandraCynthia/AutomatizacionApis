Feature: Gestión de Orders

  @crearYConsultarOrden
  Scenario: Crear y consultar una orden
    Given la url "https://petstore.swagger.io/v2" del servicio
    When creo una orden con id 1, petId 101, quantity 2, shipDate "2024-08-08T03:55:06.769Z", status "placed" y complete true
    And consulto la orden con el id 1
    Then el código de respuesta es 200
    And la orden creada tiene id 1, petId 101, quantity 2, shipDate "2024-08-08T03:55:06.769Z", status "placed" y complete true
