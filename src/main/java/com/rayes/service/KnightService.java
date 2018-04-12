package com.rayes.service;

import com.rayes.dao.InventoryDao;
import com.rayes.dao.ItemDao;
import com.rayes.dao.KnightDao;
import com.rayes.dao.ShopDao;
import com.rayes.model.Inventory;
import com.rayes.model.Item;
import com.rayes.model.Knight;
import com.rayes.model.Shop;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class KnightService {
    @Autowired
    SessionFactory sessionFactory;
    @Autowired
    InventoryDao inventoryDao;
    @Autowired
    KnightDao knightDao;
    @Autowired
    ShopDao shopDao;
    @Autowired
    ItemDao itemDao;

    public Knight getKnight(String name) {
        Knight knight = knightDao.getKnight(name);
        knight.setActualAttack(knight.getAttackValue() + knight.getWeapon().getValue());
        knight.setActualDefense(knight.getDefenseValue() + knight.getArmor().getValue());
        return knight;
    }

    public List<Inventory> getInventories(String name) {
        return inventoryDao.getInventories(name);
    }

    public List<Shop> getListShop() {
        return shopDao.getListShop();
    }

    public Item useItem(String name, String itemName) {
        Item item = itemDao.getItem(itemName);
        Knight knight = knightDao.getKnight(name);
        if (item.getItemImage().contains("armor")) {
            Item usedItem = knight.getArmor();
            Inventory inventory = new Inventory();
            inventory.setItem(knight.getArmor());
            inventory.setKnight(knight);
            inventoryDao.saveInventory(inventory);
            knight.setArmor(item);
            knightDao.updateKnight(knight);
            inventory = inventoryDao.getInventory(knight.getKnightId(), item.getItemId());
            inventoryDao.deleteInventory(inventory);
            item = usedItem;
        } else {
            Item usedItem = knight.getWeapon();
            Inventory inventory = new Inventory();
            inventory.setItem(knight.getWeapon());
            inventory.setKnight(knight);
            inventoryDao.saveInventory(inventory);
            knight.setWeapon(item);
            knightDao.updateKnight(knight);
            inventory = inventoryDao.getInventory(knight.getKnightId(), item.getItemId());
            inventoryDao.deleteInventory(inventory);
            item = usedItem;

        }
        return item;
    }

    public String buyItem(String name, String itemName) {
        Item item = itemDao.getItem(itemName);
        Knight knight = knightDao.getKnight(name);
        knight.setGold(knight.getGold() - item.getBuyPrice());
        knightDao.updateKnight(knight);
        Inventory inventory = new Inventory();
        inventory.setKnight(knight);
        inventory.setItem(item);
        inventoryDao.saveInventory(inventory);
        Shop shop = shopDao.getShop(item);
        shopDao.deleteShop(shop);

        return itemName + " was purchased by " + knight.getName();
    }

    public String sellItem(String name, String itemName) {
        Item item = itemDao.getItem(itemName);
        Knight knight = knightDao.getKnight(name);
        knight.setGold(knight.getGold() + item.getSellPrice());
        knightDao.updateKnight(knight);
        Inventory inventory = inventoryDao.getInventory(knight.getKnightId(), item.getItemId());
        inventoryDao.deleteInventory(inventory);
        Shop shop = new Shop();
        shop.setItem(item);
        shopDao.saveShop(shop);

        return itemName + " sold";
    }

}
