package com.libraryproject.libraryproject.service.impl;

import com.libraryproject.libraryproject.dto.UserDto;
import com.libraryproject.libraryproject.entity.User;
import com.libraryproject.libraryproject.entity.UserAccount;
import com.libraryproject.libraryproject.repository.AccountRepository;
import com.libraryproject.libraryproject.repository.UserRepository;
import com.libraryproject.libraryproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor//burda Dependency Injection yaptık:Spring, UserRepository sınıfını nesnensini otomatik algıladı
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user= new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        final User userDb = userRepository.save(user);
        List<UserAccount> list=new ArrayList<>();
        userDto.getUserAccounts().forEach(item->{
            UserAccount userAccount=new UserAccount();
            userAccount.setAdress(item);
            userAccount.setAdressType(UserAccount.AdressType.OTHER);
            userAccount.setIsUserActive(true);
            userAccount.setUser(userDb);
            list.add(userAccount);
        });
        accountRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users= userRepository.findAll();
        List<UserDto> userDtos=new ArrayList<>();
        users.forEach(it->{
            UserDto userDto=new UserDto();
            userDto.setId(it.getId());
            userDto.setFirstname(it.getFirstname());
            userDto.setLastname(it.getLastname());
            userDto.setUserAccounts(it.getUserAccounts().stream().map(UserAccount::getAdress)
                    .collect(Collectors.toList())

            );
            userDtos.add(userDto);


        });

        return userDtos;
    }


    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
