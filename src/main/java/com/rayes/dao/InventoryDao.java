package com.rayes.dao;

import com.rayes.model.Inventory;
import com.rayes.model.Knight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDao {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    KnightDao knightDao;

    public Inventory getInventory(Long knight, Long item) {
        Inventory inventory = null;
        try(Session session = sessionFactory.openSession()) {
            inventory = (Inventory) session.createQuery("FROM Inventory WHERE knight=" + knight +
                    " AND item = " + item).getSingleResult();
        }
        return inventory;
    }

    public void updateInventory(Inventory inventory) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(inventory);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteInventory(Inventory inventory) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(inventory);
            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Inventory> getInventories(String name) {
        List<Inventory> inventories = null;
        try(Session session = sessionFactory.openSession()) {
            Knight knight = knightDao.getKnight(name);
            inventories = session.createQuery("FROM Inventory WHERE " +
                    "knight = " + knight.getKnightId()).getResultList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return inventories;
    }

    public void saveInventory(Inventory inventory) {
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(inventory);
            session.getTransaction().commit();
        }
    }
}
