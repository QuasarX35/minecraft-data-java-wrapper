package com.quasarx35.mcdata;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

public class MinecraftData {

    private static final Logger LOGGER = Logger.getLogger(MinecraftData.class.getName());

    public static Map<String, Map<String, Map<String, String>>> dataPaths;

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File dataPathsFile = new File("minecraft-data/data/dataPaths.json");
            dataPaths = mapper.readValue(dataPathsFile, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
            dataPaths = Map.of(); // Empty map in case of error
        }
    }

    private final Map<String, Item> itemsByName;
    private final Map<Long, Item> itemsById;

    public MinecraftData(String version) throws IOException {
        itemsByName = new HashMap<>();
        itemsById = new HashMap<Long, Item>();

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

    public Item getItemById(Long id) {
        return itemsById.get(id);
    }
}
