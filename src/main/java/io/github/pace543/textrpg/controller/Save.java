package io.github.pace543.textrpg.controller;

import io.github.pace543.textrpg.entity.Player;
import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import java.io.File;
import java.io.IOException;

class Save {
    static void save(Player p, String filename) throws IOException {
        TomlWriter writer = new TomlWriter();
        File file = new File("./" + filename + ".save");
        writer.write(p, file);
    }

    static Player loadSave(String filename) {
        File file = new File("./" + filename + ".save");
        if (!file.exists()) {
            return null;
        }
        Toml toml = new Toml().read(new File("./" + filename + ".save"));
        return toml.to(Player.class);
    }
}
