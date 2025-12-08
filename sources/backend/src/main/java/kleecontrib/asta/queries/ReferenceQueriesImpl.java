package kleecontrib.asta.queries;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ReferenceQueriesImpl implements ReferenceQueries {
    private final EntityManager entityManager;

    public ReferenceQueriesImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<Object> getReferenceList(Reference reference) {
        var cb = entityManager.getCriteriaBuilder();
        var query = cb.createQuery(reference.getClazz());
        var root = query.from(reference.getClazz());
        query.select(root);
        return entityManager.createQuery(query).getResultList();
    }
}
