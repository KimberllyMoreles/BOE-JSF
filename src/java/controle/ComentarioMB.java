package controle;
import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import modelo.Comentario;

public class ComentarioMB implements Serializable{
    
    Comentario comentario;
    DAO<Comentario> comentarioDAO;
    List<Comentario> lista;
        
    public ComentarioMB() {

    }
    
    @PostConstruct
    public void inicializar(){
        comentarioDAO = new DAO<>("BOEPU");
        comentario = new Comentario();
        this.listar();        
    }
        
    @PreDestroy
    public void fechar(){
        comentarioDAO.close();
    }
 
    public Comentario getComentario() { 
        return comentario;
    }

    public void setComentario(Comentario comentario) {
        this.comentario = comentario;
    }    

    public List<Comentario> getLista() {
        return lista;
    }

    public void setLista(List<Comentario> lista) {
        this.lista = lista;
    }        
    
    public void novo(){
        comentario = new Comentario();
    }
    
    public void salvar() {
        if(comentario.getIdComentario() == null)
            comentarioDAO.insert(comentario);
        else
            comentarioDAO.update(comentario);
        this.listar();
    }
    
    public void editar(Comentario comentario){
        this.comentario = comentario;        
    }
    
    public void excluir(Comentario comentario){
        comentarioDAO.delete(comentario);        
        this.listar();
        this.novo();
    }

    public void listar(){
        lista = comentarioDAO.getAll(Comentario.class, "Comentario.findAll");
    }
}


