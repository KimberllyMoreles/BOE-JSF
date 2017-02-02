package controle;
import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import modelo.Ocorrencia;

public class OcorrenciaMB implements Serializable{
    
    Ocorrencia ocorrencia;
    DAO<Ocorrencia> ocorrenciaDAO;
    List<Ocorrencia> lista;
        
    public OcorrenciaMB() {

    }
    
    @PostConstruct
    public void inicializar(){
        ocorrenciaDAO = new DAO<>("BOEPU");
        ocorrencia = new Ocorrencia();
        this.listar();        
    }
        
    @PreDestroy
    public void fechar(){
        ocorrenciaDAO.close();
    }
 
    public Ocorrencia getOcorrencia() { 
        return ocorrencia;
    }

    public void setOcorrencia(Ocorrencia ocorrencia) {
        this.ocorrencia = ocorrencia;
    }    

    public List<Ocorrencia> getLista() {
        return lista;
    }

    public void setLista(List<Ocorrencia> lista) {
        this.lista = lista;
    }        
    
    public void novo(){
        ocorrencia = new Ocorrencia();
    }
    
    public void salvar() {
        if(ocorrencia.getIdOcorrencia() == null)
            ocorrenciaDAO.insert(ocorrencia);
        else
            ocorrenciaDAO.update(ocorrencia);
        this.listar();
    }
    
    public void editar(Ocorrencia ocorrencia){
        this.ocorrencia = ocorrencia;        
    }
    
    public void excluir(Ocorrencia ocorrencia){
        ocorrenciaDAO.delete(ocorrencia);        
        this.listar();
        this.novo();
    }

    public void listar(){
        lista = ocorrenciaDAO.getAll(Ocorrencia.class, "Ocorrencia.findAll");
    }
}


