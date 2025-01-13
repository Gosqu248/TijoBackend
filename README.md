# 📘 Testowanie i Jakość Oprogramowania

## ✍️ Autor
**Grzegorz Urban**

## 🎯 Temat projektu
**Testowanie aplikacji do zamawiania z różnych restauracji**

## 📄 Opis projektu
Projekt polega na testowaniu aplikacji webowej, która umożliwia użytkownikom:

- Wyszukiwanie pobliskich restauracji na podstawie wprowadzonego adresu.
- Zamawianie jedzenia online z wybranych restauracji.

Celem projektu jest zapewnienie, że funkcje wyszukiwania oraz zamawiania działają poprawnie i bezbłędnie, zapewniając użytkownikom najlepsze doświadczenie.

## Uruchomienie projektu 

### Aplikacja serwerowa - backend (Spring Boot)
- mvn spring-boot:run
### Aplikacja webowa - frontend (Angular)
- npm install
- ng serve

Aplikacja webowa znajduje się w osobnym repozytorium, dostępnym pod tym [linkiem](https://github.com/Gosqu248/TijoFrontend).

## ✅ Testy
W ramach projektu przeprowadzono testy jednostkowe, integracyjne oraz przypadki testowe dla testera manualnego. Wszystkie testy zakończyły się pomyślnie.

### Zakres testów:

- **Testy jednostkowe** – przeprowadzono 14 testów, które sprawdzają poprawność poszczególnych komponentów aplikacji, takich jak wyszukiwanie adresu i wyświetlanie restauracji. Testy jednostkowe dostępne są pod tym [linkiem](https://github.com/Gosqu248/TijoBackend/tree/main/src/test/java/pl/urban/tijobackend/unitTests).

- **Testy integracyjne** – przeprowadzono 12 testów, które sprawdzają poprawność współdziałania modułów odpowiedzialnych za wyszukiwanie i składanie zamówień. Testy integracyjne są dostępne są pod tym [linkiem](https://github.com/Gosqu248/TijoBackend/tree/main/src/test/java/pl/urban/tijobackend/integrationTests).

- **Przypadki testowe dla testera manualnego** – przygotowano 11 przypadków testowych, które zostały dokładnie opisane i mogą być wykonane przez testerów manualnych. Szczegółowe przypadki testowe znajdują się pod tym [linkiem](https://github.com/Gosqu248/TijoBackend/blob/main/TestCase.md).


## Dokumentacja API

Dokumentacja API jest dostępna w Swagger UI. Aby ją zobaczyć, należy uruchomić serwer i przejść pod poniższy link:

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/).


Poniżej znajdują się zrzuty ekranu z dokumentacją API z Swagger UI:

![image](https://github.com/user-attachments/assets/a1404965-70f8-4e2e-8a42-9c38bec4cb0e)

![image](https://github.com/user-attachments/assets/e789f508-4b68-41a6-9080-6fca03e80d2d)

## Technologie użyte w projekcie

- **Spring Boot** – framework do tworzenia aplikacji webowych w Javie.
- **Angular** – framework front-endowy do budowy dynamicznych aplikacji webowych.
- **PostgreSQL** – system zarządzania relacyjną bazą danych.
- **Swagger UI** – narzędzie do generowania interaktywnej dokumentacji API.
- **JUnit 5** – framework do pisania testów jednostkowych w Javie.
- **MockMvc** – narzędzie do testowania kontrolerów w aplikacjach Spring.
- **Mockito** – biblioteka do mockowania obiektów w testach jednostkowych.
- **Angular Material** – komponenty UI oparte na Material Design dla aplikacji Angular.
- **AssertJ** – biblioteka do pisania bardziej ekspresyjnych i czytelnych asercji w testach.

---

Dzięki przeprowadzonym testom zapewniono, że kluczowe funkcje aplikacji działają zgodnie z oczekiwaniami i spełniają wymagania użytkowników.
