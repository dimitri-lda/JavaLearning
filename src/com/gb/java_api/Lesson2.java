package com.gb.java_api;

/*
 Второй семинар:
 Задание 1: Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
 Если значение null, то параметр не должен попадать в запрос.
 Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 */
public class Lesson2 {
    public static void main(String[] args) {
        task1();
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
}