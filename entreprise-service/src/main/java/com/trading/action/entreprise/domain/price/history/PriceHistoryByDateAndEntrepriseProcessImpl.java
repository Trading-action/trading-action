package com.trading.action.entreprise.domain.price.history;

import com.trading.action.entreprise.domain.core.AbstractProcessImpl;
import com.trading.action.entreprise.domain.core.Result;
import com.trading.action.entreprise.domain.pojo.Entreprise;
import com.trading.action.entreprise.infra.entity.PriceEntity;
import com.trading.action.entreprise.infra.facade.EntrepriseInfra;
import com.trading.action.entreprise.infra.facade.PriceInfra;

import java.util.List;

public class PriceHistoryByDateAndEntrepriseProcessImpl extends AbstractProcessImpl<PriceHistoryByDateAndEntrepriseInput> implements PriceHistoryByDateAndEntrepriseProcess {
    @Override
    public void validate(PriceHistoryByDateAndEntrepriseInput historyProcessInput, Result result) {
        Entreprise entreprise = entrepriseInfra.findByLibelle(historyProcessInput.getEntrepriseLibelle());
        if(entreprise == null){
            result.addErrorMessage(entrepriseInfra.getMessage("entreprise.not_found"));
        }
        if(!priceInfra.hasOlderPrices(historyProcessInput.getEntrepriseLibelle(), historyProcessInput.getDate())){
            result.addErrorMessage(priceInfra.getMessage("price.not_found.old"));
        }
    }

    @Override
    public void run(PriceHistoryByDateAndEntrepriseInput historyProcessInput, Result result) {
        List<PriceEntity> prices = priceInfra.findPrixHistoryByDateAndEntreprise(historyProcessInput.getDate(),historyProcessInput.getEntrepriseLibelle());
        result.setOutput(prices);
    }
    private EntrepriseInfra entrepriseInfra;
    private PriceInfra priceInfra;
    public PriceHistoryByDateAndEntrepriseProcessImpl(EntrepriseInfra entrepriseInfra, PriceInfra priceInfra){
        this.entrepriseInfra = entrepriseInfra;
        this.priceInfra = priceInfra;
    }
}
