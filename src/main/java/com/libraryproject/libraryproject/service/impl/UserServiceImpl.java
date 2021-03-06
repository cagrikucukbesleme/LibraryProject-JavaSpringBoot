package com.libraryproject.libraryproject.service.impl;

import com.libraryproject.libraryproject.dto.AccountDto;
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
@RequiredArgsConstructor//burada Dependency Injection yaptık:Spring, UserRepository sınıfını nesnensini otomatik algıladı
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;


    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user= new User();

        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setIsUserActive(userDto.getIsUserActive());
        final User userDb = userRepository.save(user);
        List<UserAccount> list=new ArrayList<>();
        UserAccount userAccount=new UserAccount();
        userDto.getUserAccounts().forEach(item->{
            UserAccount userAccount1=new UserAccount();
            userAccount1.setUserBooks(item);
            //userAccount1.setBookType(Enum.valueOf(UserAccount.bookType.POEMS));
//            userAccount1.setIsUserActive(Boolean.getBoolean(item));
            userAccount1.setUser(userDb);
            list.add(userAccount1);
        });
        accountRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    @Transactional
    public UserDto updateData(UserDto userDto) {
        User user=new User();

        user=userRepository.getById(userDto.getId());
        final  UserDto userDto1=new UserDto();
        userDto1.setId(user.getId());
        userDto1.setFirstname(user.getFirstname());
        userDto1.setLastname(user.getLastname());
        userDto1.setIsUserActive(user.getIsUserActive());

        return userDto1;
    }

//    @Override
//    @Transactional
//    public AccountDto save(AccountDto accountDto) {
//        UserAccount userAccount =new UserAccount();
//        userAccount.setUserBooks(accountDto.getUserBooks());
//        userAccount.setIsUserActive(accountDto.getIsUserActive());
//        userAccount.setBookType(accountDto.getBookType());
//        UserAccount userAccount1=accountRepository.save(userAccount);
//        accountDto.setId(userAccount1.getId());
//        return accountDto;
//    }

    @Override
    @Transactional
    public void delete(long id) {
        User user=new User();
        userRepository.deleteById(id);

    }

    @Override
    @Transactional
    public List<UserDto> getAll() {
        List<User> users= userRepository.findAll();
        List<UserDto> userDtos=new ArrayList<>();
        users.forEach(it->{
            UserDto userDto=new UserDto();
            userDto.setId(it.getId());
            userDto.setFirstname(it.getFirstname());
            userDto.setLastname(it.getLastname());
            userDto.setUserAccounts(it.getUserAccounts().stream().map(UserAccount::getUserBooks)
                    .collect(Collectors.toList())
            );
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    @Transactional
    public UserDto getDataById(long id) {
        User user=new User();
        UserDto userDto=new UserDto();
        user=userRepository.getById(id);

        userDto.setId(user.getId());
        return userDto;
    }


    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
