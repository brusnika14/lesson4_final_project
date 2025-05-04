package ru.yandex.prakticum.configurations;

import ru.yandex.prakticum.models.User;

public class OrderPageConfiguration extends BaseConfiguration {
    private static final String[] stations = {
            "Лубянка",
            "Спортивная"
    };
    private static final User[] users = {
            new User(
                    "Катя", "Иванова", "+79438793129", "г. Томск ул. Шукшина"
            ),
            new User(
                    "Маша", "Петрова","+79547124529", "г. Бимс ул. Моторная"
            )
    };

    public static String getStation() {
        return stations[random.nextInt(stations.length)];
    }

    public static User getRandomUser() {
        return users[random.nextInt(users.length)];
    }
}
