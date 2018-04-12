package com.rayes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "knight")
public class Knight {

    @Id
    @Column(name = "knight_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long knightId;
    @Column(name = "knight_name")
    private String name;
    @Column(name = "knight_health")
    private Long health;
    @Column(name = "knight_mana")
    private Long mana;
    @Column(name = "knight_attack_value")
    private Long attackValue;
    @Column(name = "knight_defense_value")
    private Long defenseValue;
    @Column(name = "gold")
    private Long gold;
    @JoinColumn(name = "armor_id")
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Item armor;
    @JoinColumn(name = "weapon_id")
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Item weapon;
    @Transient
    private Long actualAttack;
    @Transient
    private Long actualDefense;

    public Long getKnightId() {
        return knightId;
    }

    public void setKnightId(Long knightId) {
        this.knightId = knightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getMana() {
        return mana;
    }

    public void setMana(Long mana) {
        this.mana = mana;
    }

    public Long getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(Long attackValue) {
        this.attackValue = attackValue;
    }

    public Long getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(Long defenseValue) {
        this.defenseValue = defenseValue;
    }

    public Item getArmor() {
        return armor;
    }

    public void setArmor(Item armor) {
        this.armor = armor;
    }

    public Item getWeapon() {
        return weapon;
    }

    public void setWeapon(Item weapon) {
        this.weapon = weapon;
    }

    public Long getGold() {
        return gold;
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public Long getActualAttack() {
        return actualAttack;
    }

    public void setActualAttack(Long actualAttack) {
        this.actualAttack = actualAttack;
    }

    public Long getActualDefense() {
        return actualDefense;
    }

    public void setActualDefense(Long actualDefense) {
        this.actualDefense = actualDefense;
    }
}
