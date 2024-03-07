package com.tobeto.bootcampproject.business.abstracts;

import com.tobeto.bootcampproject.business.responses.get.user.GetAllUserResponse;
import com.tobeto.bootcampproject.business.responses.get.user.GetUserByEmailResponse;
import com.tobeto.bootcampproject.core.utilities.results.DataResults;
import java.util.List;

public interface UserService {
    DataResults<List<GetAllUserResponse>> getAll(

    );
    DataResults<GetUserByEmailResponse> getUserByEmail(
            String email
    );
}
