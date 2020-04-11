package uk.co.breschbrothers.daos;

import org.springframework.stereotype.Repository;
import uk.co.breschbrothers.entity.Post;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PostDao extends BaseDao<Post> {


    public PostDao() {
        super(Post.class);
    }

    public List<Post> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Post p");
        return query.getResultList();
    }
}
