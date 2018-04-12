package com.rayes.dao;

import com.rayes.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

    @Autowired
    SessionFactory sessionFactory;

    public Item getItem(String name) {
        Item item = null;
        try(Session session = sessionFactory.openSession()) {
            item = (Item) session.createQuery("FROM Item WHERE name ='" + name + "'")
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return item;
    }

    public void updateItem(Item item) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteItem(Item item) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveItem(Item item) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        }
    }
}
