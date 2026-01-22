////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.auth;

import java.io.Serial;
import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

/**
 * Informations relatives à l'authentification.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class AuthProperties implements Serializable {

	/**
	 * Serial ID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Nom de l'autorité.
	 */
	@Size(max = 100)
	private String authority;

	/**
	 * Nom de l'autorité.
	 */
	@Size(max = 100)
	private String clientId;

	/**
	 * Indique si le protocole HTTPS est requis.
	 */
	private Boolean requireHttps;

	/**
	 * Getter for authority.
	 *
	 * @return value of {@link #authority authority}.
	 */
	public String getAuthority() {
		return this.authority;
	}

	/**
	 * Getter for clientId.
	 *
	 * @return value of {@link #clientId clientId}.
	 */
	public String getClientId() {
		return this.clientId;
	}

	/**
	 * Getter for requireHttps.
	 *
	 * @return value of {@link #requireHttps requireHttps}.
	 */
	public Boolean getRequireHttps() {
		return this.requireHttps;
	}

	/**
	 * Set the value of {@link #authority authority}.
	 * @param authority value to set.
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	/**
	 * Set the value of {@link #clientId clientId}.
	 * @param clientId value to set.
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Set the value of {@link #requireHttps requireHttps}.
	 * @param requireHttps value to set.
	 */
	public void setRequireHttps(Boolean requireHttps) {
		this.requireHttps = requireHttps;
	}
}
