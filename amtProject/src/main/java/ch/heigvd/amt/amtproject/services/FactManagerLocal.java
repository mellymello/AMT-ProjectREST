/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.amtproject.services;

import ch.heigvd.amt.amtproject.model.Fact;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Zak
 */
@Local
public interface FactManagerLocal {
    Fact findFactById(long factId);

    List<Fact> findAllFacts();

    long createFact(Fact fact);

    void updateFact(Fact fact);

    void deleteFact(long userId);
}
