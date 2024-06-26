package com.youlpring.jws.db;


import com.youlpring.jws.common.codeAndMessage.ErrorCodeAndMessage;
import com.youlpring.jws.common.exception.UserRegisterException;
import com.youlpring.jws.model.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository {

    private static final Logger log = LoggerFactory.getLogger(InMemoryUserRepository.class);

    private static final Map<String, User> database = new ConcurrentHashMap<>();
    private static AtomicLong atomicId = new AtomicLong();

    private InMemoryUserRepository() {}

    public static void save(User user) {
        database.compute(user.getAccount(), (key, existUser) -> {
            if (existUser != null) {
                throw new UserRegisterException(ErrorCodeAndMessage.ALREADY_EXISTED_USER);
            }
            if (user.getId() == null) {
                user.setId(incrementAtomicId());
            }
            return user;
        });
    }

    private static Long incrementAtomicId() {
        return atomicId.incrementAndGet();
    }

    public static User findByAccount(String account) {
        return Optional.ofNullable(database.get(account)).orElse(null);
    }

    public static void deleteUser(String account) {
        database.remove(account);
    }

    public static void clear() {
        database.clear();
    }
}
