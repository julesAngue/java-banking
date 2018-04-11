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


**Problèmes rencontrés, strategies de résolution**


* Problème de compilation : Nous avons rencontré des erreurs au niveau de l'importation de nos packages au moment de la compilation. Nous avons donc modifié le fichier `compile.sh` pour résoudre ce probleme.

* Connection au compte dans le banking : Nous avons eu des difficultés à trouver la méthode adaptée pour se connecter au compte sur lequel nous voulions effectuer une action. A chaque action demandée nous avons appellé la méthode correspondant à cet action sur le compte voulu. Par exemple :


      public void listLoan(){
            
            Logger logger = Logger.getLogger();
            logger.info("<output>","Enter your account name: ")
            String name = scan.nextLine;
            
            try{
                  Account account = bank.getAccountByName(name);
                  account.listLoan;
            }catch (IllegalArgumentException e){}
            catch (WrongNameException a){}
            
      }
            
      
* Problèmes non résolus : 
1. Les classes de tests ne sont pas trouvées lors du lancement de `test.sh`.  
2. Nous n'avons pas réussi à limiter les entrées aux chaines de caractères ou aux entiers.







