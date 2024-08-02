package com.magmaguy.resourcepackmanager.config;

import com.magmaguy.magmacore.config.ConfigurationEngine;
import com.magmaguy.magmacore.config.ConfigurationFile;
import lombok.Getter;

import java.util.List;

public class DefaultConfig extends ConfigurationFile {

    @Getter
    private static List<String> priorityOrder;
    @Getter
    private static boolean autoHost;
    @Getter
    private static boolean forceResourcePack;
    @Getter
    private static String resourcePackPrompt;

    public DefaultConfig() {
        super("config.yml");
    }

    @Override
    public void initializeValues() {
        priorityOrder = ConfigurationEngine.setList(
                List.of(
                        "Sets the list, from highest priority (top) to lowest priority (bottom), in which the resource" +
                                " packs will automatically resolve merge conflicts.",
                        "The defaults use plugin names. If you manually added your own resource pack in the mixer folder to be merged in, add its exact filename, including .zip in the name"),
                fileConfiguration, "priorityOrder",
                List.of("ResourcePackManager", "EliteMobs", "FreeMinecraftModels", "ModelEngine", "ItemsAdder", "Nova", "Oraxen", "BetterHUD", "ValhallaMMO", "MMOInventory"));

        autoHost = ConfigurationEngine.setBoolean(
                List.of("Automatically host the resource pack on MagmaGuy's servers",
                        "These servers cost money to keep running. There is no guarantee this will be an option forever."),
                fileConfiguration, "autoHost", true);

        forceResourcePack = ConfigurationEngine.setBoolean(
                List.of("Sets whether the resource pack use will be forced to clients"),
                fileConfiguration, "forceResourcePack", false);

        resourcePackPrompt = ConfigurationEngine.setString(
                List.of("Sets whether the resource pack use will be forced to clients"),
                fileConfiguration, "resourcePackPrompt", "Use recommended resource pack?");
    }
}
