# Wojna-gildii
Projekt ma na celu zasymulowanie walki 3 gildii: Wojowników, Łuczników oraz Magów.

# Dane wejściowe
1. Liczba jednostek - dotyczy każdej gildii np. przy wartości 3 jednostek na mapie będzie 9.
2. Liczba iteracji - liczba iteracji (tur).
3. Rozmiar mapy - wartość 2 da mapę o wymiarach 2x2.

# Zasady symulacji
1. Podczas jednej iteracji jednostki poruszają się a następnie atakują każdego przeciwnika na polu.
2. Podczas jednej iteracji jednostki poruszają się maksymalnie o jedno pole.
3. Gdy przeciwnicy znajdują się na tym samym polu jednostka nie może się poruszyć.
4. Jednostki konkretnej gildii atakują tylko jednostki innej (mag nie może zaatakować innego maga).

# Wyniki
Po zakończonej symulacji w oknie pojawi się informacja o zwycięstwie konkretnej gildii lub jeśli liczba iteracji nie pozwoliła na określenie wyniku informacja o nierozstrzygniętej walce.
Dokładniejsze wyniki z informacjami na temat liczby jednostek oraz ich położenia na mapie znajdują się w pliku Output.txt.
