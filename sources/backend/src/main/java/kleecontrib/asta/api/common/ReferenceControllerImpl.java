package kleecontrib.asta.api.common;

import kleecontrib.asta.queries.Reference;
import kleecontrib.asta.queries.ReferenceQueries;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ReferenceControllerImpl implements ReferenceController {
    private final ReferenceQueries referenceQueries;

    public ReferenceControllerImpl(ReferenceQueries referenceQueries) {
        this.referenceQueries = referenceQueries;
    }

    @Override
    public Collection<Object> getReference(Reference referenceName) {
        return referenceQueries.getReferenceList(referenceName);
    }
}
