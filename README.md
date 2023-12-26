Конечно, вот пример простого README файла для вашего проекта. Вы можете адаптировать его под свои нужды:

```markdown
# ProductService

Проект ProductService представляет собой пример веб-приложения для управления товарами и пользователями с использованием Spring Boot.

## Установка и запуск

1. Клонировать репозиторий:

   ```bash
   git clone https://github.com/vS-Fanther/ProductService.git
   cd ProductService
   ```

2. Собрать проект:

   ```bash
   mvn clean install
   ```

3. Запустить приложение:

   ```bash
   java -jar target/ProductService-0.0.1-SNAPSHOT.jar
   ```

   Приложение будет доступно по адресу: [http://localhost:8080](http://localhost:8080)

## Использование API

### Добавление пользователя

```bash
curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"test"}' http://localhost:8080/user/add
```

### Аутентификация пользователя

```bash
curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"test"}' http://localhost:8080/user/authenticate
```

### Добавление продукта (требуется аутентификация)

```bash
TOKEN=$(curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"test"}' http://localhost:8080/user/authenticate)
curl -X POST -H "Content-Type: application/json" -H "Authorization: Bearer $TOKEN" -d '{"records":[{"entryDate":"03-01-2023","itemCode":"11111","itemName":"Test Inventory 1","itemQuantity":"20","status":"Paid"}]}' http://localhost:8080/product/add
```

### Получение всех продуктов (требуется аутентификация)

```bash
TOKEN=$(curl -X POST -H "Content-Type: application/json" -d '{"username":"test","password":"test"}' http://localhost:8080/user/authenticate)
curl -H "Authorization: Bearer $TOKEN" http://localhost:8080/product/all
```

## Запуск тестов

Вы можете запустить интеграционные тесты с использованием Maven:

```bash
mvn test
```