@LoginLinio
  Feature: Login and Shopping Cart Linio

    Scenario: Login in Linio
    Given the url "https://www.linio.com.pe/account/login"
    When fill the email input with the email "xxwelslskstvilxgtm@nvhrw.com"
    And fill the password input with the password "linio!1234"
    And click the login button
    Then the login must be successful, header profile username must be "Romulo"
    And click in the compra y recibe hoy button
    And Add product to the cart
    Then Check message "Tu producto se agregó al carrito" if the product was added to the cart