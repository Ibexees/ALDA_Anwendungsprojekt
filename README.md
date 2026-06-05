Alda Anwendungsprojekt

Ziel: Es soll eine JavaFX/console Application umgesetzt werden um Konzepte für mein Unityprojekt Chaining Chronicle zu testen.
Setting: Es gibt eine Gridbasierte Kate 2D Array auf diesem befinden sich der Spieler und Gegner. Spieler und Gegner ziehen abwechselnd. Spieler möchte Treppe erreichen und Gegner wollen spieler fangen.


Algorythmus1: Gegner sollen den Spieler finden und dabei Wänden ausweichen. (Pathfinding A*)
Algorithmus2: Die spielbare Map soll procedural oder zumindest interressanter als "Place Random Tiles in Range" generiert werden. (Random Rooms verbunden mit Minimum spanning tree)
Algorithmus3: Überprüfung ob alle Dungeonräume verbunden via DFS/BFS
Datenstruktur: Die Gegner sollen abhängig von ihrer Geschwindigkeit nach einander dran kommen (MaxHeap).
