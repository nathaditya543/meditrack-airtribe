package services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class CsvStore {
    private CsvStore() {}

    public static void ensureDataDir() {
        try {
            Files.createDirectories(Paths.get("data"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create data directory", e);
        }
    }

    public static List<String> readDataLines(String filePath) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (lines.isEmpty()) {
                return new ArrayList<>();
            }
            return new ArrayList<>(lines.subList(1, lines.size()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read " + filePath, e);
        }
    }

    public static void writeAll(String filePath, String header, List<String> rows) {
        ensureDataDir();
        List<String> lines = new ArrayList<>();
        lines.add(header);
        lines.addAll(rows);

        try {
            Files.write(Paths.get(filePath), lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write " + filePath, e);
        }
    }
}
