package dao.impl;

import dao.CarDao;
import exeption.DataProcessingException;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lib.Dao;
import models.Car;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

@Dao
public class CarDaoImpl implements CarDao {
    private static final Logger LOGGER = Logger.getLogger(CarDaoImpl.class);

    @Override
    public Car add(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(car);
            transaction.commit();
            car.setId(movieId);
            LOGGER.info("Car insert");
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert Car entity", e);
        }
    }

    @Override
    public List<Car> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<Car> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(Car.class);
            criteriaQuery.from(Car.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all cars ", e);
        }
    }
}
