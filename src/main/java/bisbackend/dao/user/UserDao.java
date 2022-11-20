package bisbackend.dao.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bisbackend.models.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class UserDao implements UserDaoInterface {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    private SessionFactory getSession() {
        return entityManagerFactory.unwrap(SessionFactory.class);
    }

    private EntityManager getEntityManger() {
        return entityManagerFactory.createEntityManager();
    }

    public Long save (User newUser) {
        EntityManager entityManger = this.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.persist(newUser);
        entityManger.flush();
        entityManger.getTransaction().commit();
        entityManger.close();

        return (Long) newUser.getId();
    }

    public void update (User user) {
        EntityManager entityManger = this.getEntityManger();
        entityManger.getTransaction().begin();
        entityManger.merge(user);
        entityManger.getTransaction().commit();
        entityManger.close();
    }

    public Tuple getUser () {
        Session session = this.getSession().openSession();
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cQuery = cBuilder.createTupleQuery();
        Root<User> root = cQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cBuilder.equal(root.get("name"), "test"));

        cQuery.multiselect(
            root.get("id").alias("id"),
            root.get("userName").alias("userName"), root.get("name").alias("name"), 
            root.get("email").alias("email")
        );
        cQuery.where(predicates.toArray(new Predicate[0]));

        Tuple userResult = session.createQuery(cQuery).getSingleResultOrNull();
        session.close();

        return userResult;
    }

    public List<Tuple> getUserList () {
        Session session = this.getSession().openSession();
        CriteriaBuilder cBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Tuple> cQuery = cBuilder.createTupleQuery();
        Root<User> root = cQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cBuilder.equal(root.get("name"), "test"));

        cQuery.multiselect(
            root.get("userName").alias("userName"), root.get("name").alias("name"),
            root.get("email").alias("email")
        );
        cQuery.where(predicates.toArray(new Predicate[0]));

        List<Tuple> userList = session.createQuery(cQuery).getResultList();
        session.close();

        return userList;
    }
}
