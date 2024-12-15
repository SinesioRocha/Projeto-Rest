package recursos;

import entidades.Produto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import repositorios.ProdutoRepositorio;

@Path("/calculadoras")
public class CalculadorRecursos {

    @Path("/somar/{a}/{b}")
    @GET
    public double somar(@PathParam("a") double x, @PathParam("b") double y){
        double resultado = x + y;
        return resultado;
    }
}
