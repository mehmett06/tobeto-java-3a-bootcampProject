package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.BootcampService;
import com.tobeto.bootcampproject.business.request.create.bootcamp.CreateBootcampRequest;
import com.tobeto.bootcampproject.business.request.update.BootcampUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcamp.CreateBootcampResponse;
import com.tobeto.bootcampproject.business.responses.get.application.GetApplicationResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcamp.GetAllBootcampResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcamp.GetBootcampResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.update.BootcampUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
import com.tobeto.bootcampproject.model.entities.Application;
import com.tobeto.bootcampproject.model.entities.Bootcamp;
import com.tobeto.bootcampproject.repository.BootcampRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DataResults<List<GetAllBootcampResponse>> getByAll() {
        List<Bootcamp>bootcamps=bootcampRepository.findAll();

        List<GetAllBootcampResponse> allBootcampResponses=
                bootcamps.stream().map(bootcamp -> modelMapperService
                        .forResponse()
                        .map(bootcamp, GetAllBootcampResponse.class))
                        .collect(Collectors.toList());

        return new
                SuccessDataResult<List<GetAllBootcampResponse>>
                (allBootcampResponses,"Tüm Bootcamp Id'ler sıralandı.");

    }

    @Override
    public DataResults<BootcampUpdateResponse> updateRequest(BootcampUpdateRequest request, int id) {
        Bootcamp bootcamp=bootcampRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bulunumadı."));

        Bootcamp bootcampUpdate=modelMapperService.forRequest()
                .map(request,Bootcamp.class);

        bootcamp.setName(bootcampUpdate.getName() != null ? bootcampUpdate.getName() : bootcamp.getName());
        bootcamp.setInstructor(bootcampUpdate.getInstructor() != null ? bootcampUpdate.getInstructor() : bootcamp.getInstructor());
        bootcamp.setStartDate(bootcampUpdate.getStartDate() != null ? bootcampUpdate.getStartDate() : bootcamp.getStartDate());
        bootcamp.setEndDate(bootcampUpdate.getEndDate() != null ? bootcampUpdate.getEndDate() : bootcamp.getEndDate());
        bootcamp.setBootcampState(bootcampUpdate.getBootcampState() != null ? bootcampUpdate.getBootcampState() : bootcamp.getBootcampState());
        bootcamp.setUpdateDate(LocalDateTime.now());
        bootcampRepository.save(bootcamp);

        BootcampUpdateResponse response = modelMapperService.forResponse()
                .map(bootcamp, BootcampUpdateResponse.class);

        return new SuccessDataResult<BootcampUpdateResponse>
                (response, "Bootcamp başarıyla değiştirildi.");

    }

    @Override
    public Result deleteBootcamp(int id) {
        bootcampRepository.deleteById(id);
        return new SuccessResult("Bootcamp Delete");
    }
}
