<h2 align="center" > Cleanuri </h2>

***Документация:*** https://cleanuri.com/docs

***Тестовые данные:*** test_task/src/test/resources/

	Валидные значения: CleanuriValidData.csv
	Невалидные значения: CleanuriInvalidData.csv

***Положительные тесты:***
Произвести проверку POST запроса /api/v1/shorten с входящем параметром url и возвращаемым result_url ответом. Значения url и result_url считывать с файла CleanuriValidData.csv. Код ответа: 200.

***Отрицательные тесты:***
Произвести проверку POST запроса /api/v1/shorten с входящем параметром url и возвращаемым error ответом. Значения url и error считывать с файла CleanuriInvalidData.csv. Код ответа: 400.

***Требования к стеку технологий и ПО:***
1. Java 8 и выше
2. Maven
3. JUnit 5
4. IDE IntelliJ Idea
5. Rest Assured для api-тестов
6. Selenium или Selenide для UI-тестов (браузер - chrome)
7. Asserts - AsserJ или Hamcrest
8. Проект с тестами разместить в github/gitlab (можно оформить все задания в рамках одного репозитория)


***Примечание:***
