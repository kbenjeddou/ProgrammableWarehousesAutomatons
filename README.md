# ProgrammableWarehousesAutomatons

Il s'agit de développer un automate, destiné à se déplacer dans des
surfaces rectangulaires telles que des entrepôts.

L’automate peut être programmé pour parcourir l'intégralité de la surface.
La position de l’automate est représentée par une combinaison de coordonnées (x, y)
et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N, E, W,
S). L’entrepôt est divisé en grille pour simplifier la navigation.

Par exemple, la position de l’automate peut être 0 0 N, ce qui signifie qu'il se situe
dans le coin inférieur gauche de la pelouse, et orienté vers le Nord.

Pour contrôler l’automate, on lui envoie une séquence simple de lettres. Les lettres
possibles sont D, G et A. D et G font pivoter l’automate de 90° à droite ou à gauche
respectivement, sans la déplacer. A signifie que l'on avance l’automate d'une case
dans la direction à laquelle il fait face, et sans modifier son orientation.

Si la position après mouvement est en dehors de l’entrepôt, l’automate ne bouge pas,
conserve son orientation et traite la commande suivante.

On assume que la case directement au Nord de la position (x, y) a pour coordonnées
(x, y+1).

Pour programmer l’automate, on lui fournit un fichier d'entrée construit comme suit :

• La première ligne correspond aux coordonnées du coin supérieur droit de
l’entrepôt, celles du coin inférieur gauche sont supposées être (0,0),

• La suite du fichier permet de piloter toutes les automates qui ont été déployés.
Chaque automate a deux lignes le concernant :

• La première ligne donne la position initiale de l’automate, ainsi que son
orientation. La position et l'orientation sont fournies sous la forme de 2 chiffres
et une lettre, séparés par un espace,

• La seconde ligne est une série d'instructions ordonnant à l’automate d'explorer
l’entrepôt. Les instructions sont une suite de caractères sans espaces.

• Chaque automate se déplace de façon séquentielle, ce qui signifie que le second
automate ne bouge que lorsque le premier a exécuté intégralement sa série
d'instructions. Lorsqu'un automate achève une série d'instruction, il communique sa
position et son orientation.

#Objectif
Concevoir et écrire un programme s'exécutant sur une JVM 8, implémentant la
spécification ci-dessus et passant le test ci-après.

#Test
Le fichier suivant est fourni en entrée :
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
On attend le résultat suivant (positions finales des automates) :
1 3 N
5 1 E

NB : Les données en entrée peuvent être injectées sous une autre forme qu'un fichier
(par exemple un test automatisé).