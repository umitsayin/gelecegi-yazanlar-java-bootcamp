package com.turkcellcamp.rentacar.business.concretes;

import com.turkcellcamp.rentacar.business.abstracts.ModelService;
import com.turkcellcamp.rentacar.business.dto.requests.create.CreateModelRequest;
import com.turkcellcamp.rentacar.business.dto.requests.update.UpdateModelRequest;
import com.turkcellcamp.rentacar.business.dto.responses.create.CreateModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetAllModelsResponse;
import com.turkcellcamp.rentacar.business.dto.responses.get.GetModelResponse;
import com.turkcellcamp.rentacar.business.dto.responses.update.UpdateModelResponse;
import com.turkcellcamp.rentacar.business.rules.ModelManagerRules;
import com.turkcellcamp.rentacar.entities.Model;
import com.turkcellcamp.rentacar.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private final ModelRepository repository;
    private final ModelMapper modelMapper;
    private final ModelManagerRules rules;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = repository.findAll();
        List<GetAllModelsResponse> response = models.stream()
                .map(model -> modelMapper.map(model, GetAllModelsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetModelResponse getById(int id) {
        rules.checkIfModelExistsById(id);

        Model model = repository.findById(id).orElseThrow();
        GetModelResponse response = modelMapper.map(model, GetModelResponse.class);

        return response;
    }

    @Override
    public CreateModelResponse add(CreateModelRequest request) {
        rules.checkIfModelExistsByName(request.getName());

        Model model = modelMapper.map(request, Model.class);
        model.setId(0);
        repository.save(model);
        CreateModelResponse response = modelMapper.map(model,CreateModelResponse.class);

        return response;
    }

    @Override
    public UpdateModelResponse update(int id, UpdateModelRequest request) {
        rules.checkIfModelExistsById(id);

        Model model = modelMapper.map(request, Model.class);
        model.setId(id);
        repository.save(model);

        UpdateModelResponse response = modelMapper.map(model,UpdateModelResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        rules.checkIfModelExistsById(id);
        repository.deleteById(id);
    }
}
