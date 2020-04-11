package uk.co.breschbrothers.daos;

import org.springframework.stereotype.Repository;
import uk.co.breschbrothers.entity.Post;
import uk.co.breschbrothers.entity.Rail;

import javax.persistence.Query;
import java.util.List;

@Repository
public class RailDao extends BaseDao<Rail> {


    public RailDao() {
        super(Rail.class);
    }

    public List<Rail> findAll() {
        Query query = entityManager.createQuery("SELECT r FROM Rail r");
        return query.getResultList();
    }
}
