package ru.ayupov.task;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Есть набор бесплатных сервисов в интернете, предоставляющих данные в формате JSON:
 * <p>
 * https://github.com/toddmotto/public-apis/blob/master/README.md
 * <p>
 * Выбрать любой сервис, какой больше нравится, и написать программу, которая с ним взаимодействует.
 * <p>
 * Класс сериализуемого объекта может содержать не все поля, а только 2-3 ключевых. Например,
 * для погоды достаточно показать диапазон температур.
 * Минимальное количество запросов к сервису - 1. Не обязательно реализовывать весь функционал,
 * предоставляемый сервисом. Достаточного одного любого запроса
 */
public class Main {
    public static void main(String[] args) {
        System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; " +   //Маскировка под браузер
                "en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");

        URL jsonUrl = null;

        try {
            jsonUrl = new URL("https://anapioficeandfire.com/api/houses");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        House[] houses = null;

        try {
            houses = mapper.readValue(jsonUrl, House[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (houses != null) {
            System.out.println(String.format("%-30s|%-15s|%-25s|%-125s", "Название дома", "Земли", "Девиз", "Герб"));

            System.out.println(new String(new char[200]).replace("\0", "-"));

            for (House house : houses) {
                System.out.println(house);
            }
        } else {
            System.out.println("Нет данных!");
        }
    }
}
