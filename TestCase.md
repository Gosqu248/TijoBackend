# Scenariusze testowe

#
| **ID**   | TC01                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Wyszukiwanie lokali dla adresu: Tarnów, 33-100                              |
| **Warunki początkowe** | Aplikacja jest otwarta na stronie głównej                                    |
| **Kroki testowe** | 1. Wpisz adres Tarnów 33-100 w pole tekstowe.<br>2. Naciśnij przycisk Szukaj    |
| **Oczekiwany rezultat** | Aplikacja wyświetla 11 restauracji                                            |

#
| **ID**   | TC02                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Wyszukiwanie lokali dla adresu: Zbylitowska Góra                            |
| **Warunki początkowe** | Aplikacja jest otwarta na stronie głównej                                    |
| **Kroki testowe** | 1. Wpisz adres Zbylitowska Góra w pole tekstowe.<br>2. Naciśnij przycisk Szukaj |
| **Oczekiwany rezultat** | Aplikacja wyświetla 5 restauracji                                            |
#
| **ID**   | TC03                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Wyszukiwanie lokali dla adresu: Poznań                                      |
| **Warunki początkowe** | Aplikacja jest otwarta na stronie głównej                                    |
| **Kroki testowe** | 1. Wpisz adres Poznań w pole tekstowe.<br>2. Naciśnij przycisk Szukaj          |
| **Oczekiwany rezultat** | Aplikacja wyświetla 0 restauracji                                            |
#
| **ID**   | TC04                                                                                                                   |
|----------|------------------------------------------------------------------------------------------------------------------------|
| **Tytuł** | Przejście do menu: McDonald's Tarnów, Jana Pawła                                                                       |
| **Warunki początkowe** | Aplikacja wyszukała restauracje dla adresu 33-100                                                                      |
| **Kroki testowe** | 1. Naciśnij na restauracje: McDonald's Tarnów, Jana Pawła                                                              |
| **Oczekiwany rezultat** | Aplikacja przechodzi do menu restauracji.<br>Wyświetla całe menu z kategoriami: McWrapy i Sałatki,<br> Napoje, Burgery |
#
| **ID**   | TC05                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Przejście do menu: Rodeo Restauracja                                        |
| **Warunki początkowe** | Aplikacja wyszukała restauracje dla adresu 33-100                           |
| **Kroki testowe** | 1. Naciśnij na restauracje: Rodeo Restauracja                                  |
| **Oczekiwany rezultat** | Aplikacja przechodzi do menu restauracji.<br>Nie wyświetla żadnego elementu menu |
#
| **ID**   | TC06                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Dodawanie produktów do koszyka                                               |
| **Warunki początkowe** | Użytkownik wybrał jedną z restauracji                                        |
| **Kroki testowe** | 1. Naciśnij przycisk + przy Coca-Cola<br>2. Naciśnij przycisk + przy Big Mac |
| **Oczekiwany rezultat** | Aplikacja wyświetla w koszyku dodane produkty oraz <br>cenę Razem: 39.20zł   |
#
| **ID**   | TC07                                                                                                                  |
|----------|-----------------------------------------------------------------------------------------------------------------------|
| **Tytuł** | Usunięcie produktu z koszyka                                                                                          |
| **Warunki początkowe** | Użytkownik wybrał jedną z restauracji oraz w koszyku <br> znajduje się przynajmniej 1 produkt, a jego ilość wynosi 1. |
| **Kroki testowe** | 1. Naciśnij przycisk “-” przy produkcie w koszyku.                                                                    |
| **Oczekiwany rezultat** | Aplikacja usuwa produkt z koszyka.                                                                                    |
#
| **ID**   | TC08                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Zamówienie Big Mac 2x oraz Sprite                                           |
| **Warunki początkowe** | Użytkownik wybrał jeden z dostępnych McDonaldów oraz ma <br>pusty koszyk.      |
| **Kroki testowe** | 1. Dodaj Sprite do koszyka.<br>2. Dodaj Big Mac do koszyka.<br>3. Zwiększ ilość Big Mac do 2 sztuk.<br>4. Naciśnij przycisk zamów. |
| **Oczekiwany rezultat** | Zamówienie zostaje dodane do bazy oraz wyskakuje<br> powiadomienie z potwierdzeniem zamówienia.<br> Kwota wynosi 61.50 zł |
#
| **ID**   | TC09                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Zamówienie WieśMac® Podwójny 5x                                            |
| **Warunki początkowe** | Użytkownik wybrał jeden z dostępnych McDonaldów oraz ma<br> pusty koszyk.      |
| **Kroki testowe** | 1. Dodaj WieśMac® Podwójny do koszyka.<br>2. Zwiększ ilość WieśMac® Podwójny do 5 sztuk.<br>3. Naciśnij przycisk zamów. |
| **Oczekiwany rezultat** | Zamówienie zostaje dodane do bazy oraz wyskakuje powiadomienie<br> z potwierdzeniem zamówienia.<br> Kwota wynosi 152.00 zł |
#
| **ID**   | TC10                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Wyświetlanie złożonych zamówień                                             |
| **Warunki początkowe** | Użytkownik znajduje się na stronie głównej                                   |
| **Kroki testowe** | 1. Naciśnij przycisk “Zobacz wszystkie zamówienia”                             |
| **Oczekiwany rezultat** | Aplikacja przekieruje na podstronę: /orders oraz wyświetli wszystkie <br>zamówienia, które zostały złożone do tej pory. |
#
| **ID**   | TC11                                                                         |
|----------|------------------------------------------------------------------------------|
| **Tytuł** | Wyświetlanie menu złożonego zamówienia.                                     |
| **Warunki początkowe** | Użytkownik znajduje się na stronie głównej                                   |
| **Kroki testowe** | 1. Naciśnij przycisk “Zobacz wszystkie zamówienia”.<br>2. Wybierz dowolne zamówienie.<br>3. Naciśnij przycisk “Pokaż menu”. |
| **Oczekiwany rezultat** | Aplikacja pokaże produkty jakie są w zamówieniu.                          |
