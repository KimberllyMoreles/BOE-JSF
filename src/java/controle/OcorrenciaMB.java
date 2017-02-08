package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Comentario;
import modelo.Ocorrencia;

@ManagedBean
@ViewScoped
public class OcorrenciaMB implements Serializable
{
    Ocorrencia ocorrencia;
    Comentario comentario;
    DAO<Ocorrencia> ocorrenciaDAO;
    DAO<Comentario> comentarioDAO;
    List<Ocorrencia> ocorrencias;
    List<Comentario> comentarios;
    boolean exibirComentarios = false;

    public OcorrenciaMB()
    {
    }

    @PostConstruct
    public void inicializar()
    {
        ocorrenciaDAO = new DAO<>();
        comentarioDAO = new DAO<>();
        ocorrencia = new Ocorrencia();
        comentario = new Comentario();
        this.listar();
    }

    @PreDestroy
    public void fechar()
    {
        ocorrenciaDAO.close();
    }
    
    public boolean getExibirComentarios()
    {
        return exibirComentarios;
    }

    public Ocorrencia getOcorrencia()
    {
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia)
    {
        this.ocorrencia = ocorrencia;
    }

    public List<Ocorrencia> getOcorrencias()
    {
        return ocorrencias;
    }

    public void setOcorrencias(List<Ocorrencia> ocorrencias)
    {
        this.ocorrencias = ocorrencias;
    }

    public void novo()
    {
        this.ocorrencia = new Ocorrencia();
        this.comentario = new Comentario();         
            this.exibirComentarios = false;
    }

    public void salvar()
    {
        if (ocorrencia.getIdOcorrencia() == null)
        {
            ocorrenciaDAO.insert(ocorrencia);
            this.comentario.setIdOcorrencia(ocorrencia);
            this.comentarios = (List) ocorrencia.getComentarioCollection();
            this.exibirComentarios = true;
        } else
        {
            ocorrenciaDAO.update(ocorrencia);
        }
        this.listar();
    }

    public void editar(Ocorrencia ocorrencia)
    {
        this.ocorrencia = ocorrencia;   
        this.comentario.setIdOcorrencia(ocorrencia);
        this.comentarios = (List) ocorrencia.getComentarioCollection();
        this.exibirComentarios = true;
    }

    public void excluir(Ocorrencia ocorrencia)
    {
        ocorrenciaDAO.delete(ocorrencia);
        this.listar();
        this.novo();
    }

    public void listar()
    {
        ocorrencias = ocorrenciaDAO.getAll(Ocorrencia.class, "Ocorrencia.findAll");
    }
    
    
    /// --------------- COMENTARIOS
     public Comentario getComentario()
    {
        return comentario;
    }

    public void setComentario(Comentario comentario)
    {
        this.comentario = comentario;
    }

    public List<Comentario> getComentarios()
    {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios)
    {
        this.comentarios = comentarios;
    }

    public void novoComentario()
    {
        this.comentario = new Comentario();        
        this.comentario.setIdOcorrencia(ocorrencia);
    }

    public void salvarComentario()
    {
        comentarioDAO.insert(comentario);
        this.novoComentario();
        this.listarComentarios();
    }

    public void listarComentarios()
    {
        comentarios = comentarioDAO.getAll(Comentario.class, "Comentario.findAll");
    }
}
