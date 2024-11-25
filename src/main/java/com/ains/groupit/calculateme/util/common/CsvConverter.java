package com.ains.groupit.calculateme.util.common;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class CsvConverter {
    public static <T> ByteArrayInputStream generateCsv(List<T> dataList, Class<T> clazz) {
        StringBuilder csvData = new StringBuilder();

        // Get all field names for the header row
        List<String> headers = List.of(clazz.getDeclaredFields())
                .stream()
                .map(Field::getName)
                .collect(Collectors.toList());
        csvData.append(String.join(",", headers)).append("\n");

        // Add data rows
        for (T item : dataList) {
            List<String> rowValues = headers.stream()
                    .map(header -> {
                        try {
                            Field field = clazz.getDeclaredField(header);
                            field.setAccessible(true);
                            Object value = field.get(item);
                            return value != null ? value.toString() : "";
                        } catch (NoSuchFieldException | IllegalAccessException e) {
                            return "";
                        }
                    })
                    .collect(Collectors.toList());
            csvData.append(String.join(",", rowValues)).append("\n");
        }

        return new ByteArrayInputStream(csvData.toString().getBytes());
    }
}
