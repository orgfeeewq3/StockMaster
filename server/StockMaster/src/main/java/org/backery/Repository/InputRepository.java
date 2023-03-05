package org.backery.Repository;

import org.backery.Model.Entities.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {
    //dejando vacio ya que me comentaste que te querias encargar de la logica de input y output
    //igual, si queres que te ayude, con gusto, solo me decis!
}
