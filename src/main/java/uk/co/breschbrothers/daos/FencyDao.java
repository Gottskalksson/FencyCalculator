package uk.co.breschbrothers.daos;

import org.springframework.stereotype.Repository;
import uk.co.breschbrothers.entity.Fency;

import javax.persistence.Query;
import java.util.List;

@Repository
public class FencyDao extends BaseDao<Fency> {

    public FencyDao() {
        super(Fency.class);
    }

    public List<Fency> findAll() {
        Query query = entityManager.createQuery("SELECT f FROM Fency f");
        List<Fency> fencyList = query.getResultList();
        return fencyList;
    }
}
