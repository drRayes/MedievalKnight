package com.rayes.controller;

import com.rayes.model.Inventory;
import com.rayes.model.Item;
import com.rayes.model.Knight;
import com.rayes.model.Shop;
import com.rayes.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class KnightRestController {

    @Autowired
    KnightService knightService;

    @RequestMapping(value = "/getKnight/{name}", method = RequestMethod.GET)
    public@ResponseBody Knight getKnight(@PathVariable(name = "name") String name) {
        return knightService.getKnight(name);
    }

    @RequestMapping(value = "/getKnightInventory/{name}", method = RequestMethod.GET)
    public@ResponseBody List<Inventory> getInventories(@PathVariable(name ="name") String name) {
        return knightService.getInventories(name);
    }

    @RequestMapping(value = "/useItem/{name}/{itemName}", method = RequestMethod.GET)
    public@ResponseBody Item useItem(@PathVariable(name = "name") String name,
        @PathVariable(name = "itemName") String itemName) {
        return knightService.useItem(name, itemName);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public@ResponseBody List<Shop> getShop() {
        return knightService.getListShop();
    }

    @RequestMapping(value = "/buyItem/{name}/{itemName}", method = RequestMethod.GET)
    public String buyItem(@PathVariable(name = "name") String name, @PathVariable(name = "itemName")
            String itemName) {
        return knightService.buyItem(name, itemName);
    }

    @RequestMapping(value = "/sellItem/{name}/{itemName}", method = RequestMethod.GET)
    public String sellItem(@PathVariable(name = "name") String name, @PathVariable(name ="itemName")
                           String itemName) {
        return knightService.sellItem(name, itemName);
    }


}
