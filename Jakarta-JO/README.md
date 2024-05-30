# Projet Jakarta-Jo - *Bellanger.N, Zivkovic.N*

## Acheteur 
**Créer un acheteur**
- POST /api/acheteurs
- Body: { "name": "Til", "firstname": "Jean" }

**Lire un acheteur**
- GET /api/acheteurs/{uuid}

**Mettre à jour un acheteur**
- PUT /api/acheteurs/{uuid}
- Body: { "name": "Til", "firstname": "Jean" }

**Supprimer un acheteur**
- DELETE /api/acheteurs/{id}

## Billet
**Créer un billet**
- POST /api/billets
- Body: { "name": "Jean", "price": 49.99 }

**Lire un billet**
- GET /api/billets/{uuid}

**Mettre à jour un billet**
- PUT /api/billets/{uuid}
- Body: { "name": "Jean", "price": 49.99 }

**Supprimer un billet**
- DELETE /api/billets/{uuid}

## Epreuve
**Créer une épreuve**
- POST /api/epreuves
- Body: { "name": "Finale 100m", "dateEpreuve": "20204-12-05T12:00:00.00" }

**Lire une épreuve**
- GET /api/epreuves/{uuid}
  
**Mettre à jour une épreuve**
- PUT /api/epreuves/{id}
- Body: { "name": "Finale 100m", "dateEpreuve": "20204-12-05T12:00:00.00" }
  
**Supprimer une épreuve**
- DELETE /api/epreuves/{uuid}

## Stade
**Créer un stade**
- POST /api/stades
- Body: { "name": "Stade de France", "adresse": "Saint-Denis" }
  
**Lire un stade**
- GET /api/stades/{uuid}
  
**Mettre à jour un stade**
- PUT /api/stades/{uuid}
- Body: { "name": "Stade de France", "adresse": "Saint-Denis" }
  
**Supprimer un stade**
- DELETE /api/stades/{uuid}
