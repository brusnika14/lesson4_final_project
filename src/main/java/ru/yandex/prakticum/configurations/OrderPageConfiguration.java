package ru.yandex.prakticum.configurations;

import ru.yandex.prakticum.models.User;

public class OrderPageConfiguration extends BaseConfiguration {
    private static final String[] stations = {
            "Лубянка",
            "Спортивная"
    };
    private static final User[] users = {
            new User(
                    "Шишечка", "Ивановна", "+79438793129", "г. Пупс ул. Шишечная"
            ),
            new User(
                    "Молочко", "Петровна","+79547124529", "г. Бимс ул. Молочковая"
            )
    };

    public static String getStation() {
        return stations[random.nextInt(stations.length)];
    }

    public static User getRandomUser() {
        return users[random.nextInt(users.length)];
    }
}
