////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.api.common;

import java.util.Collection;

import javax.annotation.Generated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kleecontrib.asta.queries.Reference;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public interface ReferenceController {

	/**
	 * Récupère une liste de référence.
	 * @param referenceName Nom de la liste de référence.
	 *
	 * @return Liste de référence.
	 */
	@GetMapping(path = "api/reference/{referenceName}")
	Collection<Object> getReference(@PathVariable("referenceName") Reference referenceName);
}
