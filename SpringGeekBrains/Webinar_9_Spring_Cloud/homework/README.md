## Урок 9. Spring Cloud. Микросервисная архитектура.
**Задание:**

1. Создайте простую микросервисную архитектуру с использованием Spring Cloud.
2. Ваша архитектура должна включать хотя бы два микросервиса и службу распределения.

**Решение:**

Для решения задачи использовал проект домашней работы из второго семинара.

*Eureka server* и *Gateway* из примера семинара 9.

- подключены зависимости eureka-client, properties, dependencyManager -> [pom.xml](https://github.com/iYureg/spring_geekBrains/blob/a47df8aaa6db0a9e227170a5a5ff54223d85e494/SpringGeekBrains/Webinar_2_spring_base_crud/homework/pom.xml)
- добавлена соответствующая настройка в конфиг шлюза -> [application.yaml](https://github.com/iYureg/spring_geekBrains/blob/a47df8aaa6db0a9e227170a5a5ff54223d85e494/SpringGeekBrains/Webinar_9_Spring_Cloud/CloudExample1/Gateway/src/main/resources/application.yaml)