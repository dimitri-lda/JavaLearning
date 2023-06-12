package com.gb.java_api;

import java.io.*;

/*
 Второй семинар:
 Задание 1: Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
 Если значение null, то параметр не должен попадать в запрос.
 Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

 Задание 2 (дополнительное): Дана json-строка (можно сохранить в файл и читать из файла)
 [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
 Пример вывода:
 Студент Иванов получил 5 по предмету Математика.
 Студент Петрова получил 4 по предмету Информатика.
 Студент Краснов получил 5 по предмету Физика.

 Задание 3 (дополнительное): Сравнить время выполнения замены символа "а" на "А" любой строки содержащей >1000 символов средствами String и StringBuilder.
 */
public class Lesson2 {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1() {
        String s = "select * from students where ";
        StringBuilder sb = new StringBuilder(s);
        String jsonFilter = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        jsonFilter = jsonFilter
                .replace("{","")
                .replace("}","")
                .replace("\"","");
        String[] jsonFilterArray = jsonFilter.split(", ");

        for (String columnValue : jsonFilterArray) {
            String[] columnValueArray = columnValue.split(":");

            if (columnValueArray[1].equals("null")) {
                continue;
            }
            sb.append(columnValueArray[0]).append(" = '").append(columnValueArray[1]).append("' and ");
        }
        sb.delete(sb.lastIndexOf("'") + 1, sb.length()).append(";");
        System.out.println("SQL запрос: " + sb);
    }

    private static void task2() {
        String[][] jsonValues2DemArray = jsonStringToArray(readFromInputStream("data/lesson2api.json"));
        if (jsonValues2DemArray == null) {
            return;
        }

        for (String[] jsonValuesArray : jsonValues2DemArray) {
            System.out.printf(
                    "Студент %s получил %s по предмету %s.\n",
                    jsonValuesArray[0],
                    jsonValuesArray[1],
                    jsonValuesArray[2]
            );
        }
    }

    private static String readFromInputStream(String file) {
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
        StringBuilder resultStringBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;

        try {
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            return null;
        }

        return resultStringBuilder.toString();
    }

    private static String[][] jsonStringToArray(String jsonString) {
        jsonString = jsonString
                .replace("[","")
                .replace("]","")
                .replace("{","")
                .replace("\"","");

        String[] jsonFilterArray = jsonString.split("},");
        String[][] jsonValues2DemArray = new String[jsonFilterArray.length][3];

        for (int i = 0; i < jsonFilterArray.length; i++) {
            String[] columnValueArray = jsonFilterArray[i].replace("}","").split(",");
            if (columnValueArray.length != 3) {
                return null;
            }

            for (int j = 0; j < columnValueArray.length; j++) {
                String[] keyValue = columnValueArray[j].split(":");
                if (keyValue.length < 2) {
                    return null;
                }

                jsonValues2DemArray[i][j] = keyValue[1].trim();
            }
        }

        return jsonValues2DemArray;
    }
}