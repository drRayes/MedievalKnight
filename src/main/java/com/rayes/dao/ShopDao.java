package com.rayes.dao;

import com.rayes.model.Item;
import com.rayes.model.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDao {

    @Autowired
    SessionFactory sessionFactory;

    public Shop getShop(Item item) {
        Shop shop = null;
        try(Session session = sessionFactory.openSession()) {
            shop = (Shop) session.createQuery("FROM Shop WHERE item = " + item.getItemId())
                    .getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }

    public void updateShop(Shop shop) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(shop);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteShop(Shop shop) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(shop);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Shop> getListShop() {
        List<Shop> shop = null;
        try(Session session = sessionFactory.openSession()) {
            shop = session.createQuery("FROM Shop").getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return shop;
    }

    public void saveShop(Shop shop) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(shop);
            session.getTransaction().commit();
        }
    }

}
