package com.tobeto.bootcampproject.business.concretes;

import com.tobeto.bootcampproject.business.abstracts.UserService;
import com.tobeto.bootcampproject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampproject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampproject.core.utilities.mapper.ModelMapperService;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import com.tobeto.bootcampproject.core.utilities.results.Success.SuccessDataResult;
import com.tobeto.bootcampproject.model.entities.User;
import com.tobeto.bootcampproject.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResults<List<GetAllUserResponse>> getAll() {
        List <User> users = userRepository.findAll();

        List <GetAllUserResponse> userResponses = users.stream().map(user->
                mapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<>(userResponses, "Tüm Userlar Listelendi");
    }

    @Override
    public DataResults<GetUserByEmailResponse> getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        GetUserByEmailResponse response = mapperService.forResponse()
                .map(user, GetUserByEmailResponse.class);

        return new SuccessDataResult
                <GetUserByEmailResponse>
                (response, "User Email Tarafından Listelendi");
    }
}
