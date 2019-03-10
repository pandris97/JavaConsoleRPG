<h1 align="center">Projekt Eszközök<br>Beadandó projekt</h1>

## Tagok:
- Pálinkás András
- Király Bianka
- Szabó Barna
- Kovács Márk

## Projektötlet
### Feladatleírás(Kezdeti tervek)
Készítsünk egy játékprogramot, amiben egy karaktert irányítunk, aki különböző ellenfelekkel tud csatázni. Az alap kiinulási hely egy város, ahol dönthetünk, hogy a karakterünk mit kíván csinálni. (Elmegy kalandozni, szintetlép, alszik, vásárol...)
### Funkcionális követelmények
- Lehessen új karaktert létrehozni, vagy egy már meglévőt betölteni
- Karakterünk rendelkezzen életerővel, ami ha megsebzik, akkor csökken, ha 0 alá kerül, akkor a karakter meghal és megjelenik a GAME OVER felirat
- Karakterünknek legyen pénze, amit el tud költeni a boltban. 
- Karakterünk rendelkezzen tapasztalati pontokkal, amik ha elérnek egy bizonyos határt, akkor szintet tudjunk lépni a városban.
- Legyen lehetőségünk kalandozi, amikor is a karakterünk véletlenszerűen:
  - Találkozzon és harcoljon ellenfelekkel
  - Rábukkanjon rejtett kincsre, aminél egy rejtvényre kell választ adnia, amit ha kitalál akkor aranyat, ha nem talál ki akkor valamennyi sebzést kap
###Részletesebb leírás:
-Karakter adatai:
--Név
--Élet
--Tapasztalati pont
--Szint
--Eszköztár
--Sebzés
--Statisztika(erő, ügyesség, max életerő)
-Karakter mentés file-ba
-Karakter betöltés
-Ellenfelek adatai:
--Név
--Szint
--Élet
--Sebzés
--Mennyi xp-t ad
--Mennyi gold-ot ad
--Típus(sima, vagy főellenség)
-Harc menü:
--Életerők megjelenése
--Támadás
--Eszköz(pl potion) használata
--Védekezés
--Menekülés(Karakter elveszít valamennyi aranyat)
--Kiosztott sebzések megjelenítése
--Harc végén kapott xp és gold megjelenítése
--Ha a karakter szintet lép, akkor a harc végén a szintlépés menübe kerülünk
-Szintlépés menü:
--Az alábbi menüpontok közül választhatunk:
---Erő növelés
---Ügyesség növelés
---Maximum élet növelés
-Eszközök:
--Fegyverek:
---Minimum statisztika(pl nehéz a fegyver, tehát x erő kell a használathoz)
---Ár
--Bájitalok:
---Mennyi életet tölt(több méretű bájital)
---Ár(Amelyik többet tölt, az drágább)
-Bolt menüpontok:
--Eszköz vétele
--Eszköz eladása
-Eszköz vétele:
--Rendelkezésre álló pénz kiírása
--Megvásárolható eszközök felsorolása(árral és tulajdonsággal)
--Kilépés
-Eszköz eladása:
--Rendelkezésre álló pénz kiírása
--Eladható eszközök felsorolása
--Kilépés