# Projet-Compilation 

Un Composant qui génère un automate d'état fini représentant les traces des manipulations effectuées par des utilisateurs sur des systèmes de monitoring

La/Les manipulations effectuées sont spécifiées sous forme de programme décrivant la partie de l'IHM qui a été utilisé lors de la manipulation et les actions effectuées.

Ce composant analyse le programme et génère un automate d'états fini où les états représentent les composants de l'IHM et les transitions représentent les actions que l'utilisateur a effectuées

Le composant prend en entrée un programme écrit dans un fichier texte d’extension «.ihm» et généré un automate d’État fini sous forme d’une table de transition dans un fichier texte d’extension «.aef» et une table des composants de l’IHM manipulée codés dans un fichier texte d’extension «.gui»

Il est réalisé en langage Java, avec l'outil de génération Javacc

