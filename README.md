# Projet POO Gestionnaire de compte en banque 

## ANGUE Jules DECOLA Charly LORENTER Justine

**Commandes de lancement des tests**


      $ ./compile.sh
      $ ./test.sh

**Commandes de lancement du programme**


      $ ./compile.sh
      $ ./launch_banking.sh

**Points d'entrée du code**

* Entrée du programme principal : `banking.Main`
* Entrée de testframework : `test.Runtest` teste les methodes de classes passées en argument :


      java -cp testframework/bin:banking/bin:logger/bin test.RunTest $@
      

* Logger: Pas de point d'entrée



