////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import java.util.Objects;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import kleecontrib.asta.entities.securite.Droit;

/**
 * N-N droits - profils.
 */
@Entity
@Table(name = "DROIT_PROFILS")
@IdClass(DroitProfil.DroitProfilId.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class DroitProfil {

	/**
	 * Droit.
	 */
	@Id
	private Droit droit;

	/**
	 * Profil.
	 */
	@Id
	private Profil profil;

	/**
	 * Getter for droit.
	 *
	 * @return value of {@link #droit droit}.
	 */
	public Droit getDroit() {
		return this.droit;
	}

	/**
	 * Getter for profil.
	 *
	 * @return value of {@link #profil profil}.
	 */
	public Profil getProfil() {
		return this.profil;
	}

	/**
	 * Set the value of {@link #droit droit}.
	 * @param droit value to set.
	 */
	public void setDroit(Droit droit) {
		this.droit = droit;
	}

	/**
	 * Set the value of {@link #profil profil}.
	 * @param profil value to set.
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public static class DroitProfilId {

		@JoinColumn(name = "DRO_CODE", referencedColumnName = "DRO_CODE")
		@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Droit.class)
		private Droit droit;

		@JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
		@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Profil.class)
		private Profil profil;

		/**
		 * Getter for droit.
		 *
		 * @return value of {@link #droit droit}.
		 */
		public Droit getDroit() {
			return this.droit;
		}

		/**
		 * Set the value of {@link #droit droit}.
		 * @param droit value to set.
		 */
		public void setDroit(Droit droit) {
			this.droit = droit;
		}

		/**
		 * Getter for profil.
		 *
		 * @return value of {@link #profil profil}.
		 */
		public Profil getProfil() {
			return this.profil;
		}

		/**
		 * Set the value of {@link #profil profil}.
		 * @param profil value to set.
		 */
		public void setProfil(Profil profil) {
			this.profil = profil;
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

			DroitProfilId oId = (DroitProfilId) o;

			if (this.droit == null || oId.droit == null || this.profil == null || oId.profil == null) {
				return false;
			}

			return Objects.equals(this.droit.getCode(), oId.droit.getCode())
			 && Objects.equals(this.profil.getId(), oId.profil.getId());
		}

		@Override
		public int hashCode() {
			return Objects.hash(droit == null ? null : droit.getCode(), profil == null ? null : profil.getId());
		}
	}
}
