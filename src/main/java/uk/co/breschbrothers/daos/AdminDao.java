package uk.co.breschbrothers.daos;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uk.co.breschbrothers.entity.Admin;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class AdminDao {

    @PersistenceContext
    EntityManager entityManager;

    public boolean checkAdminData(String username, String password) {
        Query query = entityManager.createQuery("SELECT a from Admin a");
        List<Admin> adminList = query.getResultList();
        Iterator<Admin> iterator = adminList.iterator();
        Admin admin = iterator.next();
        if (admin.getUsername().equals(username) && BCrypt.checkpw(password, admin.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
