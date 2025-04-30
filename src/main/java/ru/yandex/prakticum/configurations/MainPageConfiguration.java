package ru.yandex.prakticum.configurations;

public class MainPageConfiguration extends BaseConfiguration {
    public static final String BASE_URL = String.format(
            "%s://qa-scooter.praktikum-services.ru/",
            BASE_PROTOCOL
    );
}
