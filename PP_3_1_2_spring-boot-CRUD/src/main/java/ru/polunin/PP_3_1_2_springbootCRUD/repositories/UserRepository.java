package ru.polunin.PP_3_1_2_springbootCRUD.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.polunin.PP_3_1_2_springbootCRUD.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
