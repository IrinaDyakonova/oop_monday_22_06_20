package hibernatehw.dao.impl;

import hibernatehw.dao.CarWheelDao;
import hibernatehw.exeption.DataProcessingException;
import hibernatehw.models.CarWheel;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarWheelDaoImpl implements CarWheelDao {
    private static final Logger LOGGER = Logger.getLogger(CarWheelDaoImpl.class);

    private SessionFactory sessionFactory;

    public CarWheelDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(carWheel);
            transaction.commit();
            LOGGER.info("carWheel " + carWheel.toString() + " insert");
            return carWheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert carWheel entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<CarWheel> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<CarWheel> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarWheel.class);
            criteriaQuery.from(CarWheel.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all carWheel ", e);
        }
    }
}
