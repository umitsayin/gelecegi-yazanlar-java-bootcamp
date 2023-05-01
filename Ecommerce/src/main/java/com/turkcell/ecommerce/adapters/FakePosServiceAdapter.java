package com.turkcell.ecommerce.adapters;

import com.turkcell.ecommerce.service.PosService;
import org.springframework.stereotype.Service;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {

    }
}
