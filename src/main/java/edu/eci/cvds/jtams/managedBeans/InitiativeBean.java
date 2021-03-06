package edu.eci.cvds.jtams.managedBeans;

import edu.eci.cvds.jtams.exceptions.JtamsExceptions;
import edu.eci.cvds.jtams.model.Comment;
import edu.eci.cvds.jtams.model.Initiative;
import edu.eci.cvds.jtams.model.User;
import edu.eci.cvds.jtams.services.CommentServices;
import edu.eci.cvds.jtams.services.InitiativeServices;
import edu.eci.cvds.jtams.services.InitiativeServicesFactory;
import edu.eci.cvds.jtams.services.UserServices;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "InitiativeBean")
@SessionScoped
public class InitiativeBean {

	
	//@Inject
	//private InitiativeServices Service;
	private static final long serialVersionUID = 3594009161252782831L;
	
	private InitiativeServices initiativeService = InitiativeServicesFactory.getInstance().getInitiativeServices();
	private UserServices userServices = InitiativeServicesFactory.getInstance().getUserServices();
	private CommentServices commentService = InitiativeServicesFactory.getInstance().getCommentServices();
	//private CommentServices commentServices = InitiativeServicesFactory.getInstance().getCommentServices();
	
	private String name;
	private String description ;
	private String area ;
	private String keyword="";
	private String estado="";
	private String initiativeToUpdate;
	private String statusToUpdate;
	private String namenuevo;
	private String descripcion ;
	private String area2 ;
	private Initiative idEdit;
	private List<Initiative> iniciativaPorPalabra;
    private List<Initiative> iniciativaPorArea;
	private List<Initiative> listaIniciativas;
	private List<Initiative> listaIniciativasProponente;
	private List<Initiative> listaIniciativasParaAgrupar;
	private List<Initiative> iniciativasAgrupadasFront;
	private List<Comment> comentarios;
	private List<User> listaUsuarios;
	private  String palabra;
	private int idInitiativelike;
	private int idInitiativeDislike;
	private Initiative selectedInitiative;
	private List<Integer> agruparIniciativasList;
	private int idIniciativa;
	private int idUser;

	private int idInitiative;
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		
		this.idUser = idUser;
	}
	public int getIdInitiative() {
		return idInitiative;
	}

	public void setIdInitiative(int idInitiative) {
		
		this.idInitiative = idInitiative;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		
		this.estado = estado;
	}
	 public List<Integer> getAgruparIniciativasList(){
		 return agruparIniciativasList;
	 }
	 public void getAgruparIniciativasList( List<Integer> agruparIniciativasList){
		this.agruparIniciativasList=agruparIniciativasList;
	 }
	 
	 
	 public List<Initiative> getlistaIniciativasParaAgrupar() {
	        return listaIniciativasParaAgrupar;
	    }
	 
	    public void setlistaIniciativasParaAgrupar(List<Initiative> i) {
	        this.listaIniciativasParaAgrupar = i;
	        this.iniciativasAgrupadasFront=i;
	    }
	    
	public String getName() {
		return name;
	}
	
	 public List<Initiative> getIniciatiaPorPalabra() {
	        return iniciativaPorPalabra;
	    }
	 
	 public void setIniciativasPorPalabra(List<Initiative> iniciativaPorPalabra) {
	        this.iniciativaPorPalabra = iniciativaPorPalabra;
	    }
	 
	public void setName(String name) {
		this.name = name;
	}
	public String getPalabra() {
		return name;
	}

	public void setPalabra(String palabran) {
		
		this.palabra = palabran;
	}
	public InitiativeServices getInitiativeService() {
		return initiativeService;
	}

	public void setInitiativeService(InitiativeServices initiativeService) {
		this.initiativeService = initiativeService;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription( String description) {
		this.description =  description;
	}
	public String getArea() {
		return area;
	}
	public void setArea( String area) {
		this.area = area;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword( String keyword) {
		this.keyword = keyword;
	}


    public List<Initiative> buscaAreaIniciativas() throws JtamsExceptions{

        try {

            this.iniciativaPorArea = initiativeService.buscaAreaIniciativa(area);

            return  iniciativaPorArea;

        } catch (JtamsExceptions ex){

            throw new JtamsExceptions("No se encuentran iniciativas con ese tipo de estado");
        }
    }

	 /**
     * Busca todas las inciativas con un Estado en especifico
     *
     * @return Lista de iniciativas
     */

	public List<Initiative> buscaEstadoIniciativas() throws JtamsExceptions{
		
		try {
		       
            this.iniciativaPorPalabra = initiativeService.buscaEstadoIniciativa(estado);
            
            return  iniciativaPorPalabra;
       } catch (JtamsExceptions ex){
            throw new JtamsExceptions("No se encuentran iniciativas con ese tipo de estado");
       }
	}
	/**
     * Busca todas las inciativas por palabras clave
     *
     * @return Lista de iniciativas 
     */
	
	public List<Initiative> buscainiciativa() throws JtamsExceptions{
		
		try {
			List<String> palabrasListas = Arrays.asList(keyword.split(",")); 
			if(this.iniciativaPorPalabra==null) {this.iniciativaPorPalabra=initiativeService.buscainiciativaporpalabra(palabrasListas);}
			else {
				this.iniciativaPorPalabra = initiativeService.buscainiciativaporpalabra(palabrasListas);
			}
            
      
            return  iniciativaPorPalabra;
       } catch (JtamsExceptions ex){
            throw new JtamsExceptions("No se encuentran iniciativas con esas palabras clave");
       }
	}
	/**
     * Busca todas las iniciativas
     *
     * @return Lista de iniciativas 
     */
	public List<Initiative> Todasiniciativas() throws JtamsExceptions{
		try {
            if(listaIniciativas == null){
            	listaIniciativas = initiativeService.dariniciativas();
            }
       
            return listaIniciativas;
        } catch (JtamsExceptions ex) {
            throw ex;
        }
		
		
	}
	/**
     * Registra una nueva iniciativa
     */

	public void createIntitiative() throws JtamsExceptions {
		java.sql.Date fecha = new java.sql.Date(System.currentTimeMillis());
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

		List<String> keywords= Arrays.asList(keyword.split(",")); 
		List<Integer> votos= Arrays.asList(); 
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String email = currentUser.getPrincipal().toString();
			ponerId(email);
			initiativeService.createInitiative(description, area,idUser, keywords, email);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos han sido guardados con exito"));
			updateTabla();
		}catch (JtamsExceptions ex) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Existio un error al guardar","Error"));
			throw ex;
		}
	}
	/**
     * Agrupa Iniciativas relacionadas
     */
	
	 public void agregarIniciativaRelacionadaAIniciativa() throws JtamsExceptions{
		
			
			try {
				
		        for (int i = 0; i < listaIniciativasParaAgrupar.size(); i++) {
				    for(int j = 0; j < listaIniciativasParaAgrupar.size(); j++){
				        if(i != j){
				        	//System.out.println(listaIniciativasParaAgrupar.get(i).getId());
				        	initiativeService.agregarIniciativaRelacionadaAIniciativa(listaIniciativasParaAgrupar.get(i).getId(),listaIniciativasParaAgrupar.get(j).getId());
				        }
				    }
				}
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agruparon las iniciativas correctamente"));
		    }catch(JtamsExceptions ex) {
		    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"error al insertar, puede que ya este relacionada, o no se encuentre el id","Error"));
				throw ex;
		    }
		 }
	 
	 /**
	  * Busca una nueva iniciativa relacionada a la obtenida
	  * 
	  * @return Lista de iniciativas 
	  */
	 public List<Initiative> buscaIniciativaRelacionadas() throws JtamsExceptions{
		 updateTabla();

			try {
					//System.out.println(idIniciativa+"  --- este fue el numero ingresado");
		            List<Initiative> iniciativasAgrupadasFront= initiativeService.busaIniciativaRelacionadas(idIniciativa);
		            //inicia machete <3 :) 
		            for(int i=0; i < listaIniciativas.size(); i++) {
		            	if(listaIniciativas.get(i).getId()==idIniciativa) {
		            		iniciativasAgrupadasFront.add(listaIniciativas.get(i));
		            	}
		            }
		            return  iniciativasAgrupadasFront;
		      } catch (JtamsExceptions ex){
		            throw new JtamsExceptions("No se encuentran iniciativas relacionadas");
		       }
			}
		 
	 
	
	


	public int getIdIniciativa() {
		return idIniciativa;
	}
	public void setIdIniciativa(int idIniciativa) throws JtamsExceptions {
		this.idIniciativa = idIniciativa;
		buscaIniciativaRelacionadas();
	}
	 /**
	  * Actualiza Una iniciativa por su numero ID
	  * 
	  */
	public void updateStatusInitiative(){
		this.initiativeToUpdate=String.valueOf(selectedInitiative.getId());
		try {
			initiativeService.updateStatusInitiative(initiativeToUpdate, statusToUpdate);
			listaIniciativas = initiativeService.dariniciativas();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El estado ha sido actualizado con exito"));
			//System.out.println("cambio estado");
			
			
		}catch(JtamsExceptions e){
			e.printStackTrace();
		}
	}

	
	public String getInitiativeToUpdate() {
		return initiativeToUpdate;
	}

	public void setInitiativeToUpdate(String initiativeToUpdate) {
		this.initiativeToUpdate = initiativeToUpdate;
		
	}

	public String getstatusToUpdate() {
		return statusToUpdate;
	}

	public void setstatusToUpdate(String statusToUpdate) {
		//System.out.println(statusToUpdate);
		this.statusToUpdate = statusToUpdate;
		
	}
	public Initiative getSelectedInitiative() {
		return selectedInitiative;
	}
	public void setSelectedInitiative(Initiative selectedInitiative) {
		this.selectedInitiative = selectedInitiative;
	}
	 /**
	  * Registra un comentario en una iniciativa
	  * 
	  */
	public void addComment (String comment){
		try {

			initiativeService.addComment(comment);

			} catch (JtamsExceptions jtamsExceptions) {
				jtamsExceptions.printStackTrace();
			}
		}
	public List<Comment> todosComentarios() throws JtamsExceptions{
		comentarios=commentService.todosComentarios();
		//System.out.println(comentarios.get(0).getMensaje());
			return comentarios;
	
		}
	 public void doSomething() {  
	        try {  
	            // simulate a long running request  
	            Thread.sleep(500);  
	        } catch (final Exception e) {  
	            // ignore  
	        }  
	    }
	public List<Initiative> getIniciativasAgrupadasFront() {
		return iniciativasAgrupadasFront;
	}
	public void setIniciativasAgrupadasFront(List<Initiative> iniciativasAgrupadasFront) {
		this.iniciativasAgrupadasFront = iniciativasAgrupadasFront;
	}
	//metodos para votar y quitar voto
	/**
	  * Registra un voto a una iniciativa
	  * 
	  */
	public void darVoto(int id1) throws JtamsExceptions {
		idInitiativelike=id1;
		votar();
		//1015475103 id del usuario publico (verbo)
		
		//votar(1015475103,idInitiativelike);
	}
	public void quitarVoto(int id) throws JtamsExceptions {
		idInitiativelike=id;
		votar();
		//1015475103 id del usuario publico (verbo)
		
		//quitarVoto(1015475103,idInitiativelike);
	}
	private void updateTabla() throws JtamsExceptions {
		listaIniciativas = initiativeService.dariniciativas();
		
	}
	/**
	  * Ayuda a registra un voto a una iniciativa
	  * 
	  */
	//AQUI YA PUEDE DAR LIKE A LA INICIATIVA
	public void votar(){
		try {
		Subject currentUser = SecurityUtils.getSubject();
		String email = currentUser.getPrincipal().toString();
		ponerId(email);
		//System.out.println(idUser);
		initiativeService.darlike(idUser,idInitiativelike);
		
		updateTabla();

		} catch (JtamsExceptions jtamsExceptions) {
			jtamsExceptions.printStackTrace();
		}
	}
	/**
	  * Registrar un ID de un usuario
	  * 
	  */
	public void ponerId(String ema) throws JtamsExceptions {
		listaUsuarios=userServices.getUsers();
		//System.out.println(listaUsuarios.size());
		for(int i=0; i < listaUsuarios.size(); i++) {
			//System.out.println(listaUsuarios.get(i).getEmail());
			//System.out.println(ema);
        	if(listaUsuarios.get(i).getEmail().equals(ema)) {
        		//System.out.println("lo encuentra");
        		setIdUser(listaUsuarios.get(i).getId());
        		break;
        	}
        }
	}

	/**
	  * mayor parte de metodos para editacion de una iniciativa
	  * 
	  */
	public String getnamenuevo() {
		return namenuevo;
	}

	public void setnamenuevo(String nname) {
		namenuevo = nname;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String ndescription) {
		descripcion = ndescription;
		//System.out.println(ndescription);
	}

	public String getarea2() {
		return area2;
	}

	public void setarea2(String narea) {
		area2 = narea;
		//System.out.println(narea);
	}
	//<p:rowEditor />
	/**
	  * Editar(actualizar) una iniciativa
	  * 
	  */
	public void editInitiative() throws JtamsExceptions {
		//System.out.println("llama el metodo");
		//System.out.println(idEdit.getTypeStatusId());
		try {
		if(idEdit.getTypeStatusId().equals("En espera revision")) {
			//System.out.println("el area es "+area2);
			initiativeService.editarIniciativas(idEdit.getId(),area2,descripcion);
			updateTabla();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Los datos han sido guardados con exito"));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("El estado de la iniciativa no se encuentra en revision"));
		}

		} catch (JtamsExceptions e) {
			 
			throw new JtamsExceptions("No se pudo editar la iniciativa o propuesta");
		}
		 
	}

	public Initiative getIdEdit() {
		return idEdit;
	}

	public void setIdEdit(Initiative idEdit) {
		this.idEdit = idEdit;
	}


	/**
	  * Consulta iniciativa del Usuario que sea proponente
	  * 
	  */
	public List<Initiative> consultarIniciativaProponente() throws JtamsExceptions{
		try {
			Subject currentUser = SecurityUtils.getSubject();
			String email = currentUser.getPrincipal().toString();
			ponerId(email);
			listaIniciativasProponente=initiativeService.consultarIniciativaProponente(idUser);
            return  listaIniciativasProponente;
      } catch (JtamsExceptions ex){
            throw new JtamsExceptions("No se encuentran iniciativas");
       }
	}

	

		
	//proponente@prueba.com

}
