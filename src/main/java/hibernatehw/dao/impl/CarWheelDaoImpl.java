package hibernatehw.dao.impl;

import hibernatehw.dao.CarWheelDao;
import hibernatehw.exeption.DataProcessingException;
import hibernatehw.lib.Dao;
import hibernatehw.models.CarWheel;
import hibernatehw.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Dao
public class CarWheelDaoImpl implements CarWheelDao {
    private static final Logger LOGGER = Logger.getLogger(CarWheelDaoImpl.class);

    @Override
    public CarWheel add(CarWheel carWheel) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long movieId = (Long) session.save(carWheel);
            transaction.commit();
            carWheel.setId(movieId);
            LOGGER.info("carWheel insert");
            return carWheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't insert carWheel entity", e);
        }
    }

    @Override
    public List<CarWheel> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<CarWheel> criteriaQuery = session
                    .getCriteriaBuilder().createQuery(CarWheel.class);
            criteriaQuery.from(CarWheel.class);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving all carWheel ", e);
        }
    }
}
