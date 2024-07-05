package br.com.walkito.fichaOnline.model.specifications;

import br.com.walkito.fichaOnline.model.entities.PlayerSheet;
import org.springframework.data.jpa.domain.Specification;

public class PlayerSheetSpecifications {

    public static Specification<PlayerSheet> filterByAccountId(int idAccount){
        return (root, query, criteriaBuilder) -> {
            if(idAccount == 0){
                return criteriaBuilder.conjunction();
            } else {
                return criteriaBuilder.equal(root.get("account").get("id"), idAccount);
            }
        };
    }

    public static Specification<PlayerSheet> filterByRunId(int idRun){
        return (root, query, criteriaBuilder) -> {
            if(idRun == 0){
                return criteriaBuilder.conjunction();
            } else {
                return criteriaBuilder.equal(root.get("run").get("id"), idRun);
            }
        };
    }
}
