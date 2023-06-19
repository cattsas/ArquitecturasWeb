@Dataprovider
public object[] ingridientePrueba(){
        ingrediente in1= new ingrediente(harina , kg, ranfdom()*100);
        ingrediente in1= new ingrediente(pan , kg, 10);
        ingrediente in1= new ingrediente(polenta , kg, 1);
        array <ingrediente> arreglo = new array();
        arreglo.add(in1);
        arreglo.add(in2);
        arreglo.add(int3);
        return arreglo;
        }

@dataprovider
public object[] recetaPrueba(){
    receta r1 = new receta (ingrediente in1= new ingrediente(harina , kg, ranfdom()*100),
        ingrediente in1= new ingrediente(pan , kg, math.random()*100),
        ingrediente in1= new ingrediente(polenta , kg, math.random()*100))

return r1;
        }

        5. Pruebe la funcionalidad que permita testear que el precio de venta unitario es
        siempre mayor al precio de venta unitario

@test(description="test precio mayor", dataprovider="listadoProductos" )
public void test_producto_precio_unitario_mayor (){
    assert.assertrue (p1.getPrecioUnitario()>p1.gertprecioMayorista())
        }

        6. Pruebe la funcionalidad que permita testear que la ganancia de cada producto es
        siempre mayor a un parámetro dado
@test (description="test_precio mayor a ganancia", dataprovider="listadoProductos")
public void test_ganacia(int valor v){
    int i =0;
    while(i< listadoproductos.length() ){
        assert.asserttrue(listadoproductos[i].getGanancia()>v);
        i++;
    }
}

        7. Pruebe si es posible descontar cantidades de ingredientes aun cuando esta cantidad
        es < 0. ¿Como se actuaría ante esta situación?
@test (description="test_descontar_menor_a_cero", dataprovider="ingrediente")
public void test_ingrediente_cantidad_negativa(int resta){

    assert.asserthrow(exception cantidadnegativa.class, ()->{boolean b = ingrediente.restarCantidad(resta)<0;}, "resta cuando la cantidad es cero");
        }

