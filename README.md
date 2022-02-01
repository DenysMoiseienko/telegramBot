# telegramBot

> The simple telegram weather bot. Bot is deployed to Heroku and available in telegram as [@FamWeatherBot](https://t.me/FamWeatherBot)

##### Technologies:

---
- Java 11
- Spring Boot
- Gradle
- Telegram Bot API
- OpenWeatherMap API
---

##### Requirements:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Gradle 7.1.1](https://docs.gradle.org/7.1.1/userguide/installation.html#installation)
- [Telegram Bot API](https://core.telegram.org/bots) credentials (username and token)
- [OpenWeatherMap API](https://openweathermap.org/api) credentials (API key)
---
##### Notes:

To use, you need to add **application.yml** file to **resources** folder with your credentials. For example:
```
BOT_USERNAME: your_bot_name
BOT_TOKEN: your_bot_token
OPEN_WEATHER_MAP_APP_ID: your_app_id
```