package dao.impl;

import dao.CarDoorDao;
import exeption.DataProcessingException;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import lib.Dao;
import models.CarDoor;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

@Dao
public class CarDoorDaoImpl implements CarDoorDao {
    private static final Logger LOGGER = Logger.getLogger(CarDoorDaoImpl.class);

    @Override
    public CarDoor add(CarDoor carDoor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(carDoor);
            transaction.commit();
            carDoor.setId(movieId);
            LOGGER.info("carDoor insert");
            return carDoor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert carDoor entity", e);
        }
    }

    @Override
    public List<CarDoor> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CarDoor> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarDoor.class);
            criteriaQuery.from(CarDoor.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all CarDoor ", e);
        }
    }
}
