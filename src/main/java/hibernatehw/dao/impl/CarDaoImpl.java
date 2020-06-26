package hibernatehw.dao.impl;

import hibernatehw.dao.CarDao;
import hibernatehw.exeption.DataProcessingException;
import hibernatehw.models.Car;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = Logger.getLogger(CarDaoImpl.class);
    private SessionFactory sessionFactory;

    public CarDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            LOGGER.info("car " + car.toString() + " insert");
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert car entity", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Car> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
