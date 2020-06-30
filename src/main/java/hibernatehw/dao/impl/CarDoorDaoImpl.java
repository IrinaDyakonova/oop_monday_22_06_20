package hibernatehw.dao.impl;

import hibernatehw.dao.CarDoorDao;
import hibernatehw.exeption.DataProcessingException;
import hibernatehw.models.CarDoor;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CarDoorDaoImpl implements CarDoorDao {
    private static final Logger LOGGER = Logger.getLogger(CarDoorDaoImpl.class);

    private SessionFactory sessionFactory;

    public CarDoorDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(carDoor);
            transaction.commit();
            LOGGER.info("carDoor " + carDoor.toString() + " insert");
            return carDoor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert carDoor entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarDoor> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<CarDoor> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarDoor.class);
            criteriaQuery.from(CarDoor.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all CarDoor ", e);
        }
    }

    @Override
    public CarDoor findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<CarDoor> query = session.createQuery(
                    "From CarDoor where id = :id");
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get available CarDoor", e);
        }
    }
}
