package ws.cnam.kyccnamweb.metier.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthApiVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2455354442989177721L;
	
	private int status;
	private String message;

}
