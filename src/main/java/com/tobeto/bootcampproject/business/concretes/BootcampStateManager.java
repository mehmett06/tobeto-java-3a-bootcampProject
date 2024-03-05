package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetBootcampStateResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.BootcampState;
import com.tobeto.bootcampproject.repository.BootcampStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private ModelMapperService modelMapperService;
    private BootcampStateRepository bootcampStateRepository;
    @Override
    public DataResults<CreateBootcampStateResponse> create(CreateBootcampStateRequest createBootcampStateRequest) {
        BootcampState bootcampStateToCreate=modelMapperService.forRequest()
                .map(createBootcampStateRequest,BootcampState.class);

        bootcampStateRepository.save(bootcampStateToCreate);

        CreateBootcampStateResponse response=modelMapperService.forResponse()
                .map(bootcampStateToCreate,CreateBootcampStateResponse.class);

        return new SuccessDataResult<CreateBootcampStateResponse>
                (response,"BootcampState Created");
    }

    @Override
    public DataResults<GetBootcampStateResponse> getById(int id) {
        BootcampState getByIdBootcampState=bootcampStateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id bulunamadı."));

        GetBootcampStateResponse response=modelMapperService.forResponse()
                .map(getByIdBootcampState,GetBootcampStateResponse.class);
        return new SuccessDataResult<GetBootcampStateResponse>
                (response,"BootcampState Id bulundu");

    }
}
