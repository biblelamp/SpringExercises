package swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swagger.domain.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    @Query("SELECT u FROM SysUser u WHERE u.id = ?1")
    SysUser getUser(Integer id);

    @Query("SELECT u FROM SysUser u")
    SysUser getUser(Integer id, Integer groupId);
}
