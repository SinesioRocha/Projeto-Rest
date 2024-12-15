package repositorios;

import entidades.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import utils.JPAUtil;

import java.util.List;

public class ProdutoRepositorio {

    public void salvar(Produto produto){
        EntityManager entityManager = JPAUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            entityManager.getTransaction().commit();
        }catch (PersistenceException exception){
            entityManager.getTransaction().rollback();
            throw new RuntimeException(exception);
        } finally {
            entityManager.close();
        }
    }

    public List<Produto>listar(){
        EntityManager entityManager = JPAUtil.getEntityManager();
        try{
            TypedQuery<Produto> typedQuery = entityManager.createQuery("from Produto p order by p.nome", Produto.class);
            List<Produto> lista = typedQuery.getResultList();
            return  lista;
        }catch (PersistenceException exception){
            throw new RuntimeException(exception);
        }finally {
            entityManager.close();
        }
    }

    public Produto listarPorUUID(String uuid){
        EntityManager entityManager = JPAUtil.getEntityManager();
        try{
            Produto produto = entityManager.find(Produto.class, uuid);
            return produto;
        }catch (PersistenceException exception){
            throw new RuntimeException(exception);
        }finally {
            entityManager.close();
        }
    }

    public void remover(String uuid){
        EntityManager entityManager = JPAUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Produto produto = entityManager.find(Produto.class, uuid);
            if (produto != null) {
                entityManager.remove(produto);
                entityManager.getTransaction().commit();
            }
        }catch (PersistenceException exception){
            throw new RuntimeException(exception);
        } finally {
            entityManager.close();
        }
    }

    public void editar(String uuid, Produto produtoAtualizado){
        EntityManager entityManager = JPAUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();
            Produto produto = entityManager.find(Produto.class, uuid);
            if (produto != null) {
                produto.setNome(produtoAtualizado.getNome());
                produto.setPreco(produtoAtualizado.getPreco());
                produto.setQuantidade(produtoAtualizado.getQuantidade());
                produto.setValidade(produtoAtualizado.getValidade());
                entityManager.getTransaction().commit();
            }
        }catch (PersistenceException exception){
            throw new RuntimeException(exception);
        } finally {
            entityManager.close();
        }
    }


}
