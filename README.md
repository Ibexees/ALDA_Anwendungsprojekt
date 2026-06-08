Alda Anwendungsprojekt

Ziel: Es soll eine JavaFX/console Application umgesetzt werden um Konzepte für mein Unityprojekt Chaining Chronicle zu testen.
Setting: Es gibt eine Gridbasierte Kate 2D Array auf diesem befinden sich der Spieler und Gegner. Spieler und Gegner ziehen abwechselnd. Spieler möchte Treppe erreichen und Gegner wollen spieler fangen.


Algorithmus1: Gegner sollen den Spieler finden und dabei Wänden ausweichen. (Pathfinding A*)
Algorithmus2: Die spielbare Map soll mit random generierten Räumen befüllt werden, diese Räume werden über Korridore verbunden. (Random Rooms verbunden mit Minimum spanning tree (Kruskal))
Algorithmus3: Die Gegner sollen abhängig von ihrer Geschwindigkeit nach einander dran kommen (Selection Sort)
Datenstruktur: Graph für Räume und weiters MST und Korridore (Disjoint_Set, Adjazenzmatrix).
