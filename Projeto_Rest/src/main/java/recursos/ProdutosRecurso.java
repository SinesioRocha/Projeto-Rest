package recursos;

import entidades.Produto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.message.internal.MediaTypes;
import repositorios.ProdutoRepositorio;

import java.util.List;

@Path("/Produtos")
public class ProdutosRecurso {
    private ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar(){
        List<Produto> lista = produtoRepositorio.listar();
        return lista;
    }

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto listarPorUUID(@PathParam("uuid") String uuid){
        Produto produto = produtoRepositorio.listarPorUUID(uuid);
        return produto;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserirNovoProduto(Produto produto){
        produtoRepositorio.salvar(produto);
    }


    @DELETE
    @Path("/{uuid}")
    public void removerProduto(@PathParam("uuid") String uuid){
        produtoRepositorio.remover(uuid);
    }

    @PUT
    @Path("/{uuid}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarProduto(@PathParam("uuid") String uuid, Produto produtoAtualizado){
        produtoRepositorio.editar(uuid, produtoAtualizado);
    }
}
