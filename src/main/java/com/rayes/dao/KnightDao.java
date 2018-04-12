package com.rayes.dao;

import com.rayes.model.Knight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class KnightDao {

    @Autowired
    SessionFactory sessionFactory;

    public Knight getKnight(String name) {
        Knight knight = null;
        try(Session session = sessionFactory.openSession()) {
            knight = (Knight) session.createQuery("FROM Knight WHERE name='" + name + "'")
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return knight;
    }

    public void updateKnight(Knight knight) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(knight);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteKnight(Knight knight) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(knight);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveKnight(Knight knight) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(knight);
            session.getTransaction().commit();
        }
    }
}
