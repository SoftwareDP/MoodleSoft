package co.edu.uniquindio.moodlesoft.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.edu.uniquindio.moodlesoft.ejbs.EstudianteEJB;
import co.edu.uniquindio.moodlesoft.ejbs.ProfesorEJB;
import co.edu.uniquindio.moodlesoft.ejbs.UsuarioEJB;
import co.edu.uniquindio.moodlesoft.entidades.Estudiante;
import co.edu.uniquindio.moodlesoft.entidades.Profesor;
import co.edu.uniquindio.moodlesoft.entidades.Usuario;

@ManagedBean(name = "loginBean")
@ViewScoped
public class LoginBean {

	private String usuario;
	private String password;
	private String tipoUsuario;
	private Usuario usu;
	private Profesor pro = new Profesor();
	private Estudiante est= new Estudiante();
	@EJB
	private UsuarioEJB usuarioEJB;

	@EJB
	private ProfesorEJB profesorEJB;

	@EJB
	private EstudianteEJB estudianteEJB;

	@PostConstruct
	private void init() {
        usu=new Usuario();
        infoPerfil();
	}

	public String login() {
		String redireccion = "Login.xhtml";
		RequestContext context = RequestContext.getCurrentInstance();
		if (tipoUsuario != null) {
			Usuario u = usuarioEJB.validarLogin(usuario, password, tipoUsuario);
			if (u instanceof Profesor) {
				if (u != null) {
					context.execute("swal('Ingreso','Gracias por iniciar','success')");
					redireccion = "Home";
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
				}
				usuario = password = tipoUsuario = "";
				return redireccion;
			} else if (u instanceof Estudiante) {
				if (u != null) {
					context.execute("swal('Ingreso','Gracias por iniciar','success')");
					redireccion = "EstudianteInicio";
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
				}
				usuario = password = tipoUsuario = "";
				return redireccion;
			}
			context.execute("swal(' Error Ingreso','Vuelva a iniciar','error')");
		}

		return redireccion;
	}

	/**
	 * Metodo que identifica que tipo de usuario ingresa
	 * @return idUsuario
	 */
	public void infoPerfil() {
		usu = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		if(usu!=null){
			if(usu instanceof Profesor){
				pro = (Profesor) usu;
			}else 
      	  est=(Estudiante) usu;
		}	
	}
	
	/**
	 * Metodo que permite editar los campos de usuario
	 */
	public void editar() {
		if (pro != null)
			profesorEJB.editarUsuario(pro);
		else if(est!=null){
			estudianteEJB.editarUsuario(est);
		}
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the tipoUsuario
	 */
	public String getTipoUsuario() {
		return tipoUsuario;
	}

	/**
	 * @param tipoUsuario
	 *            the tipoUsuario to set
	 */
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

}
