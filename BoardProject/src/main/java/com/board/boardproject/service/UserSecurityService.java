package com.board.boardproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.board.boardproject.domain.UserAccount;
import com.board.boardproject.domain.constant.UserRole;
import com.board.boardproject.repository.UserSecurityRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {
    private final UserSecurityRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserAccount> _userAccount = this.userAccountRepository.findByUserId(username);
        if (_userAccount.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        UserAccount userAccount = _userAccount.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        return new User(userAccount.getUserId(), userAccount.getUserPassword(), authorities);
    }
}
