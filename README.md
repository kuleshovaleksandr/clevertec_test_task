# Тестовое задание для компании Clevertec

#### Используемый стек: 
Java 17, Spring Boot, Spring Data, PostgreSQL, Hibernate, Gradle, Lombok. 

#### Чтобы подключиться к проекту, необходимо:
1) Скачать и установить базу данных **PostgreSQL** с сайта
https://www.postgresql.org/download/
2) Создать базу данных с двумя таблицами **product** и **discount_card**, DDL операции располагаются по пути *src/main/resources/db.migration/*.
3) В Intellij IDEA создать проект с имеющегося репозитория: **File -> New -> Project from Version Control**
4) После создания проекта в Intellij IDEA перейти в меню **Edit configurations...** и настроить переменные среды(**Environment variables**) 
5) Создаем 3 переменные:  
    + **bd.url** со значением  *jdbc:postgresql://localhost:5432/{insert your database name}*   
    + **bd.username** с именем вашего пользователя в базе данных  
    + **bd.password** с паролем, который вы установили для подключения к вашей базе данных
6) Так же переменные подключения к базе данных можно задать напрямую в файле **application.properties**.
7) В параметры запуска приложения передать данные в виде *itemId-quantity*, например: **3-1 4-6 6-4 card-12345**, где **card-12345** означает, 
что была предъявлена скидочная карта с номером **12345**.
8) Либо в параметры запуска передать путь к файлу, который хранит данные в том же виде как в пункте **7**.

#### Допустимые эндпоинты:
**ProductController**
1) **GET**: *http://localhost:8080/products/* - возвращает все продукты находящиеся в базе данных
2) **GET**: *http://localhost:8080/products/{id}* - возвращает продукт с заданным **id**
3) **POST**: *http://localhost:8080/products/* - создает новый продукт в базе данных и принимает в качестве параметра JSON объект
4) **PUT**: *http://localhost:8080/products/{id}* - обновляет продукт в базе данных по заданному **id**
5) **DELETE**: *http://localhost:8080/products/{id}* - удаляет продукт из базы данных по заданному **id**
 
**DiscountCardController**
1) **GET**: *http://localhost:8080/discount_cards/* - возвращает все скидочные карты находящиеся в базе данных
2) **GET**: *http://localhost:8080/discount_cards/{id}* - возвращает скидочную карту с заданным **id**
3) **POST**: *http://localhost:8080/discount_cards/* - создает новую скидочную карту в базе данных и принимает в качестве параметра JSON объект
4) **PUT**: *http://localhost:8080/discount_cards/{id}* - обновляет скидочную карту в базе данных по заданному **id**
5) **DELETE**: *http://localhost:8080/discount_cards/{id}* - удаляет скидочную карту из базы данных по заданному **id**

**ReceiptController**

**GET**: *http://localhost:8080/receipt/* - возвращает JSON объект чека содержащий продукты и скидочную карту, так же печатает чек в консоль приложения
и печатает чек в файл **receipt.txt**.
