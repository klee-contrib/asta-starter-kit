package kleecontrib.asta.mutations;

import jakarta.validation.Valid;
import kleecontrib.asta.dtos.securite.profil.ProfilCommand;

public interface ProfilMutations {
    /**
     * Sauvegarde un Profil.
     *
     * @param proId  Id technique.
     * @param profil Profil à sauvegarder.
     * @return Id du Profil sauvegardé.
     */
    void updateProfil(Long proId, @Valid ProfilCommand profil);
    
    /**
     * Ajoute un Profil.
     *
     * @param profil Profil à sauvegarder.
     * @return Profil sauvegardé.
     */
    Long addProfil(@Valid ProfilCommand profil);
}
