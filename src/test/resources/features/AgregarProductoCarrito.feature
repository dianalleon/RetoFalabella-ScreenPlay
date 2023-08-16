#language:es
Característica: Agregar un producto de forma exitosa al carrito

  @agregarProducto
  Escenario: Usuario agrega Producto al Carrito
    Dado que el usuario abre la aplicacion y busca un producto en la barra de busqueda
    Cuando el usuario selecciona un producto aleatoriamente y da click en agregar al carrito
    Y añade tres unidades y da click en ir al carrito
    Entonces el usuario visualiza su producto en el carrito