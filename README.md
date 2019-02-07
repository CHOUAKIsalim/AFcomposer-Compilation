# Projet-Compilation 

Un Composant qui genere un automate d'état fini representant les traces des manipulations éffectuées par des utilisateurs sur des systemes de monitoring 

La/Les manipulations éffectuées sont spécifiées sous forme de programme décrivant la partie de l'IHM qui a été utilisé lors de la manipulation et les actions éffectuées

Ce composant analyse le programme et genere un automate d'états fini ou les etats representent les composants de l'IHM et les transitions representent les actions que l'utilisateur a éffectué

Le composant prend en entrée un programme écrit dans un fichier texte d’extension «.ihm» et génére un automate d’Etat fini sous forme d’une table de transition dans un fichier texte d’extension «.aef» et une table des composants de l’IHM manipulée codés dans un fichier texte d’extension «.gui»  

Il est réalisé en langage Java, avec l'outil de generation Javacc
