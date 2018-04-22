$(document).ready(function(){

$.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/getKnightInventory/Parzival",
            success: function (response) {
                $("#inventory").append("<h2>" + response[0].knight.name + "`s inventory</h2>");
                $("#inventory").append("<table id='inventoryTable'/>");
                for(var i = 0; i < response.length; i++) {
                    var item = response[i].item.name + "\n" + "Item value - " +
                    response[i].item.value + "\n" + " Description - " +
                        response[i].item.description + "\n" + "Sell price " + response[i].item.sellPrice;
                    $("#inventoryTable").append("<tr><td><img class ='" + response[i].item.name + "' title='" + item + "' src='" +
                    response[i].item.itemImage + "' alt='Item'/>" + "</td><td>" + "<button class='use' id='" +
                    response[i].item.name + "'>" + "Use item" + "</button><button class='sell' id='" + response[i].item.name + "'>" +
                    "Sell item" + "</button></td></tr>");
                }


                $("#inventory").show("slow");

                $("button.use").bind("click", function clickUse(event) {
                    var name = $(this).attr("id");
                    $(this).parent().parent().remove();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: "http://localhost:8080/useItem/Parzival/" + name,
                        success: function(response) {
                            var item = response.name + "\n" + "Item value - " + response.value + "\n" + " Description - " +
                            response.description + "\n" + "Sell price " + response.sellPrice;
                            $("#inventoryTable").append("<tr><td id'>" + "<img " + "title='" + item + "' id='" + response.name  +
                            "' src='" + response.itemImage +
                             "' alt='Item'/></td><td>" + "<button class='use' id='" + response.name + "'>" + "Use item" +
                             "<button class='sell' id='" + response.name + "'>" + "Sell item</button></td></tr>");
                             location.reload();
                        }
                    })

                  })

                $("button.sell").bind("click", function clickSell() {
                    var name = $(this).attr("id");
                    $(this).parent().parent().remove();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: "http://localhost:8080/sellItem/Parzival/" + name,
                        success: function(response) {
                            $("#inventoryTable").append("<tr><td>" + response + "</td></tr>");
                        }
                    })
                })
            }
        })


    $("#knightLi").bind("click", function() {
        $("div").hide();
        $("#knight").empty();
            $.ajax({
                type: "GET",
                dataType: "json",
                url: "http://localhost:8080/getKnight/Parzival",
                success: function(response) {
                    $("#knight").append("<h2 id='knightName'>Knight " + response.name + "</h2>");
                    $("#knight").append("<h2>Health: " + response.health + "</h2>");
                    $("#knight").append("<h2>Mana: " + response.mana + "</h2>");
                    $("#knight").append("<h2 title='" + "From weapon +" + response.weapon.value + "'>Attack: " +
                    response.actualAttack + "</h2>");
                    $("#knight").append("<h2 title='" + "From armor +" + response.armor.value + "'>Defense: " +
                    response.actualDefense + "</h2>");
                    $("#knight").append("<h2>Gold: " + response.gold +"</h2>");
                    var armor = response.armor.name + "\n" + "Armor value - " +
                    response.armor.value + "\n" +
                    "Description - " + response.armor.description;
                    var weapon = response.weapon.name + "\n" + "Weapon value -" +
                    response.weapon.value + "\n" +
                    "Description - " + response.weapon.description;
                    $("#knight").append("<h2>Knight`s armor</h2>");
                    $("#knight").append("<img " + "title='" + armor + "' id='armorImage' src='" +
                    response.armor.itemImage +
                    "' alt='Knight`s armor'/>");
                    $("#knight").append("<h2>Knight`s weapon</h2>");
                    $("#knight").append("<img " + "title='" + weapon + "' id='weaponImage' src='" +
                    response.weapon.itemImage +
                    "' alt='Knight`s weapon'/>");


                    $("#knight").show("slow");

                }


            });
    })

    $("#inventoryLi").bind("click", function(event) {
        event.preventDefault();
        $("div").hide();
        $("#inventory").empty();

        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/getKnightInventory/Parzival",
            success: function (response) {
                $("#inventory").append("<h2>" + response[0].knight.name + "`s inventory</h2>");
                $("#inventory").append("<table id='inventoryTable'/>");
                for(var i = 0; i < response.length; i++) {
                    var item = response[i].item.name + "\n" + "Item value - " + response[i].item.value +
                    "\n" + " Description - " + response[i].item.description + "\n" + "Sell price " +
                    response[i].item.sellPrice;
                    $("#inventoryTable").append("<tr><td><img class ='" + response[i].item.name + "' title='" + item + "' src='" +
                    response[i].item.itemImage + "' alt='Item'/>" + "</td><td>" + "<button class='use' id='" +
                    response[i].item.name + "'>" + "Use item" + "</button><button class='sell' id='" + response[i].item.name + "'>" +
                    "Sell item" + "</button></td></tr>");
                }


                $("#inventory").show("slow");

                $("button.use").bind("click", function clickUse(event) {
                    var name = $(this).attr("id");
                    $(this).parent().parent().remove();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: "http://localhost:8080/useItem/Parzival/" + name,
                        success: function(response) {
                            var item = response.name + "\n" + "Item value - " + response.value + "\n" + " Description - " +
                            response.description + "\n" + "Sell price " + response.sellPrice;
                            $("#inventoryTable").append("<tr><td id'>" + "<img " + "title='" + item + "' id='" + response.name  +
                            "' src='" + response.itemImage +
                             "' alt='Item'/></td><td>" + "<button class='use' id='" + response.name + "'>" + "Use item" +
                             "<button class='sell' id='" + response.name + "'>" + "Sell item</button></td></tr>");
                             location.reload();
                        }
                    })

                  })

                $("button.sell").bind("click", function clickSell() {
                    var name = $(this).attr("id");
                    $(this).parent().parent().remove();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: "http://localhost:8080/sellItem/Parzival/" + name,
                        success: function(response) {
                            $("#inventoryTable").append("<tr><td>" + response + "</td></tr>");
                        }
                    })
                })
            }
        })
    })



    $("#shopLi").bind("click", function() {
        $("div").hide();
        $("#shop").empty();

        $.ajax({
            type: "GET",
            dataType: "json",
            url: "http://localhost:8080/shop",
            success: function(response) {
                $("#shop").append("<h2>Shop</h2>");
                $("#shop").append("<h2>Left click on the image to buy goods</h2>");
                $("#shop").append("<table id='shopTable'/>");
                for(var i = 0; i < response.length; i++) {
                    var item = response[i].item.name + "\n" + "Item value - " + response[i].item.value + "\n" + " Description - " +
                               response[i].item.description + "\n" + " Price - " + response[i].item.buyPrice;
                    $("#shopTable").append("<tr id='" + response[i].item.name + "'><td>" + "<img " + "title='" + item +
                     "' src='" + response[i].item.itemImage + "' alt='Item'/>" + "</td>" + "</tr>");
                }
                $("tr").bind("click", function clickImage(event) {
                    event.stopPropagation();
                    var name = $(this).attr("id");
                    $(this).remove();
                    $.ajax({
                        type: "GET",
                        dataType: "json",
                        url: "http://localhost:8080/buyItem/Parzival/" + name,
                        success: function(response) {
                            $("#shopTable").append("<tr><td>" + response + "</td></tr>");
                        }
                    })

                })
            }
        })
        $("#shop").show("slow");
    })

});
