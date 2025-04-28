package com.quasarx35;

import com.quasarx35.mcdata.Item;
import com.quasarx35.mcdata.MinecraftData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            MinecraftData data = new MinecraftData("1.18");
            Item diamondSword = data.getItemByName("diamond_sword");
            System.out.println("ID: " + diamondSword.getId());
            System.out.println("Display Name: " + diamondSword.getDisplayName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}