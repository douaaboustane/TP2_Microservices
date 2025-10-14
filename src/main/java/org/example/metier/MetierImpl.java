package org.example.metier;

import org.example.dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("metier")  // Déclare cette classe comme un bean Spring avec l'identifiant "metier"
public class MetierImpl implements IMetier {

    // Injection de dépendance : Spring injectera automatiquement une implémentation de IDao
    @Autowired
    @Qualifier("dao2")  // Spécifie quelle implémentation de IDao utiliser
    private IDao dao;  // Par défaut, Spring injectera le premier bean compatible trouvé
    @Override
    public double calcul() {
        return dao.getValue() * 2;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
