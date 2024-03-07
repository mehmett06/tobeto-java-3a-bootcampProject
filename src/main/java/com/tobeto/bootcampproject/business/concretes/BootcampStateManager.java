package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.BootcampStateService;
import com.tobeto.bootcampproject.business.request.create.bootcampState.CreateBootcampStateRequest;
import com.tobeto.bootcampproject.business.request.update.BootcampStateUpdateRequest;
import com.tobeto.bootcampproject.business.responses.create.bootcampState.CreateBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetAllBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.get.bootcampState.GetBootcampStateResponse;
import com.tobeto.bootcampproject.business.responses.update.BootcampStateUpdateResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Result;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessResult;
import com.tobeto.bootcampproject.model.entities.BootcampState;
import com.tobeto.bootcampproject.repository.BootcampStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public DataResults<List<GetAllBootcampStateResponse>> getByAll() {
        List<BootcampState> bootcampStates=bootcampStateRepository.findAll();

        List<GetAllBootcampStateResponse>allBootcampStateResponses=
                bootcampStates.stream().map(bootcampState -> modelMapperService
                        .forResponse()
                        .map(bootcampState,GetAllBootcampStateResponse.class))
                        .collect(Collectors.toList());
        return new
                SuccessDataResult<List<GetAllBootcampStateResponse>>
                (allBootcampStateResponses,"Tüm BootcampState Id'ler sıralandı");



    }

    @Override
    public DataResults<BootcampStateUpdateResponse> updateRequest(BootcampStateUpdateRequest request, int id) {
        BootcampState bootcampState=bootcampStateRepository.findById(id).orElseThrow(()-> new RuntimeException("Id bulunumadı."));

        BootcampState bootcampStateUpdate=modelMapperService.forRequest()
                .map(request,BootcampState.class);

        bootcampState.setName(bootcampStateUpdate.getName() != null ? bootcampStateUpdate.getName() : bootcampState.getName());
        bootcampState.setUpdateDate(LocalDateTime.now());
        bootcampStateRepository.save(bootcampState);

        BootcampStateUpdateResponse response = modelMapperService.forResponse()
                .map(bootcampState, BootcampStateUpdateResponse.class);

        return new SuccessDataResult<BootcampStateUpdateResponse>
                (response, "BootcampState başarıyla değiştirildi.");
    }

    @Override
    public Result deleteBootcampState(int id) {
        bootcampStateRepository.deleteById(id);
        return new SuccessResult("Bootcamp Delete");
    }
}
