package uk.co.breschbrothers.daos;

import org.springframework.stereotype.Repository;
import uk.co.breschbrothers.entity.Another;

import javax.persistence.Query;
import java.util.List;

@Repository
public class AnotherDao extends BaseDao<Another> {


    public AnotherDao() {
        super(Another.class);
    }

    public List<Another> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Another a");
        return query.getResultList();
    }
}
