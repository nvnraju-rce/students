package com.northstar.banking.auth;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface DigitalUserRepository extends JpaRepository<DigitalUser,Long> {
 Optional<DigitalUser> findByUserIdIgnoreCase(String userId);
 @Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select u from DigitalUser u where lower(u.userId)=lower(:userId)") Optional<DigitalUser> findForLogin(@Param("userId") String userId);
}
