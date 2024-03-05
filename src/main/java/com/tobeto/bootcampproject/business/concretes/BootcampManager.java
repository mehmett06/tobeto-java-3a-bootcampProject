package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.BootcampService;
import com.tobeto.bootcampproject.business.request.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcamp.GetBootcampResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.Application;
import com.tobeto.bootcampproject.model.entities.Bootcamp;
import com.tobeto.bootcampproject.repository.BootcampRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BootcampManager implements BootcampService {
    private ModelMapperService modelMapperService;
    private BootcampRepository bootcampRepository;
    @Override
    public DataResults<CreateBootcampResponse> createBootcampResponse(CreateBootcampRequest createBootcampRequest) {
        Bootcamp bootcampToCreate=modelMapperService.forRequest()
                .map(createBootcampRequest,Bootcamp.class);

        bootcampToCreate.setCreatedDate(LocalDateTime.now());

        bootcampRepository.save(bootcampToCreate);

        CreateBootcampResponse response=modelMapperService.forResponse()
                .map(bootcampToCreate,CreateBootcampResponse.class);

        return new SuccessDataResult<CreateBootcampResponse>
                (response,"Bootcamp Created");
    }

    @Override
    public DataResults<GetBootcampResponse> getById(int id) {
        Bootcamp getByIdBootcamp=bootcampRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetBootcampResponse response = modelMapperService.forResponse()
                .map(getByIdBootcamp, GetBootcampResponse.class);

        return new
                SuccessDataResult<GetBootcampResponse>
                (response,"Bootcamp Id bulundu");
    }
}
