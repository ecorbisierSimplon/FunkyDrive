<!--
     Pour les Pull Requests en cours, veuillez utiliser la fonctionnalité de Pull Request en mode brouillon,
     consultez https://github.blog/2019-02-14-introducing-draft-pull-requests/ pour plus de détails.

     Pour une révision/réponse rapide, veuillez éviter de pousser de force des commits supplémentaires
     si votre PR a déjà reçu des avis ou des commentaires.

     Avant de soumettre une Pull Request, assurez-vous d'avoir effectué les actions suivantes :
     - 📖 Lire le guide de contribution à Forem : https://developers.forem.com/contributing-guide/forem#create-a-pull-request
     - 📖 Lire le code de conduite de Forem : https://github.com/forem/forem/blob/main/CODE_OF_CONDUCT.md
     - 👷‍♀️ Créer des PRs de petite taille. Dans la plupart des cas, cela sera possible.
     - ✅ Fournir des tests pour vos modifications.
     - 📝 Utiliser des messages de commit descriptifs.
     - 📗 Mettre à jour toute documentation associée et inclure des captures d'écran pertinentes.

     REMARQUE : Les Pull Requests à partir de référentiels forkés devront être examinées par
     un membre de l'équipe Forem avant que des constructions CI ne soient exécutées. Une fois votre PR approuvée
     avec une réponse "/ci" à la PR, elle sera autorisée à exécuter des constructions ultérieures sans
     approbation manuelle.
-->

## Quel type de PR est-ce ? (cochez tout ce qui s'applique)

- [ ] Refactorisation
- [ ] Fonctionnalité
- [ ] Correction de bug
- [ ] Optimisation
- [ ] Mise à jour de la documentation

## Description

> _Veuillez remplacer cette ligne par une description de votre travail_

## Liste de vérification

- [ ] Ma PR a un problème lié.
- [ ] J'ai correctement rempli le modèle de PR.
- [ ] J'ai examiné mes modifications moi-même.
- [ ] J'ai vérifié manuellement mon changement.

## Gestion des Tickets

> [!TIP]
>
> Pour les pull requests liées à un problème ou les fermant, veuillez les inclure
> ci-dessous. Nous aimons suivre [les directives de Github sur la liaison des problèmes aux pull requests](https://docs.github.com/en/issues/tracking-your-work-with-issues/linking-a-pull-request-to-an-issue).
>
> Par exemple, inclure le texte "closes #1234" connecterait la pull request actuelle
> au problème 1234. Et lorsque nous fusionnerons la pull request, Github fermera automatiquement le problème.

- Related Issue #
- Closes #

## Instructions de QA, captures d'écran, enregistrements

> _Veuillez remplacer cette ligne par des instructions sur la façon de tester vos modifications, une note
> sur les appareils et navigateurs sur lesquels cela a été testé, ainsi que toutes les images pertinentes pour les changements d'interface utilisateur._

### Liste de vérification d'accessibilité de l'interface utilisateur

> [!IMPORTANT]
> Si votre PR inclut des modifications de l'interface utilisateur, veuillez utiliser cette liste de vérification :

- [ ] HTML sémantique implémenté ?
- [ ] Prise en charge de l'opérabilité clavier ?
- [ ] Vérifié avec [axe DevTools](https://www.deque.com/axe/) et résolu les problèmes `Critiques` et `Sérieux` ?
- [ ] Contraste des couleurs testé ?

Pour plus d'informations, consultez la
[documentation d'accessibilité de Forem](https://developers.forem.com/frontend/accessibility).

## Tests ajoutés/mis à jour ?

> [!NOTE]
> Nous vous encourageons à maintenir un pourcentage de couverture de code de 80% et plus.

- [ ] Oui
- [ ] Non, et voici pourquoi :
  > _veuillez remplacer cette ligne par des détails sur la raison pour laquelle les tests n'ont pas été inclus_
- [ ] J'ai besoin d'aide pour écrire des tests
