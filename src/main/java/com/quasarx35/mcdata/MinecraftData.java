package com.quasarx35.mcdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinecraftData {
    private Map<String, Item> itemsByName;
    private Map<Integer, Item> itemsById;

    public MinecraftData(String version) throws IOException {
        itemsByName = new HashMap<>();
        itemsById = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();
        File itemsFile = new File("minecraft-data/data/pc/" + version + "/items.json");
        List<Item> items = mapper.readValue(itemsFile, new TypeReference<List<Item>>() {});

        for (Item item : items) {
            itemsByName.put(item.getName(), item);
            itemsById.put(item.getId(), item);
        }
    }

    public Item getItemByName(String name) {
        return itemsByName.get(name);
    }

    public Item getItemById(int id) {
        return itemsById.get(id);
    }
}
