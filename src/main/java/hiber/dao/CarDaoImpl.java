package hiber.dao;

import hiber.model.Car;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public long getUserIdBySeriesAndModel(String model, int series) {
        TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car where model = :model and series = :series");
        query.setParameter("model", model);
        query.setParameter("series", series);

        try {
            return query.getSingleResult().getUserId();
        } catch (NoResultException e) {
            return -1;
        }
    }
}
