////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.common;

import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

/**
 * Classe pour contenir les traductions en base de données.
 */
@Entity
@Table(name = "TRADUCTIONS")
@IdClass(Traduction.TraductionId.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Traduction {

	/**
	 * Clé de traduction.
	 */
	@Id
	private String resourceKey;

	/**
	 * Locale.
	 */
	@Id
	private String locale;

	/**
	 * Valeur.
	 */
	@Column(name = "TRD_LABEL", nullable = false, length = 100, columnDefinition = "varchar")
	private String label;

	/**
	 * Getter for resourceKey.
	 *
	 * @return value of {@link #resourceKey resourceKey}.
	 */
	public String getResourceKey() {
		return this.resourceKey;
	}

	/**
	 * Getter for locale.
	 *
	 * @return value of {@link #locale locale}.
	 */
	public String getLocale() {
		return this.locale;
	}

	/**
	 * Getter for label.
	 *
	 * @return value of {@link #label label}.
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Set the value of {@link #resourceKey resourceKey}.
	 * @param resourceKey value to set.
	 */
	public void setResourceKey(String resourceKey) {
		this.resourceKey = resourceKey;
	}

	/**
	 * Set the value of {@link #locale locale}.
	 * @param locale value to set.
	 */
	public void setLocale(String locale) {
		this.locale = locale;
	}

	/**
	 * Set the value of {@link #label label}.
	 * @param label value to set.
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	public static class TraductionId {

		@Column(name = "TRD_RESOURCE_KEY", nullable = false, length = 100, columnDefinition = "varchar")
		private String resourceKey;

		@Column(name = "TRD_LOCALE", nullable = false, length = 100, columnDefinition = "varchar")
		private String locale;

		/**
		 * Getter for resourceKey.
		 *
		 * @return value of {@link #resourceKey resourceKey}.
		 */
		public String getResourceKey() {
			return this.resourceKey;
		}

		/**
		 * Set the value of {@link #resourceKey resourceKey}.
		 * @param resourceKey value to set.
		 */
		public void setResourceKey(String resourceKey) {
			this.resourceKey = resourceKey;
		}

		/**
		 * Getter for locale.
		 *
		 * @return value of {@link #locale locale}.
		 */
		public String getLocale() {
			return this.locale;
		}

		/**
		 * Set the value of {@link #locale locale}.
		 * @param locale value to set.
		 */
		public void setLocale(String locale) {
			this.locale = locale;
		}

		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}

			if (o == null) {
				return false;
			}

			if (this.getClass() != o.getClass()) {
				return false;
			}

			TraductionId oId = (TraductionId) o;

			return Objects.equals(this.resourceKey, oId.resourceKey)
			 && Objects.equals(this.locale, oId.locale);
		}

		@Override
		public int hashCode() {
			return Objects.hash(resourceKey, locale);
		}
	}
}
