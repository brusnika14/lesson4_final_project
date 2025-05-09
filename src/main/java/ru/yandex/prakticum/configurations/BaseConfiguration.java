package ru.yandex.prakticum.configurations;

import java.time.Duration;
import java.util.Random;

public class BaseConfiguration {
    protected static final String BASE_PROTOCOL = "https";
    public static final Duration IMPLICIT_WAIT = Duration.ofSeconds(10);
    public static Random random = new Random();
}
