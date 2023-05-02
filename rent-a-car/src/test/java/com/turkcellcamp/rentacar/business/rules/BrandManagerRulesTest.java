package com.turkcellcamp.rentacar.business.rules;

import com.turkcellcamp.rentacar.core.exceptions.EntityAlreadyExistsException;
import com.turkcellcamp.rentacar.core.exceptions.EntityNotFoundException;
import com.turkcellcamp.rentacar.repository.BrandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;
class BrandManagerRulesTest {
    private BrandManagerRules brandManagerRules;
    private BrandRepository repository;

    @BeforeEach
    public void setUp(){
        repository = mock(BrandRepository.class);
        brandManagerRules = new BrandManagerRules(repository);
    }

    @Test
    void testCheckIfBrandExists_WithId_thenThrowEntityNotFoundException(){
       int id = 1;

       when(repository.existsById(id)).thenReturn(false);

       assertThrows(EntityNotFoundException.class,
               ()-> brandManagerRules.checkIfBrandExists(id));
    }

    @Test
    void testCheckIfBrandExists_WithId(){
        int id = 1;

        when(repository.existsById(id)).thenReturn(true);

        brandManagerRules.checkIfBrandExists(id);
    }

    @Test
    void testCheckIfBrandExistsByName_WithName(){
        String name = "LG";

        when(repository.existsBrandByNameIgnoreCase(name)).thenReturn(false);

        brandManagerRules.checkIfBrandExistsByName(name);
    }

    @Test
    void testCheckIfBrandExistsByName_WithName_thenThrowEntityAlreadyExistsException(){
        String name = "Apple";

        when(repository.existsBrandByNameIgnoreCase(name)).thenReturn(true);

        assertThrows(EntityAlreadyExistsException.class, () -> brandManagerRules.checkIfBrandExistsByName(name));

        verify(repository).existsBrandByNameIgnoreCase(name);
    }
}